package com.news.auth.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.auth.encryption.EncryptionUtil;

@RestController
public class GeneralController {

	@GetMapping("/publicKey")
	public String getPublicKey() {
		return EncryptionUtil.getPublicKey();
	}
}
