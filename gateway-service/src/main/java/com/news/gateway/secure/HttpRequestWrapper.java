package com.news.gateway.secure;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.netflix.zuul.http.HttpServletRequestWrapper;

public class HttpRequestWrapper extends HttpServletRequestWrapper {
	/**
	 * requestBody를 담아놓을 변수.
	 * 
	 */
	private byte[] bodyData;

	/**
	 * XSS 관련 변경해야 하는 시작태그 정의. [0]: 변경전 값. [1]: 변경후 값.
	 * 
	 */
	private final String[] LEFT_TAG = { "<", "&lt;" };

	/**
	 * XSS 관련 변경해야 하는 종료태그 정의. [0]: 변경전 값. [1]: 변경후 값.
	 * 
	 */
	private final String[] RIGHT_TAG = { ">", "&gt;" };

	/**
	 * XSS 관련 허용해야 하는 태그를 정의한다. ex. "br", "img", "a", "/a"... 추후 외부 파라미터로 정의 후 읽어오게
	 * 수정할 예정
	 * 
	 */
	private final String[] whiteListArr = { "img", "br" };

	/**
	 * XSS 관련 제거해야 하는 태그 내 속성을 정의한다. ex. "br", "img", "a", "/a"... 추후 외부 파라미터로 정의 후
	 * 읽어오게 수정할 예정
	 * 
	 */
	private final String[] blackListArr = { "onblur", "onchange", "onclick", "ondblclick", "onfocus", "onload",
			"onmouse", "onscroll", "onsubmit", "onunload", "onerror" };

	/**
	 * HttpRequestWrapper 생성자. requestBody를 XSS필터링을 거쳐 재저장
	 * 
	 */
	public HttpRequestWrapper(HttpServletRequest request) {
		super(request);
		String contentType = request.getContentType();

		if (contentType == null) {
			return;
		}
		if (contentType.equals(MediaType.APPLICATION_JSON_VALUE)) {
			bodyData = cleanXSS(getBody(request)).getBytes();
		}
	}

	/**
	 * servlet에서 request.getInputstream호출 시, 기존 생성하며 담아둔 bodyData에서 데이터를 꺼내 return
	 * 
	 */
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream bis = new ByteArrayInputStream(bodyData);
		return new ServletImpl(bis);
	}

	/**
	 * request에서 header 조회 시, XSS 필터링을 거친 header값을 return
	 * 
	 */
	@Override
	public String getHeader(String name) {
		return cleanXSS(super.getHeader(name));
	}

	/**
	 * request에서 parameter 조회 시, XSS 필터링을 거친 parameter값을 return
	 * 
	 */
	@Override
	public String getParameter(String name) {
		return cleanXSS(super.getParameter(name));
	}

	/**
	 * request에서 parameter 조회 시, XSS 필터링을 거친 parameter값을 return
	 * 
	 */
	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values == null || values.length == 0) {
			return values;
		}
		int length = values.length;
		String[] rets = new String[length];
		for (int i = 0; i < length; i++) {
			rets[i] = cleanXSS(values[i]);
		}
		return rets;
	}

	/**
	 * XSS 필터링을 수행한다. String은 바로 whiteList필터링을 수행하며, jsonObject와 jsonArray는 내부 파라미터
	 * 조회를 위해 각각의 cleanXSS 메소드를 호출한다.
	 * 
	 */
	private String cleanXSS(String string) {
		if (string == null || string.trim().equals("")) {
			return string;
		}
		Object obj = string;
		if (string instanceof String) {
			obj = cleanXSSWhiteList(obj.toString());
		} else if (obj instanceof JsonObject) {
			obj = new JsonParser().parse(string);
			obj = jsonObjectCleanXSS((JsonObject) obj);
		} else if (obj instanceof JsonArray) {
			obj = new JsonParser().parse(string);
			obj = jsonArrayCleanXSS((JsonArray) obj);
		}
		return obj.toString();
	}

	/**
	 * jsonArray용 XSS 필터링을 수행한다. array타입이 String이면 whiteList필터링을 수행하며, jsonObject와
	 * jsonArray타입이면 내부 파라미터 조회를 위해 각각의 cleanXSS 메소드를 호출한다.
	 * 
	 */
	private JsonArray jsonArrayCleanXSS(JsonArray jsonArray) {
		int length = jsonArray.size();
		JsonArray ret = new JsonArray(length);
		for (int i = 0; i < length; i++) {
			Object obj = jsonArray.get(i);
			if (obj instanceof String) {
				ret.add(cleanXSSWhiteList(obj.toString()));
			} else if (obj instanceof JsonObject) {
				ret.add(jsonObjectCleanXSS((JsonObject) obj));
			} else if (obj instanceof JsonArray) {
				ret.add(jsonArrayCleanXSS((JsonArray) obj));
			}
		}
		return ret;
	}

	/**
	 * jsonObject용 XSS 필터링을 수행한다. 파라미터의 타입이 String이면 whiteList필터링을 수행하며, jsonObject와
	 * jsonArray타입이면 내부 파라미터 조회를 위해 각각의 cleanXSS 메소드를 호출한다.
	 * 
	 */
	private JsonObject jsonObjectCleanXSS(JsonObject jsonObject) {
		JsonObject ret = new JsonObject();
		for (String key : jsonObject.keySet()) {
			Object val = jsonObject.get(key);
			if (val instanceof String) {
				ret.addProperty(key, cleanXSSWhiteList(val.toString()));
			} else if (val instanceof JsonObject) {
				ret.add(key, jsonObjectCleanXSS((JsonObject) val));
			} else if (val instanceof JsonArray) {
				ret.add(key, jsonArrayCleanXSS((JsonArray) val));
			}
		}
		return ret;
	}

	/**
	 * WhiteList 필터링을 수행한다. 상단에 지정된 whiteListArr에 정의된 태그를 제외한 나머지 <, >를 전부 html
	 * 특수문자로 치환한다.
	 * 
	 */
	private String cleanXSSWhiteList(String value) {
		if (value == null || value.trim().equals("")) {
			return value;
		}
		// <, > 전부 html특수문자로 치환한다.
		value = value.replace(LEFT_TAG[0], LEFT_TAG[1]);
		value = value.replace(RIGHT_TAG[0], RIGHT_TAG[1]);

		// white tag로 지정된 tag만 찾아서, html특수문자를 <, >로 원복시키는 작업을 수행한다.
		for (String whiteTag : whiteListArr) {
			StringBuffer sb = new StringBuffer();
			int startIdx = 0;
			int currIdx = 0;
			int endIdx = 0;
			while (true) {
				// 해당 화이트태그의 위치를 찾는다.
				currIdx = value.indexOf(LEFT_TAG[1] + whiteTag, startIdx);
				if (currIdx < 0) {
					// 화이트태그 없을 시 그대로 종료
					break;
				}
				// 현재위치부터 화이트태그 발견위치까지 String에 추가한다.
				sb.append(value.substring(startIdx, currIdx) + LEFT_TAG[0] + whiteTag);
				// 현재위치를 화이트태그 이후로 조정한다.
				startIdx = currIdx + (LEFT_TAG[1] + whiteTag).length();
				// 현재위치로부터 가장 가까이 있는 종료태그를 찾아 종료위치를 재설정한다.
				endIdx = value.indexOf(RIGHT_TAG[1], startIdx);
				if (endIdx < 0) {
					// 종료태그가 없을 시, 더 이상 살릴 태그가 없으므로 종료한다.
					break;
				}
				// 시작위치부터 종료위치까지가 현재 찾은 white태그의 내용이다.
				// 허용하면 안되는 속성이 있을 수 있으니 blackList필터링을 수행한 후 결과를 String에 추가한다.
				sb.append(cleanXSSBlackListTag(value.substring(startIdx, endIdx)) + RIGHT_TAG[0]);
				// 현재 위치를 화이트태그 종료태그 이후로 조정한다.
				startIdx = endIdx + RIGHT_TAG[1].length();
			}
			// 현재위치 이후로는 아직 추가가 안되었으니 String에 추가한다.
			sb.append(value.substring(startIdx));
			value = sb.toString();
		}
		return value;
	}

	/**
	 * BlackList 필터링을 수행한다. 상단에 지정된 blackListArr에 정의된 속성을 가지지 못하도록, 'x-'를 붙여 속성무효화를
	 * 시킨다.
	 * 
	 */
	private String cleanXSSBlackListTag(String value) {
		if (value == null || value.trim().equals("")) {
			return value;
		}
		String ret = value.toLowerCase();
		boolean changed = false;
		for (String blackTag : blackListArr) {
			if (ret.contains(blackTag)) {
				ret = ret.replaceAll(blackTag, "x-" + blackTag);
				changed = true;
			}
		}
		if (changed) {
			return ret;
		} else {
			return value;
		}
	}

	/**
	 * BlackList 필터링을 수행한다. 상단에 지정된 blackListArr에 정의된 속성을 가지지 못하도록, 'x-'를 붙여 속성무효화를
	 * 시킨다.
	 * 
	 */
	private String getBody(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;

		InputStream is = null;

		try {
			is = request.getInputStream();
			if (is != null) {
				br = new BufferedReader(new InputStreamReader(is));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = br.read(charBuffer)) > 0) {
					sb.append(charBuffer, 0, bytesRead);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
