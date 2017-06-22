package com.website.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2803442368359870705L;
	private String userId;
	private String userName;
	private String password;
	private int credits;
	private String lastIp;
	private Date lasstVist;
	private String token;
	public String getUserId() {
		return userId;
	}
	public void 	setUserId(String userId) {
		this.userId = userId;
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
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public Date getLasstVist() {
		return lasstVist;
	}
	public void setLasstVist(Date lasstVist) {
		this.lasstVist = lasstVist;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public static User initUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserName(rs.getString("user_name"));
		user.setCredits(rs.getInt("credits"));
		user.setUserId(rs.getString("user_id"));
		user.setLasstVist(rs.getDate("last_visit"));
		user.setLastIp(rs.getString("last_ip"));
		user.setPassword(rs.getString("password"));
		user.setToken(rs.getString("token"));
		return user;
	}


}
