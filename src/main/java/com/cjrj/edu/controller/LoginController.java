package com.cjrj.edu.controller;

import com.cjrj.edu.entity.User;
import com.cjrj.edu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(User user, Model model){
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("message", "密码不正确!");
            return "views/login";
        }catch (UnknownAccountException uae){
            model.addAttribute("message", "用户名不存在!");
            return "views/login";
        }catch (ExcessiveAttemptsException eae){
            model.addAttribute("message", "登录次数过多");
            return "views/login";
        }
        return "views/index";
    }

}
