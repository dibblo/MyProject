package com.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "signup")
public class RegisterController {
/*
    @Autowired
    private UserService userService;

    @RequestMapping(method = {RequestMethod.POST})
    public ModelAndView register(LoginCommand loginCommand, HttpServletRequest req) {
        Map<String, Object> map = userService.validateSignup(loginCommand.getUserName(),loginCommand.getPassword(),loginCommand.getRepassword());
        if(!(Boolean)map.get("success")){
            return new ModelAndView("/jsp/login/login",map);
        }
        userService.registerByMd5(loginCommand);
        User user = userService.findUserByUserName(loginCommand.getUserName(),loginCommand.getPassword());
        user.setLastVisit(new Date());
        userService.LoginSuccess(user);
        req.getSession().setAttribute("user", user);
        return new ModelAndView("/jsp/main");
    }
*/

}
