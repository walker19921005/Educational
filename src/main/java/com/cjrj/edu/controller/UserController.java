package com.cjrj.edu.controller;

import com.cjrj.edu.entity.User;
import com.cjrj.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/chkUserName")
    @ResponseBody
    public String chkUsername(String username){
        User user=userService.findByUsername(username);
        if (user!=null){
            return "false";
        }else {
            return "true";
        }
    }

    @RequestMapping("/chkEmail")
    @ResponseBody
    public String chkEmail(String email){
        User user=userService.findByEmail(email);
        if (user!=null){
            return "false";
        }else {
            return "true";
        }
    }

    @RequestMapping("/user")
    public String getPage(){
        return "user/user";
    }
}
