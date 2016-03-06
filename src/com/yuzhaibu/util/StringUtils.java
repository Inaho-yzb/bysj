package com.yuzhaibu.util;

public class StringUtils {
	
	/**
	 * 字符串是否为空,""
	 * @param Str
	 * @return
	 */
	public static boolean isBlank(String str){
		if(str==null||str==""){
			return false;
		}else{
			return true;
		}
	}
	
}
