package com.yuzhaibu.util;

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
	
}
