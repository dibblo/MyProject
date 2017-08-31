package com.website.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.dao.LoginLogDao;
import com.website.dao.UserDao;
import com.website.domain.LoginCommand;
import com.website.domain.LoginLog;
import com.website.domain.User;
import com.website.security.util.MD5;
import org.springframework.util.StringUtils;

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
    public User findUserByUserName(String userName,String password) {
        password=MD5.getMD5(password);
        return userDao.getMatchUser(userName, password);
    }

    @Transactional
    public void LoginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

    @Transactional
    public User userLogin(String userName, String password) {
        return userDao.getMatchUser(userName,password);
    }

    @Transactional
    public void registerByMd5(LoginCommand login) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUserName(login.getUserName());
        user.setPassword((MD5.getMD5(login.getPassword())));
        userDao.register(user);
    }

    public boolean hasRegister(String userName) {
        return userDao.getMatchCount(userName)!=0;
    }

    public Map<String, Object> validateSignin(String userName,String passWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        boolean isValidUser = this.hasMatchUser(userName);
        if (!isValidUser) {
            map.put("msg", "此用户不存在");
            map.put("success", false);
        } else if (this.userLogin(userName, MD5.getMD5(passWord)) == null) {
            map.put("msg", "账号或密码不正确，请重新输入");
            map.put("success", false);
        }
        return map;
    }

    public Map<String, Object> validateSignup(String userName,String passWord,String repassword) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        if(StringUtils.isEmpty(userName)){
            map.put("msg", "用户名不能为空");
            map.put("success", false);
        }else if (this.hasRegister(userName)) {
            map.put("msg", "此用户名已注册");
            map.put("success", false);
        } else if (!passWord.equals(repassword)) {
            map.put("msg", "两次填写的密码不一致，请检查后重新输入");
            map.put("success", false);
        }
        return map;
    }

}
