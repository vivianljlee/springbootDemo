package com.estar.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
public class StringUtil {
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();

		String ranStr = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
		int i = 36 - ranStr.length();
		StringBuffer buf = new StringBuffer("a,b,c,d,e,f,g,h,i,g,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
		buf.append(",A,B,C,D,E,F,G,H,I,G,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z");
		buf.append(",1,2,3,4,5,6,7,8,9,0");
		String[] arr = buf.toString().split(",");
		StringBuffer b = new StringBuffer();
		for (int j = 0; j < i; j++) {
			Random r = new Random();
			int k = r.nextInt();
			b.append(String.valueOf(arr[Math.abs(k % 61)]));
		}
		ranStr = ranStr + b.toString();
		return ranStr;
	}
	public static void main(String[] args) {
		/*for(int i=0;i<1000;i++) {
			System.out.println(getRandomCode(6));
		}
		int hour = ;
		if (hour >= 22 || hour < 7)
		{
		  // 晚上22点（含）到凌晨6点（不含）之间
		}
		else
		{
		  // 上述之外的时间段
		}
		
		 //例如比较当前时间和早上6：00
        
        System.out.println("当前时间为："+nowTime);
        System.out.println("与当日06：00相比");
        int i = 0;
		try {
			i = DateCompare(nowTime,"06:00","HH:MM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        switch (i) {
        case 0:
            System.out.println("两个时间相等");
            break;
        case 1:
            System.out.println("当前时间晚于06:00");
            break;
        case -1:
            System.out.println("当前时间早于06:00");
            break;
        default:
            break;
        }
		System.out.println(i);
		System.out.println(StringUtil.payDateString("20180125104337"));*/
		
		
		String nowTime = new SimpleDateFormat("HH:MM").format(new Date());
		System.out.println(nowTime);
		try {
			if(StringUtil.neq(DateCompare(nowTime,"19:30","HH:MM"), -1) ||
					StringUtil.neq(DateCompare(nowTime,"06:00","HH:MM"), 1)) {
				//上架
				System.out.println("shangjia");
			}else {
				System.out.println("xiajia");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /**
     * 根据时间类型比较时间大小 
     * 
     * @param source
     * @param traget
     * @param type "YYYY-MM-DD" "yyyyMMdd HH:mm:ss"  类型可自定义
     * @param 传递时间的对比格式
     * @return 
     *  0 ：source和traget时间相同    
     *  1 ：source比traget时间大  
     *  -1：source比traget时间小
     * @throws Exception
     */
    public static int DateCompare(String source, String traget, String type) throws Exception {
        int ret = 2;
        SimpleDateFormat format = new SimpleDateFormat(type);
        Date sourcedate = format.parse(source);
        Date tragetdate = format.parse(traget);
        ret = sourcedate.compareTo(tragetdate);
        return ret;
    }
	/**
	 * 获得随机验证码
	 * @param lenght 获得随机码的长度
	 * @return 随机验证码
	 * */
	public static String getRandomCode(int length){
		String[] codes={"1","2","3","4","5","6","7","8","9","0"};
		Random random=new Random();
		String rcode="";
		for(int i=0;i<length;i++){
			int index=random.nextInt(codes.length);
			rcode=rcode+codes[index];
		}
		return rcode;
	}
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
	        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
	        "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
	        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
	        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
	        "W", "X", "Y", "Z" };  

	public static String generateShortUuid() {  
	    StringBuffer shortBuffer = new StringBuffer();  
	    String uuid = UUID.randomUUID().toString().replace("-", "");  
	    String lastTwo = "";
	    for (int i = 0; i < 8; i++) {  
	        String str = uuid.substring(i * 4, i * 4 + 4);  
	        int x = Integer.parseInt(str, 16); 
	        shortBuffer.append(chars[x % 0x3E]);  
	        lastTwo = uuid.substring(0, 2);
	    }  
	    String shortUuid= (shortBuffer.toString() + lastTwo).toLowerCase();
	    return shortUuid;  
	}
	
//	"secTypeList":[{"productTypeImg":"二级分类图片001","productTypeName":"二级分类001"},{"productTypeImg":"二级分类图片002","productTypeName":"二级分类002"}]
	
	public static String checkBean(Object obj,Object obj1,Object[] s) {
	    String errorMsg = null;
        Map<String, Object> map = new HashMap<String, Object>();
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        OK:
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true);
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                for(int j=0;j<s.length;j++) {
            		if(StringUtil.equ(s[j], f.getName())) {
            			continue OK;
            		}
            	}
                if(StringUtil.isNull(val)) {
                	errorMsg = getErrorMsg(f.getName(),obj1);
                	return errorMsg;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return errorMsg;
    }
	
	private static String getErrorMsg(String name,Object obj1) {
		 	Class userCla = (Class) obj1.getClass();
	        Field[] fs = userCla.getDeclaredFields();
	        for (int i = 0; i < fs.length; i++) {
	            Field f = fs[i];
	            f.setAccessible(true);
	            try {
	            	if(StringUtil.equ(f.getName(), name)) {
	            		return StringUtil.cStr(f.get(obj1));
	            	}
	            } catch (IllegalArgumentException e) {
	                e.printStackTrace();
	            } catch (IllegalAccessException e) {
	                e.printStackTrace();
	            }
	        }
		return null;
	}  
	
	public static String repeatRandom(int time) {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < time; i++) {
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}

	public static String randomId() {
		long order = System.currentTimeMillis() + 888888888888L;
		StringBuilder sb = new StringBuilder();
		sb.append(order);
		sb.append(repeatRandom(5));
		return sb.toString();
	}

	public static String yearMd() {
		String now = dateString(new java.util.Date());
		String year = year(now);
		year = year.substring(year.length() - 2, year.length());
		String currentTimeMillis = cStr(Long.valueOf(System.currentTimeMillis()));
		currentTimeMillis = currentTimeMillis.substring(currentTimeMillis.length() - 3, currentTimeMillis.length());
		return year + month(now) + day(now) + minute(now) + second(now) + currentTimeMillis;
	}

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("X-Forwarded-For");
			if ((ip != null) && (ip.length() != 0) && (!"unknown".equalsIgnoreCase(ip))) {
				int index = ip.indexOf(',');
				if (index != -1) {
					ip = ip.substring(0, index);
				}
			}
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String iif(boolean Con1, String Rev1, String Rev2) {
		return Con1 ? Rev1 : Rev2;
	}

	public static boolean isNull(Object obj) {
		return (obj == null) || ("".equals(obj));
	}

	public static String nul(Object obj) {
		return isNull(obj) ? "" : String.valueOf(obj);
	}

	public static boolean equ(Object obj1, Object obj2) {
		return nul(obj1).equals(nul(obj2));
	}

	public static boolean neq(Object obj1, Object obj2) {
		return !nul(obj1).equals(nul(obj2));
	}

	public static boolean notEmpty(Object obj) {
		String str = nul(obj);
		return (!equ(str, "")) && (!equ(str, "undefined"));
	}

	public static boolean notZero(Object obj) {
		String str = nul(obj);
		return (!equ(str, Integer.valueOf(0))) && (!equ(str, "")) && (!equ(str, "undefined"));
	}

	public static String lef(String str) {
		int len = str.length();
		return len > 0 ? str.substring(0, len - 1) : "";
	}

	public static boolean equr(Object obj1, Object obj2) {
		String[] str = nul(obj2).split("\\,");
		for (int i = 0; i < str.length; i++) {
			if (equ(obj1, str[i])) {
				return true;
			}
		}
		return false;
	}

	public static String pick(Object obj1, Object obj2) {
		if (equ(obj1, "")) {
			return nul(obj2);
		}
		return nul(obj1);
	}

	public static String ubbTstr(Object obj) {
		return nul(obj).replace("'", "''");
	}

	public static String urlStr(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (Exception ex) {
		}
		return str;
	}

	public static String deUrlStr(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (Exception ex) {
		}
		return str;
	}

	public static int cInt(String str) {
		if (equ(str, "")) {
			return 0;
		}
		try {
			return Integer.parseInt(str.trim());
		} catch (Exception e) {
		}
		return 0;
	}

	public static int cInt(Object str) {
		return Integer.parseInt(nul(str).trim());
	}

	public static String getWeekOfDate(java.util.Date dt) {
		String[] weekDays = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(7) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekDays[w];
	}

	public static boolean isDate(String sDate) {
		if (sDate.indexOf(" ") + sDate.indexOf(":") == -2) {
			sDate = sDate + " 0:0:0";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			df.setLenient(false);
			df.parse(sDate);
			return true;
		} catch (ParseException ex) {
			df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				df.setLenient(false);
				df.parse(sDate);
				return true;
			} catch (ParseException ey) {
			}
		}
		return false;
	}

	public static java.util.Date getDate() {
		return new java.util.Date();
	}

	public static java.util.Date getDate(String sDate) {
		if(StringUtil.isNull(sDate)) {
			return null;
		}
		if (sDate.indexOf(" ") + sDate.indexOf(":") == -2) {
			sDate = sDate + " 0:0:0";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			df.setLenient(false);
			return df.parse(sDate);
		} catch (ParseException ex) {
			df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				df.setLenient(false);
				return df.parse(sDate);
			} catch (ParseException ey) {
			}
		}
		return new java.util.Date();
	}

	public static String dateString(Object dat) {
		if (dat == null) {
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = formatter.format(dat);
		return dateStr;
	}

	public static String shortDateString(Object dat) {
		if (!notEmpty(dat)) {
			return "";
		}
		String strFormat = "";
		if (instr(dat.toString(), ":") > 0) {
			strFormat = "yyyy-MM-dd HH:mm:ss";
		} else {
			strFormat = "yyyy-MM-dd";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		String dateStr = formatter.format(dat);
		return dateStr;
	}
	
	public static String payDateString(Object dat) {
		String dateStr = "";
		Date date1 = null;
		if (!notEmpty(dat)) {
			return "";
		}
		try {
			date1 = new SimpleDateFormat("yyyyMMddHHmmss").parse((String)dat);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateStr = formatter.format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateStr;
	}

	public static String getNowDate() {
		Date dat = StringUtil.getDate();
		String strFormat = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		String dateStr = formatter.format(dat);
		return dateStr;
	}
	
	public static String cDate(String dat) {
		return dateString(getDate(dat));
	}
	/**
	 * 日期转换
	 * @param dat(英文时间和中国时间)
	 * @return
	 */
	public static String cZHDate(Object dat) {
		String date=null;
		boolean convertSuccess = true;
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if(dat instanceof Date) {
				sdf1.setLenient(false);
				date = sdf2.format(sdf1.parse(dat.toString()));	
			}
			if(dat instanceof String) {
				sdf1.setLenient(false);
				date = sdf2.format(sdf1.parse(dat.toString()));
			}	
		} catch (ParseException e) {
			convertSuccess=false;
		}finally {
			if(convertSuccess == false) {
				if(dat instanceof Date) {
					date=dat.toString();
				}
				if(dat instanceof String) {
					date=dat.toString();
				}
		     }		
	   }		
		return date;
	}
	public static String date() {
		return new java.sql.Date(System.currentTimeMillis()).toString();
	}

	public static String now() {
		return dateString(getDate());
	}

	public static String year(String dat) {
		if (isDate(dat)) {
			return dateString(getDate(dat)).substring(0, 4);
		}
		return null;
	}

	public static String month(String dat) {
		if (isDate(dat)) {
			return dateString(getDate(dat)).substring(5, 7);
		}
		return null;
	}

	public static String day(String dat) {
		if (isDate(dat)) {
			return dateString(getDate(dat)).substring(8, 10);
		}
		return null;
	}

	public static String hour(String dat) {
		if (isDate(dat)) {
			return dateString(getDate(dat)).substring(11, 13);
		}
		return null;
	}

	public static String minute(String dat) {
		if (isDate(dat)) {
			return dateString(getDate(dat)).substring(14, 16);
		}
		return null;
	}

	public static String second(String dat) {
		if (isDate(dat)) {
			return dateString(getDate(dat)).substring(17, 19);
		}
		return null;
	}

	public static int getLastDateOfMonth(String dat) {
		int Y = cInt(year(dat));
		int[] A = { 31, ((Y % 4 == 0) && (Y % 100 != 0)) || (Y % 400 == 0) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31,
				30, 31 };
		return A[(cInt(month(dat)) - 1)];
	}

	public static long dateDiff(String interval, String date1, String date2) {
		if ((!isDate(date1)) || (!isDate(date2))) {
			return 0L;
		}
		long inter;
		if (interval == "s") {
			inter = 1000L;
		} else {
			if (interval == "n") {
				inter = 60000L;
			} else {
				if (interval == "h") {
					inter = 3600000L;
				} else {
					if (interval == "d") {
						inter = 86400000L;
					} else {
						inter = 1L;
					}
				}
			}
		}
		long day = (getDate(date2).getTime() - getDate(date1).getTime()) / inter;
		return day;
	}

	public static String dateAdd(String interval, int num, String date) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(getDate(date));
		int inter;
		if (interval == "s") {
			inter = 13;
		} else {
			if (interval == "n") {
				inter = 12;
			} else {
				if (interval == "h") {
					inter = 10;
				} else {
					if (interval == "d") {
						inter = 5;
					} else {
						if (interval == "m") {
							inter = 2;
						} else {
							if (interval == "y") {
								inter = 1;
							} else {
								return null;
							}
						}
					}
				}
			}
		}
		rightNow.add(inter, num);
		java.util.Date dt = rightNow.getTime();
		return dateString(dt);
	}

	public static int instr(String str1, String str2) {
		if (isNull(str1)) {
			return 0;
		}
		return str1.indexOf(str2) + 1;
	}

	public static int instrRev(String str1, String str2) {
		if (isNull(str1)) {
			return 0;
		}
		return str1.lastIndexOf(str2) + 1;
	}

	public static boolean where(String str1, String str2) {
		return ("," + str1 + ",").indexOf("," + str2 + ",") > -1;
	}

	public static int len(String str) {
		if (isNull(str)) {
			return 0;
		}
		return str.length();
	}

	public static String lcase(String str) {
		if (isNull(str)) {
			return str;
		}
		return str.toLowerCase();
	}

	public static String ucase(String str) {
		if (isNull(str)) {
			return str;
		}
		return str.toUpperCase();
	}

	public static String replace(String str1, String str2, String str3) {
		if (isNull(str1)) {
			return str1;
		}
		return str1.replace(str2, str3);
	}

	public static String[] split(String str1, String str2) {
		str1 = str1 + " ";
		if (equ(str2, ",")) {
			str2 = "\\,";
		}
		if (equ(str2, "|")) {
			str2 = "\\|";
		}
		if (equ(str2, "(")) {
			str2 = "\\(";
		}
		if (equ(str2, "{")) {
			str2 = "\\{";
		}
		if (equ(str2, "$")) {
			str2 = "\\$";
		}
		if (equ(str2, "@")) {
			str2 = "\\@";
		}
		if (equ(str2, "[~_~]1")) {
			str2 = "\\[~_~\\]1";
		}
		if (equ(str2, "[~_~]2")) {
			str2 = "\\[~_~\\]2";
		}
		return str1.split(str2);
	}

	public static String join(String[] arr, String str) {
		if (arr == null) {
			return "";
		}
		StringBuffer buff = new StringBuffer();
		int i = 0;
		for (int len = arr.length; i < len; i++) {
			buff.append(String.valueOf(arr[i]));
			if (i < len - 1) {
				buff.append(str);
			}
		}
		return buff.toString();
	}

	public static int ubound(String[] arr) {
		return arr.length - 1;
	}

	public static String left(String str, int alt) {
		if (equ(nul(str), "")) {
			return "";
		}
		return nul(str).substring(0, alt);
	}

	public static String getStartChar(String str) {
		return nul(str).replaceAll("^(.).+", "$1");
	}

	public static String delStartChar(String str) {
		return nul(str).replaceAll("^(?:.)(.+)$", "$1");
	}

	public static String getEndChar(String str) {
		return nul(str).replaceAll("^.+(.)$", "$1");
	}

	public static String delEndChar(String str) {
		return nul(str).replaceAll("^(.+).$", "$1");
	}

	public static String[] splitString(String str, int areaLong) {
		int ln = str.length();
		String[] sArr = null;
		if (ln % areaLong > 0) {
			sArr = new String[ln / areaLong + 1];
		} else {
			sArr = new String[ln / areaLong];
		}
		for (int i = 0; i < ln; i += areaLong) {
			if (i >= ln - areaLong) {
				sArr[(i / areaLong)] = str.substring(i);
			} else {
				sArr[(i / areaLong)] = str.substring(i, i + areaLong);
			}
		}
		return sArr;
	}

	public static String right(String str, int alt) {
		if (equ(nul(str), "")) {
			return "";
		}
		return nul(str).substring(str.length() - alt, str.length());
	}

	public static String trim(Object str) {
		return nul(str).trim();
	}

	public static String cStr(Object str) {
		return nul(str);
	}

	public static Double cDbl(String str) {
		try {
			return Double.valueOf(Double.parseDouble(to0(str.trim())));
		} catch (Exception e) {
		}
		return null;
	}

	public static boolean cBool(String str) {
		return neq(nul(str), "");
	}

	public static boolean cBool(int num) {
		return num != 0;
	}

	public static double round(double dbl, int cnt) {
		return Math.round(dbl * Math.pow(10.0D, cnt)) / Math.pow(10.0D, cnt);
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static String to0(Object str) {
		String temp = nul(str);
		if (equ(temp, "")) {
			return "0";
		}
		return temp;
	}

	public static boolean isPad(String sAgent) {
		return (instr(sAgent, "iPhone") > 0) || (instr(sAgent, "iPad") > 0) || (instr(sAgent, "iPod") > 0);
	}

	public static boolean isMob(String sAgent) {
		return (instr(sAgent, "Mobile") > 0) || (instr(sAgent, "android") > 0) || (isPad(sAgent));
	}

	public static String getColValue(Map<String, Object> map, int index) {
		int i = 0;
		if (!map.isEmpty()) {
			Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> next = (Map.Entry) it.next();
				if (i == index) {
					return nul(next.getValue());
				}
				i++;
			}
		}
		return "";
	}

	public static String sqlEqu(String str) {
		if (equ(str, "")) {
			return " IS NULL ";
		}
		return "='" + nul(str) + "' ";
	}

	public static String sqlNeq(String str) {
		if (equ(str, "")) {
			return " IS NOT NULL ";
		}
		return "<>'" + nul(str) + "' ";
	}

	public static String mid(String str, int Start, int Length) {
		str = nul(str);
		if ((str == null) || (Start <= 0)) {
			return null;
		}
		if (str.equals("")) {
			return "";
		}
		if (Start + Length - 1 >= str.length()) {
			return str.substring(Start - 1);
		}
		return str.substring(Start - 1, Start + Length - 1);
	}

	public static String join(Map<String, Object> map, String Spliter) {
		String Rev = "";
		if (!map.isEmpty()) {
			Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> next = (Map.Entry) it.next();
				Rev = Rev + nul(next.getValue()) + (it.hasNext() ? Spliter : "");
			}
		}
		return Rev;
	}

	public static int mod(double dbl1, double dbl2) {
		return (int) (dbl1 % dbl2);
	}

	public static int mod(int dbl1, double dbl2) {
		return (int) (dbl1 % dbl2);
	}

	public static int mod(int dbl1, int dbl2) {
		return dbl1 % dbl2;
	}

	public static int mod(double dbl1, int dbl2) {
		return (int) (dbl1 % dbl2);
	}

	public static void cpy(String code) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable trandata = new StringSelection(code);
		clipboard.setContents(trandata, null);
	}

	public static boolean isWindowsOS() {
		String os = System.getProperty("os.name");
		return os.startsWith("Windows");
	}

	public static boolean isLinuxOS() {
		String os = System.getProperty("os.name");
		return os.startsWith("Linux");
	}

	public static String getSysProperty(String propertyName) {
		return System.getProperty(propertyName);
	}

	public static String runLocalCmd(String cmdName, String param) {
		StringBuffer sbf = new StringBuffer();
		try {
			ProcessBuilder pb = new ProcessBuilder(new String[] { "dmidecode", "-t 2" });
			Process p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			String EntChar = isWindowsOS() ? "\r\n" : "\n";
			while ((line = br.readLine()) != null) {
				sbf.append(line).append(EntChar);
			}
			br.close();
		} catch (IOException localIOException) {
		}
		return sbf.toString();
	}

	public static String[] mapToArray(Map<String, Object> map) {
		String[] Rev = null;
		int i = 0;
		if (!map.isEmpty()) {
			Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
			Rev = new String[map.size()];
			while (it.hasNext()) {
				Map.Entry<String, Object> next = (Map.Entry) it.next();
				Rev[i] = nul(next.getValue());
				i++;
			}
		}
		return Rev;
	}

	public static String mapToParam(Map<String, Object> map) {
		String rtn = "";
		if (!map.isEmpty()) {
			Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> next = (Map.Entry) it.next();
				rtn = rtn + (String) next.getKey() + "=" + next.getValue() + "&";
			}
			if ((rtn.length() > 0) && (rtn.endsWith("&"))) {
				rtn = rtn.substring(0, rtn.length() - 1);
			}
		}
		return rtn;
	}

	public static Map<String, Object> arrayToMap(String[] array) {
		Map<String, Object> map = new HashMap();
		for (int i = 0; i < array.length; i++) {
			map.put(nul(Integer.valueOf(i)), array[i]);
		}
		return map;
	}

	public static String Object2String(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	public static Long Object2Long(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			return Long.decode(obj.toString());
		} catch (NumberFormatException e) {
		}
		return null;
	}

	public static Long cLng(Object obj) {
		return Object2Long(obj);
	}

	public static String vbcrlf() {
		return "\r\n";
	}

	public static String getServerAddr(HttpServletRequest request) {
		String strAddr = request.getRequestURL().substring(0,
				request.getRequestURL().length() - request.getRequestURI().length());
		return strAddr + "/";
	}

	public static String handelUrl(String url) {
		if (url == null) {
			return null;
		}
		url = url.trim();
		if ((url.equals("")) || (url.startsWith("http://")) || (url.startsWith("https://"))) {
			return url;
		}
		return "http://" + url.trim();
	}

	public static String getAppPath(Class<?> cls) {
		if (cls == null) {
			throw new IllegalArgumentException("");
		}
		ClassLoader loader = cls.getClassLoader();
		String clsName = cls.getName() + ".class";
		Package pack = cls.getPackage();
		String path = "";
		if (pack != null) {
			String packName = pack.getName();
			if ((packName.startsWith("java.")) || (packName.startsWith("javax."))) {
				throw new IllegalArgumentException("");
			}
			clsName = clsName.substring(packName.length() + 1);
			if (packName.indexOf(".") < 0) {
				path = packName + "/";
			} else {
				int start = 0;
				int end = 0;
				end = packName.indexOf(".");
				while (end != -1) {
					path = path + packName.substring(start, end) + "/";
					start = end + 1;
					end = packName.indexOf(".", start);
				}
				path = path + packName.substring(start) + "/";
			}
		}
		URL url = loader.getResource(path + clsName);
		String realPath = url.getPath();
		int pos = realPath.indexOf("file:");
		if (pos > -1) {
			realPath = realPath.substring(pos + 5);
		}
		pos = realPath.indexOf(path + clsName);
		realPath = realPath.substring(0, pos - 1);
		if (realPath.endsWith("!")) {
			realPath = realPath.substring(0, realPath.lastIndexOf("/"));
		}
		try {
			realPath = URLDecoder.decode(realPath, "utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return realPath;
	}

	public static String getGroupCacheKey(HttpServletRequest request, String M, String L) {
		String SessionID = "";
		if (request != null) {
			SessionID = request.getSession().getId();
		}
		return "GroupCache_" + M + "_" + L + "_" + SessionID;
	}

	public static Map<String, Object> putGroupCaption(Map<String, Object> groupMap, String labelID, String labelHTML) {
		if (groupMap == null) {
			return null;
		}
		String captionHTML = nul((String) groupMap.get("Caption"));
		String panelHTML = nul((String) groupMap.get("Panel_" + labelID));
		if (equ(captionHTML, "")) {
			captionHTML = captionHTML + "<div class=\"block_group_t active\" groupID=\"" + labelID
					+ "\" style=\"cursor:pointer;\">";
			panelHTML = "<div class=\"block_group_w\" groupPanelID=\"" + labelID + "\">";
		} else {
			captionHTML = captionHTML + "<div class=\"block_group_t\" groupID=\"" + labelID
					+ "\" style=\"cursor:pointer;\">";
			panelHTML = "<div class=\"block_group_w\" style=\"display:none\" groupPanelID=\"" + labelID + "\">";
		}
		captionHTML = captionHTML + labelHTML;
		captionHTML = captionHTML + "</div>";
		groupMap.put("Caption", captionHTML);
		groupMap.put("Panel_" + labelID, panelHTML);
		return groupMap;
	}

	public static Map<String, Object> putGroupPanel(Map<String, Object> groupMap, String labelID, String elemHTML) {
		if (groupMap == null) {
			groupMap = new LinkedHashMap();
		}
		String html = nul((String) groupMap.get("Panel_" + labelID));
		groupMap.put("Panel_" + labelID, html + elemHTML);
		return groupMap;
	}

	public static String getGroupHTML(Map<String, Object> groupMap) {
		if (groupMap == null) {
			return "";
		}
		StringBuffer html = new StringBuffer();
		if (!groupMap.isEmpty()) {
			html.append("<div class=\"block_group block block_large\" id=\"fieldGroup\" style=\"\">");
			html.append("<div class=\"block_group_tab\">");
			html.append(nul(groupMap.get("Caption")));
			html.append("</div><div class=\"block_group_panel\">");
			Iterator<Map.Entry<String, Object>> it = groupMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> next = (Map.Entry) it.next();
				if (!((String) next.getKey()).equals("Caption")) {
					html.append(nul(next.getValue()) + "</div>");
				}
			}
			html.append("</div></div>");
			return nul(html.toString());
		}
		return "";
	}

	public static String parseURL(String URL, String Arg) {
		String Args = "";
		if (URL.indexOf("?") == -1) {
			return Args;
		}
		Args = URL.split("\\?")[1];

		String[] argList = Args.split("\\&");
		String[] emp = null;
		String[] arrayOfString1;
		int j = (arrayOfString1 = argList).length;
		for (int i = 0; i < j; i++) {
			String str = arrayOfString1[i];
			emp = str.split("=");
			if (emp[0].equalsIgnoreCase(Arg)) {
				return emp[1];
			}
		}
		return "";
	}

	public static String mapjson(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if ((map != null) && (map.size() > 0)) {
			for (Object key : map.keySet()) {
				json.append(objectjson(key));
				json.append(":");
				json.append(objectjson(map.get(key)));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	public static String objectjson(Object obj) {
		StringBuilder json = new StringBuilder();
		if (obj == null) {
			json.append("\"\"");
		} else if (((obj instanceof String)) || ((obj instanceof Integer)) || ((obj instanceof Float))
				|| ((obj instanceof Boolean)) || ((obj instanceof Short)) || ((obj instanceof Double))
				|| ((obj instanceof Long)) || ((obj instanceof BigDecimal)) || ((obj instanceof BigInteger))
				|| ((obj instanceof Byte))) {
			json.append("\"").append(stringjson(obj.toString())).append("\"");
		} else if ((obj instanceof Map)) {
			json.append(mapjson((Map) obj));
		}
		return json.toString();
	}

	public static String stringjson(String s) {
		if (s == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("/");
				break;
			default:
				if ((ch >= 0) && (ch <= '\037')) {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
				break;
			}
		}
		return sb.toString();
	}

	public static String sumFormat(String sum, int xsw) {
		if (isNull(sum)) {
			sum = "0";
		}
		BigDecimal big = new BigDecimal(sum);
		big = big.setScale(xsw, 4);
		return big.toString();
	}

	public static String replaceIgnoerCase(String origString, String reps) {
		return Pattern.compile(reps, 2).matcher(origString).replaceAll(reps);
	}

	public static String doUrl(String urlString, String... requestMethod) {
		String res = "";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			String strMethod = "GET";
			if ((requestMethod == null) || (requestMethod.length == 0)) {
				strMethod = "GET";
			} else {
				strMethod = requestMethod[0];
			}
			conn.setRequestMethod(strMethod);
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				res = res + line;
			}
			in.close();
		} catch (Exception e) {
			res = e.getMessage();
		}
		return res;
	}

	public static List<Map<String, Object>> getCatchList(List<Map<String, Object>> dataList,
			Map<String, String> condMap) {
		if ((condMap != null) && (condMap.size() > 0)) {
			List<Map<String, Object>> finalDataList = new ArrayList();
			for (Map<String, Object> dataMap : dataList) {
				boolean flag = true;
				Iterator<?> iterator = dataMap.keySet().iterator();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					Object obj = dataMap.get(key);
					boolean flag1 = false;
					Iterator<?> it = condMap.keySet().iterator();
					while (it.hasNext()) {
						String condKey = (String) it.next();
						String condValue = (String) condMap.get(condKey);
						if ((condValue != null) && (condValue.trim().length() > 0) && (condKey.equalsIgnoreCase(key))) {
							if (obj != null) {
								if (obj.toString().indexOf(condValue) == -1) {
									flag1 = true;
									flag = false;
									break;
								}
							} else {
								flag1 = true;
								flag = false;
								break;
							}
						}
					}
					if (flag1) {
						break;
					}
				}
				if (flag) {
					finalDataList.add(dataMap);
				}
			}
			return finalDataList;
		}
		return dataList;
	}

	public static String getDomain(HttpServletRequest request) {
		StringBuffer urlsb = request.getRequestURL();
		String dm1 =

				"/";
		dm1 = dm1.replace("http://", "").replace("https://", "");
		if (dm1.indexOf(":") > -1) {
			dm1 = dm1.split(":")[0];
		}
		return dm1;
	}

	public static String arrToStr(String[] arr) {
		if (arr == null) {
			return "arr is Null.";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append("[").append(arr[i]).append("] ");
		}
		return sb.toString();
	}

	public static String joinStr(List<String> list, int level) {
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			if (sb.length() != 0) {
				sb.append(getSplitChar(level));
			}
			if (level == 1) {
				str = cleanSplitStr(str);
			}
			sb.append(str);
		}
		return sb.toString();
	}

	public static List<String> splitStr(String str, int level) {
		List<String> list = new ArrayList();
		String[] ss = split(str, getSplitChar(level));
		String[] arrayOfString1;
		int j = (arrayOfString1 = ss).length;
		for (int i = 0; i < j; i++) {
			String s = arrayOfString1[i];
			list.add(s);
		}
		return list;
	}

	private static String getSplitChar(int level) {
		char splitChar = '\001';
		if (level == 1) {
			splitChar = '\001';
		} else if (level == 2) {
			splitChar = '\002';
		} else if (level == 3) {
			splitChar = '\003';
		} else if (level == 4) {
			splitChar = '\004';
		} else if (level == 5) {
			splitChar = '\005';
		}
		return StringUtil.cStr(splitChar);
	}

	private static String cleanSplitStr(String str) {
		str = str.replaceAll("\001", "");
		str = str.replaceAll("\002", "");
		str = str.replaceAll("\003", "");
		str = str.replaceAll("\004", "");
		str = str.replaceAll("\005", "");
		return str;
	}

	public static String readFileContent(File file) {
		if ((file == null) || (!file.exists())) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		try {
			InputStream is = new FileInputStream(file);
			BufferedReader fr = new BufferedReader(new InputStreamReader(is, "utf-8"));
			char[] temp = new char['?'];
			int i = -1;
			while ((i = fr.read(temp)) != -1) {
				sb.append(temp, 0, i);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String mobileStar(String mobile) {
		if ((isNull(mobile)) || (mobile.length() != 11)) {
			return mobile;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(mobile.substring(0, 3));
		sb.append("****");
		sb.append(mobile.substring(7));
		return sb.toString();
	}

	public static String emailStar(String email) {
		if ((isNull(email)) || (email.indexOf("@") == -1)) {
			return email;
		}
		int x = email.indexOf("@");
		String q = email.substring(0, x);
		int j = q.length() / 2;
		StringBuilder sb = new StringBuilder();
		sb.append(q.substring(0, j));
		sb.append(repeatChar(j, '*'));
		sb.append(email.substring(x));
		return sb.toString();
	}

	public static String idStar(String id) {
		if ((isNull(id)) || (id.length() < 8)) {
			return id;
		}
		int x = id.length() / 2;
		StringBuilder sb = new StringBuilder();
		sb.append(id.substring(0, x / 2));
		sb.append(repeatChar(x, '*'));
		sb.append(id.substring(x / 2 + x));
		return sb.toString();
	}

	public static void init() {
	}

	public static String repeatChar(int time, char c) {
		StringBuilder s = new StringBuilder();
		do {
			s.append(c);
			time--;
		} while (

		time > 0);
		return s.toString();
	}
	
	public static String distance_km(double distance) {
		BigDecimal bd = new BigDecimal(distance);
		double dis = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return dis+"km";
	}
}
