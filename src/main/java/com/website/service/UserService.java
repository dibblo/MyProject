package com.website.service;

import java.util.UUID;

import com.website.securityt.util.RSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.dao.LoginLogDao;
import com.website.dao.UserDao;
import com.website.domain.LoginCommand;
import com.website.domain.LoginLog;
import com.website.domain.User;
import com.website.securityt.util.MD5;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	@Transactional
	public boolean hasMatchUser(String userName) {
		int matchUser = userDao.getMatchCount(userName);
		return matchUser > 0;
	}
	@Transactional
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}


	public boolean isPasswordValid(String password, User user) {
		boolean flag = false;
		/*RSA.encryptByPublicKey(password.getBytes(), user.getPublicKey());*/
		return flag;
	}
	@Transactional
	public void LoginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLasstVist());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
	@Transactional
	public int userLogin(String userName, String password) {
		return userDao.userLogin(userName, password);
	}

	@Transactional
	public void registerByMd5(LoginCommand login) {
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName(login.getUserName());
		user.setPassword((MD5.getMD5(login.getPassword())));
		userDao.register(user);
	}
	
	public boolean hasRegister(String userName) {
		return userDao.hasRegister(userName);
	}
	
	public void registerByRSA(LoginCommand login){
/*		User user = new User();
		user.setUserName(login.getUserName());
		user.setPassword(login.getPassword());
		user.setPrimaryKey(UUID.randomUUID().toString());
		user.setPrimaryKey(UUID.randomUUID().toString());
		userDao.register(user);*/
	}

}
