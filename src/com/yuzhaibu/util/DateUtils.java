package com.yuzhaibu.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	/**Timestamp和String之间转换的函数：
	 * *
	 * @param obj
	 * @return
	 */
    public static String getTimestampToString(Timestamp obj) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义格式，不显示毫秒
        String str = df.format(obj);
        return str;
    }
    
    /**
     * 转换成中文 年月日
     */
    public static String dateToStrLong(Date dateDate) {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
    	String dateString = formatter.format(dateDate);
    	return dateString;
    }
    
    /**
     * 转换成中文 年月日,传入样式
     */
    public static String dateToStrLong(Date dateDate,String regx){
    	SimpleDateFormat formatter = new SimpleDateFormat(regx);
    	String dateString = formatter.format(dateDate);
    	return dateString;
    }
	
}
