package com.estar.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class ConvertUtil {

	/**
	 * 将Object对象转换成String,如果是null，转换成空串
	 * 
	 * @param obj
	 * @return
	 */
	public static String nullToEmpty(Object obj) {
		if (StringUtils.isEmpty(obj)) {
			return "";
		}
		return (String) obj;
	}
	/**
	 * 将日期格式转换成规范的字符串格式
	 * @param d
	 * @return
	 */
	public static String dateToString(Date d){
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(d==null){
			return null;
		}
		return fomat.format(d);
	}
}
