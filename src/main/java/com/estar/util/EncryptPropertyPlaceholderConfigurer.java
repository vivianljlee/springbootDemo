package com.estar.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] encryptPropNames = {"url", "username", "password" };
//	private String[] encryptPropNames = {};
	private String code = "gzxcxxxtgcyxgs01";

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		
		// 如果在加密属性名单中发现该属性
		if (isEncryptProp(propertyName)) {
			String decryptValue = "";
			try {
				decryptValue = AESEncryptor.decrypt(code, propertyValue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(decryptValue);
			return decryptValue == "" ? propertyValue : decryptValue;
		} else {
			return propertyValue;
		}
	}

	private boolean isEncryptProp(String propertyName) {
		for (String encryptName : encryptPropNames) {
			if (encryptName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}