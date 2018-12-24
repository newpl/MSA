package com.news.auth.encryption;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;


public class RSAModule {
	private static KeyPairGenerator keyPairGenerator;
	private static Key publicKey;
	private static Key privateKey;
	
	private static final String ALGORITHM_NM = "RSA";
	
	static {
		try {
			keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_NM);
			keyPairGenerator.initialize(2048);
			KeyPair keyPair = keyPairGenerator.genKeyPair();
			publicKey = keyPair.getPublic();
			privateKey = keyPair.getPrivate();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	static String getRSAValue(byte[] value, int mode) {
		Cipher cipher;
		String ret = new String(value);
		try {
			cipher = Cipher.getInstance(ALGORITHM_NM);
			if(mode==Cipher.ENCRYPT_MODE) {
				cipher.init(mode, publicKey);
			}else if(mode==Cipher.DECRYPT_MODE) {
				cipher.init(mode, privateKey);
			}
			ret = new String(cipher.doFinal(value));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	static String getPublicKey() {
		return Base64.encodeBase64String(publicKey.getEncoded());
	}
}
