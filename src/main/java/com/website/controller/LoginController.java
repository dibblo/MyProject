package com.website.controller;

import com.website.domain.LoginCommand;
import com.website.domain.User;
import com.website.securityt.util.MD5;
import com.website.securityt.util.RSAUtil;
import com.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String loginPage() {
        return "/jsp/login/login.jsp";
    }

    @RequestMapping(value = "/signin")
    public String registerPage() {
        return "/jsp/login/register.jsp";
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.POST})
    public ModelAndView loginCheck(HttpServletRequest req, LoginCommand loginCommand) {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName());
        if (!isValidUser) {
            return new ModelAndView("/jsp/login/login.jsp", "error", "此用户不存在");
        }
        int userCount = userService.userLogin(loginCommand.getUserName(), MD5.getMD5(loginCommand.getPassword()));
        if(userCount==0){
            return new ModelAndView("/jsp/login/login.jsp", "error", "账号或密码不正确，请重新输入");
        }
        User user = userService.findUserByUserName(loginCommand.getUserName());
        user.setLasstVist(new Date());
        user.setLastIp(req.getRemoteAddr());
        userService.LoginSuccess(user);
        req.getSession().setAttribute("user", user);
        return new ModelAndView("/jsp/main.jsp");
    }


    @RequestMapping(value = "/registermd5", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map register(LoginCommand loginCommand) {
        Map<String, Object> map = new HashMap<String, Object>();
        boolean isRegister = userService.hasRegister(loginCommand.getUserName().trim());
        if (isRegister) {
            map.put("result", 0);
            map.put("message", "此用户名已注册");
            return map;
        }
        if (!loginCommand.getPassword().equals(loginCommand.getRepassword())) {
            map.put("result", 0);
            map.put("message", "两次填写的密码不一致，请检查后重新输入");
            return map;
        }
        userService.registerByMd5(loginCommand);
        map.put("result", 1);
        map.put("message", "123");
        return map;
    }

}
