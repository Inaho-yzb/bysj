package com.yuzhaibu.entity;

import java.io.Serializable;

public class Mail implements Serializable {

	private static final long serialVersionUID = 8264776213411504889L;

	public static final String ENCODEING = "UTF-8";  
	  
	    private String host = "smtp.126.com"; // 服务器地址  
	  
	    private String sender = "wangkeweihutui@126.com"; // 发件人的邮箱  
	  
	    private String receiver; // 收件人的邮箱  
	  
	    private String name = "校园跳蚤街"; // 发件人昵称  
	  
	    private String username = "wangkeweihutui@126.com"; // 账号  
	  
	    private String password = "wangkewei123"; // 密码  
	  
	    private String subject = "重置密码";// 主题  
	  
	    public String getReceiver() {
			return receiver;
		}

		public void setReceiver(String receiver) {
			this.receiver = receiver;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public static String getEncodeing() {
			return ENCODEING;
		}

		public String getHost() {
			return host;
		}

		public String getSender() {
			return sender;
		}

		public String getName() {
			return name;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public String getSubject() {
			return subject;
		}

		private String message; // 信息(支持HTML)  
	  
	    
}
