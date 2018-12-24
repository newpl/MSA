package com.news.auth.encryption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class EncryptionUtil {
	private static MessageDigest digest;
	static {
		try {
			digest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String encryptSHA256(String input) {
		String ret = input;
		try {
			digest.reset();
			digest.update(input.getBytes("utf-8"));
			ret = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public static String encryptRSA(String value) {
		return RSAModule.getRSAValue(Base64.encodeBase64(value.getBytes()), Cipher.ENCRYPT_MODE);
	}
	
	public static String decryptRSA(String value) {
		return RSAModule.getRSAValue(Base64.decodeBase64(value.getBytes()), Cipher.DECRYPT_MODE);
	}
	
	public static String getPublicKey() {
		return RSAModule.getPublicKey();
	}
}
