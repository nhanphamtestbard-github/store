package com.vn.store.common.utils;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256 {

	private static final int KEY_LENGTH = 256;

	private static final int ITERATION_COUNT = 65536;

	private static final String SECRETKEYFACTORY = "PBKDF2WithHmacSHA256";
	private static final String SECRETKEY = "MySecretKey";
	private static final String SALT = "salt";

	public static String encrypt(String strToEncrypt, String secretKey, String salt) {

		try {

			SecureRandom secureRandom = new SecureRandom();
			byte[] iv = new byte[16];
			secureRandom.nextBytes(iv);
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRETKEYFACTORY);
			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENGTH);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);

			byte[] cipherText = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
			byte[] encryptedData = new byte[iv.length + cipherText.length];
			System.arraycopy(iv, 0, encryptedData, 0, iv.length);
			System.arraycopy(cipherText, 0, encryptedData, iv.length, cipherText.length);

			return Base64.getEncoder().encodeToString(encryptedData);
		} catch (Exception e) {
			// Handle the exception properly
			e.printStackTrace();
			return null;
		}
	}

	public static String decrypt(String strToDecrypt, String secretKey, String salt) {

		try {

			byte[] encryptedData = Base64.getDecoder().decode(strToDecrypt);
			byte[] iv = new byte[16];
			System.arraycopy(encryptedData, 0, iv, 0, iv.length);
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRETKEYFACTORY);
			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), ITERATION_COUNT, KEY_LENGTH);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);

			byte[] cipherText = new byte[encryptedData.length - 16];
			System.arraycopy(encryptedData, 16, cipherText, 0, cipherText.length);

			byte[] decryptedText = cipher.doFinal(cipherText);
			return new String(decryptedText, "UTF-8");
		} catch (Exception e) {
			// Handle the exception properly
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		String secretKey = SECRETKEY;
		String salt = SALT;

		// Encrypt the string
		String host = AES256.encrypt("localhost", secretKey, salt);
		String port = AES256.encrypt("5432", secretKey, salt);
		String dbname = AES256.encrypt("store", secretKey, salt);
		String schema = AES256.encrypt("store", secretKey, salt);
		String username = AES256.encrypt("postgres", secretKey, salt);
		String dbpassword = AES256.encrypt("admin", secretKey, salt);
		String placemapperimplUrl = AES256.encrypt("root", secretKey, salt);

		System.out.println("host " + host);
		System.out.println("port " + port);
		System.out.println("dbname " + dbname);
		System.out.println("schema " + schema);
		System.out.println("username " + username);
		System.out.println("dbpassword " + dbpassword);
		System.out.println("placemapperimplUrl " + placemapperimplUrl);

		// System.out.println("=========================================");

		// host = AES256.decrypt("a9Bl6VvIZ8JF8RpQixmNdrFEFSRXxGhWN+Q/wROg6rE=", secretKey, salt);
		// port = AES256.decrypt("KANhZmSr0UyNLBd+/mmUU069MHoztMAevjdRbp9h20k=", secretKey, salt);
		// dbname = AES256.decrypt("zZ/ki5h+UgKN86iLth3/67PopfLtznuWT5/FhjWkLfQ=", secretKey, salt);
		// schema = AES256.decrypt("wJjuI746exj19oSkS2R+1SBz9+in5jighMUK2/1k0qc=", secretKey, salt);
		// username = AES256.decrypt("PTN7eDcIUcno3L3lq+dUDUbRFz2P4zoexpwatGNscqA=", secretKey, salt);
		// dbpassword = AES256.decrypt("d/yy+G0ZMreD0lWgUfT9L77Uee2FexxjdEnx3ut9S0Y=", secretKey, salt);
		// placemapperimplUrl = AES256.decrypt("p26kJReQaZ8nbrEhDSbETN61tGj7pUyYnxbT+ZGJ7RA=", secretKey, salt);

		// System.out.println("host " + host);
		// System.out.println("port " + port);
		// System.out.println("dbname " + dbname);
		// System.out.println("schema " + schema);
		// System.out.println("username " + username);
		// System.out.println("dbpassword " + dbpassword);
		// System.out.println("placemapperimplUrl " + placemapperimplUrl);

	}
}