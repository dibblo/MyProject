package com.website.controller;

import com.rbac.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "signin")
public class LoginController {
/*    @Autowired
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
        userService.LoginSuccess(user);
        req.getSession().setAttribute("user", user);
        return new ModelAndView("/jsp/main");
    }*/

    private UserService userService;

    @RequestMapping
    public String loginPage(ModelMap map) {
        map.put("success",true);
        return "/ftl/login";
    }
}
