package com.website.domain;

import java.io.Serializable;

public class LoginCommand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8112836848083406013L;
	private String userName;
	private String password;
	private String token;
	private boolean isAutoLogin;
	
	public boolean isAutoLogin() {
		return isAutoLogin;
	}
	public void setAutoLogin(boolean isAutoLogin) {
		this.isAutoLogin = isAutoLogin;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
