package com.website.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.website.common.domain.Message;
import com.website.domain.LoginCommand;
import com.website.domain.User;
import com.website.securityt.util.MD5;
import com.website.securityt.util.RSA;
import com.website.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value="/siteLogin",method={RequestMethod.POST})
	public ModelAndView loginCheck(HttpServletRequest req,LoginCommand loginCommand) {
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
		if(!isValidUser){
			return new ModelAndView("login","error","账号密码错误");
		}
		User user = userService.findUserByUserName(loginCommand.getUserName());
		user.setLasstVist(new Date());
		user.setLastIp(req.getRemoteAddr());
		userService.LoginSuccess(user);
		req.getSession().setAttribute("user", user);
		return new ModelAndView("main");
	}
	
	@RequestMapping(value="/applogin", method={RequestMethod.POST,RequestMethod.GET},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map appLogin(LoginCommand loginCommand){
		Map<String,Object> map = new HashMap<String, Object>();
		loginCommand.setPassword(MD5.getMD5(loginCommand.getPassword()));
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
		if(!isValidUser){
			map.put("result", 0);
			map.put("message","账号密码错误");
			return map;
		}
		map.put("result", 1);
		map.put("message", "123");
		return map;
	}
	
	@RequestMapping(value="/registermd5", method={RequestMethod.POST,RequestMethod.GET},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map register(LoginCommand loginCommand){
		Map<String,Object> map = new HashMap<String, Object>();
		boolean isRegister = userService.hasRegister(loginCommand.getUserName().trim());
		if(isRegister){
			map.put("result", 0);
			map.put("message","此用户名已注册");
			return map;
		}
		userService.registerByMd5(loginCommand);
		map.put("result", 1);
		map.put("message", "123");
		return map;
	}
	@RequestMapping(value="/registerrsa", method={RequestMethod.POST,RequestMethod.GET},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map registerByRSA(LoginCommand loginCommand){
		Map<String,Object> map = new HashMap<String, Object>();
		boolean isRegister = userService.hasRegister(loginCommand.getUserName().trim());
		if(isRegister){
			map.put("result", 0);
			map.put("message","此用户名已注册");
			return map;
		}
		userService.registerByRSA(loginCommand);
		return map;
	}
	
	@RequestMapping(value="/apploginrsa", method={RequestMethod.POST,RequestMethod.GET},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map appLoginRSA(LoginCommand loginCommand){
		Map<String,Object> map = new HashMap<String, Object>();
		if(loginCommand.isAutoLogin()){
			
		} else{
			if(StringUtils.isEmpty(loginCommand.getUserName())||StringUtils.isEmpty(loginCommand.getPassword())){
				map.put("result", 0);
				map.put("message","请输入用户名和密码");
				return map;
			}
			User user = userService.findUserByUserName(loginCommand.getUserName().trim());
			if(!isPasswordValid(loginCommand.getPassword(), user)){
				
			}
			map.put("result", 1);
			map.put("message", "success");
			map.put("token", user.getToken());
			map.put("publicKey", user.getPublicKey());
		}
		return map;
	}
	
	private boolean isPasswordValid(String password, User user) {
		boolean flag = false;
		RSA.encryptByPublicKey(password.getBytes(), user.getPublicKey());
		
		return flag;
	}
}