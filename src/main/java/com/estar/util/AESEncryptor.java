package com.estar.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

public class AESEncryptor { 
	public static final String VIPARA = "0102030405060708";  
	public static final String CODE = "GBK"; 
	public static final String SEEK = "gzxcxxxtgcyxgs01"; 
	
	/**
	 * 加密
	 * @Title: encrypt 
	 * @Description: TODO
	 * @param @param seek
	 * @param @param cleartext
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	public static String encrypt(String seek, String cleartext)  
	        throws Exception {  
	    IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());  
	    SecretKeySpec key = new SecretKeySpec(seek.getBytes(), "AES");  
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
	    cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);  
	    byte[] encryptedData = cipher.doFinal(cleartext.getBytes(CODE));  
	  
	    return Base64.encode(encryptedData);  
	}  
	
	/**
	 * @throws Exception 
	 * 加密
	 * @Title: encrypt 
	 * @Description: TODO
	 * @param @param seek
	 * @param @param cleartext
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	@Test
	public void encrypt() throws Exception {
//		//System.out.println(encrypt("gzxcxxxtgcyxgs01","jdbc:mysql://192.168.100.3:3306/bdcs?useUnicode=true&characterEncoding=UTF-8"));  
//		System.out.println(encrypt("gzxcxxxtgcyxgs01","jdbc:mysql://192.168.100.3:3306/bdcs?useUnicode=true&characterEncoding=UTF-8"));  
////		GCXLME2GtUcYuPxYWIWPlV8$0Vxka3lXwwiYf5Ubn8G66EwyhRA3UXQSZLbY 3MwOOblS6AOh26B9sDgeSrJqiaPWRYunMoObzXDCnWd6C$A=
//		System.out.println(encrypt("gzxcxxxtgcyxgs01","jdbc:mysql://127.0.0.1:3306/bdcs?useUnicode=true&characterEncoding=UTF-8"));  
////		5rrvR9vHwgQFVeHwHjW5m$nBAtXMoY2a1Wg4nVj1UdSaQwtrJHch!7AQCllJ oeNKdy6gUU8mxzlnDJiZD4sOA0Vugqq50UZ2GOylHdRMk44=
//		System.out.println(encrypt("gzxcxxxtgcyxgs01","jdbc:mysql://192.168.100.26:3306/bdcs?useUnicode=true&characterEncoding=UTF-8"));  

		
	    System.out.println(encrypt("gzxcxxxtgcyxgs01","jdbc:mysql://192.168.100.19:3306/bdcs"));  
	    System.out.println(encrypt("gzxcxxxtgcyxgs01","root"));  

//		
//		
//		System.out.println(encrypt("gzxcxxxtgcyxgs01","1228611602"));   
//		//System.out.println(encrypt("gzxcxxxtgcyxgs01","52csr.com"));   
//		System.out.println(encrypt("gzxcxxxtgcyxgs01","wx317d66e54c054ea0"));  
//		System.out.println(encrypt("gzxcxxxtgcyxgs01","1ee6081c24a2dc3121a6d82dbb07135e"));   
//		System.out.println(encrypt("gzxcxxxtgcyxgs01","DCFCB32C44B7423681BE38EACEB3579A"));
	}
	  
	/**
	 * 解密
	 * @Title: decrypt 
	 * @Description: TODO
	 * @param @param seek
	 * @param @param encrypted
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	public static String decrypt(String seek, String encrypted) throws Exception {  
	    byte[] byteMi = Base64.decode(encrypted);  
	    IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());  
	    SecretKeySpec key = new SecretKeySpec(seek.getBytes(), "AES");  
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
	    cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);  
	    byte[] decryptedData = cipher.doFinal(byteMi);  
	  
	    return new String(decryptedData,CODE);  
	}  
} 
