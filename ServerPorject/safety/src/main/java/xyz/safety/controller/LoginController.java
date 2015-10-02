package xyz.safety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xyz.safety.service.UserService;
import xyz.safety.vo.Users;

/**
 * Created by lihongjun on 15/9/28.
 */
@Controller
@RequestMapping(value = "login")
public class LoginController {

    private String PAGE_LOGIN_OK = "login/loginOk";
    private String PAGE_LOGIN_INDEX = "login/login";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView result = new ModelAndView(PAGE_LOGIN_INDEX);
        return result;
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ModelAndView save(Users user){
        ModelAndView result = new ModelAndView(PAGE_LOGIN_OK);
        userService.saveUser(user);
        result.addObject("user",user);
        return result;
    }
}
