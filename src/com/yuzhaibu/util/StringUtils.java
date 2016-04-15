package com.yuzhaibu.util;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

public class StringUtils {
	
	/**
	 * 字符串是否为空,""
	 * @param Str
	 * @return
	 */
	public static boolean isBlank(String str){
		if(str==null||str==""){
			return true;
		}else{
			return false;
		}
	}
	
	public static String changeImgFileName(String originFileName,int num){
		
		String suf = originFileName.substring(originFileName.lastIndexOf("."));
		
		String newFileName = "itemimg"+DateUtils.dateToStrLong(new Date(), "yyyyMMddhhmmss")+new Random().nextInt(100)+num+suf;
		
		return newFileName;
	}
	
	public static String changeAuthenImgFileName(String originFileName,int num){
		String suf = originFileName.substring(originFileName.lastIndexOf("."));
		
		String newFileName = "authenimg"+DateUtils.dateToStrLong(new Date(), "yyyyMMddhhmmss")+new Random().nextInt(100)+num+suf;
		
		return newFileName;
	}
	
	public static String changeHeadImgFileName(String originFileName,int num){
		String suf = originFileName.substring(originFileName.lastIndexOf("."));
		
		String newFileName = "headimg"+DateUtils.dateToStrLong(new Date(), "yyyyMMddhhmmss")+new Random().nextInt(100)+num+suf;
		
		return newFileName;
	}
	
	 public static String string2MD5(String inStr){  
	        MessageDigest md5 = null;  
	        try{  
	            md5 = MessageDigest.getInstance("MD5");  
	        }catch (Exception e){  
	            System.out.println(e.toString());  
	            e.printStackTrace();  
	            return "";  
	        }  
	        char[] charArray = inStr.toCharArray();  
	        byte[] byteArray = new byte[charArray.length];  
	  
	        for (int i = 0; i < charArray.length; i++)  
	            byteArray[i] = (byte) charArray[i];  
	        byte[] md5Bytes = md5.digest(byteArray);  
	        StringBuffer hexValue = new StringBuffer();  
	        for (int i = 0; i < md5Bytes.length; i++){  
	            int val = ((int) md5Bytes[i]) & 0xff;  
	            if (val < 16)  
	                hexValue.append("0");  
	            hexValue.append(Integer.toHexString(val));  
	        }  
	        return hexValue.toString();  
	  
	    }

	public static String getRandomMD5Str() {
		char[] chararray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9' };
		byte[] byteArray = new byte[20];
		for (int i = 0; i < 20; i++) {
			Random random = new Random();
			int it = random.nextInt(62);
			byteArray[i] = (byte) chararray[it];
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}  
	
}
