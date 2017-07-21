package com.website.controller;

import com.website.domain.LoginCommand;
import com.website.domain.User;
import com.website.securityt.util.MD5;
import com.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/tologin", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("/jsp/login/login");
    }

    @RequestMapping(value = "/signin")
    public String registerPage() {
        return "/jsp/login/register";
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.POST})
    public ModelAndView loginCheck(HttpServletRequest req, LoginCommand loginCommand) {
        Map<String,Object> map = new HashMap<String,Object>();
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName());
        if (!isValidUser) {
            map.put("msg", "此用户不存在");
            map.put("success",false);
            return new ModelAndView("/jsp/login/login", map);
        }
        int userCount = userService.userLogin(loginCommand.getUserName(), MD5.getMD5(loginCommand.getPassword()));
        if (userCount == 0) {
            map.put("msg","账号或密码不正确，请重新输入");
            map.put("success",false);
            return new ModelAndView("/jsp/login/login",map);
        }
        User user = userService.findUserByUserName(loginCommand.getUserName());
        user.setLasstVist(new Date());
        user.setLastIp(req.getRemoteAddr());
        userService.LoginSuccess(user);
        req.getSession().setAttribute("user", user);
        return new ModelAndView("/jsp/main");
    }


    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ModelAndView register(LoginCommand loginCommand, HttpServletRequest req) {
        boolean isRegister = userService.hasRegister(loginCommand.getUserName().trim());
        Map<String,Object> map = new HashMap<String,Object>();
        if (isRegister) {
            map.put("msg", "此用户名已注册");
            map.put("success",false);
            return new ModelAndView("/jsp/login/register", map);
        }
        if (!loginCommand.getPassword().equals(loginCommand.getRepassword())) {
            map.put("msg","两次填写的密码不一致，请检查后重新输入");
            map.put("success",false);
            return new ModelAndView("/jsp/login/register", map);
        }
        userService.registerByMd5(loginCommand);
        User user = userService.findUserByUserName(loginCommand.getUserName());
        user.setLasstVist(new Date());
        user.setLastIp(req.getRemoteAddr());
        userService.LoginSuccess(user);
        req.getSession().setAttribute("user", user);
        return new ModelAndView("/jsp/main");
    }

}
