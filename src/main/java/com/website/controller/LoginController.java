package com.website.controller;

import com.website.domain.LoginCommand;
import com.website.domain.User;
import com.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "signin")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("/jsp/login/login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView loginCheck(HttpServletRequest req, LoginCommand loginCommand) {
        Map<String, Object> map = userService.validateSignin(loginCommand.getUserName(),loginCommand.getPassword());
        if(!(Boolean)map.get("success")){
            return new ModelAndView("/jsp/login/login",map);
        }
        User user = userService.findUserByUserName(loginCommand.getUserName(),loginCommand.getPassword());
        user.setLastVisit(new Date());
        user.setLastIp(req.getRemoteAddr());
        userService.LoginSuccess(user);
        req.getSession().setAttribute("user", user);
        return new ModelAndView("/jsp/main");
    }

}
