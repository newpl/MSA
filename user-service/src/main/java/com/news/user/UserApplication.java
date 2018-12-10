package com.news.user;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class UserApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword("BRACE_PASS"); // 2번 설정의 암호화 키를 입력

		String enc = pbeEnc.encrypt("jdbc:mariadb://52.79.160.37:3306/user?autoreconnect=true"); // 암호화 할 내용
		System.out.println("url = " + enc); // 암호화 한 내용을 출력

		// 테스트용 복호화
		String des = pbeEnc.decrypt(enc);
		System.out.println("des = " + des);
		
		enc = pbeEnc.encrypt("newpl"); // 암호화 할 내용
		System.out.println("id = " + enc); // 암호화 한 내용을 출력

		// 테스트용 복호화
		des = pbeEnc.decrypt(enc);
		System.out.println("des = " + des);
		
		enc = pbeEnc.encrypt("sbvmf!1"); // 암호화 할 내용
		System.out.println("pw = " + enc); // 암호화 한 내용을 출력

		// 테스트용 복호화
		des = pbeEnc.decrypt(enc);
		System.out.println("des = " + des);
	}
}
