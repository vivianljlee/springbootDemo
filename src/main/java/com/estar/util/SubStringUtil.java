package com.estar.util;

public class SubStringUtil {
	// -----截取第 N个 字符之后字符（不带截取的字符）
	public static String subWithOutChar(String str, String ch, int sum) {

		for (int i = 0; i < sum; i++) {
			str = str.substring(str.indexOf(ch) + 1, str.length());
		}

		return str;
	}

	// -----截取第 N个 字符之后字符（带截取的字符）
	public static String subWithChar(String str, String ch, int sum) {

		for (int i = 0; i < sum; i++) {
			str = str.substring(str.indexOf(ch) + 1, str.length());
		}

		return ch + str;
	}

	// -----截取倒数第 N个 字符之后字符（不带截取的字符）
	public static String subLastWithOutChar(String str, String ch, int sum) {
		String t = str;
		for (int i = 0; i < sum; i++) {
			t = t.substring(0, t.lastIndexOf(ch));
		}

		return str.substring(t.length() + 1, str.length());
	}

	// -----截取倒数第 N个 字符之后字符（带截取的字符）
	public static String subLastWithChar(String str, String ch, int sum) {

		String t = str;
		for (int i = 0; i < sum; i++) {
			t = t.substring(0, t.lastIndexOf(ch));
		}

		return str.substring(t.length(), str.length());
	}
	
	//--------------------------截取第N个字符之前字符串（带截取字符）-------------------//

	public static String subFortWithChar(String str, String ch, int sum) {

		String t = str;
		int num=0;
		for (int i = 0; i < sum; i++) {
			t = t.substring(t.indexOf(ch)+1, t.length());
			num=str.length()-t.length();
		}

		return str.substring(0,num);
	}
	
	//--------------------------截取第N个字符之前字符串（不带截取字符）-------------------//
	public static String subFortWithOutChar(String str, String ch, int sum) {

		String t = str;
		int num=0;
		for (int i = 0; i < sum; i++) {
			t = t.substring(t.lastIndexOf(ch)+1, t.length());
			num=str.length()-t.length()-1;
		}

		return str.substring(0,num);
	}
	
}

