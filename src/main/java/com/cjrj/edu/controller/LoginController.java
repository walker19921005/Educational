package com.cjrj.edu.controller;

import com.cjrj.edu.entity.User;
import com.cjrj.edu.entity.vo.ActiviUser;
import com.cjrj.edu.service.UserService;
import com.cjrj.edu.util.PasswordHelper;
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
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(@RequestParam("Username") String username,@RequestParam("Password") String password, Model model){
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("message", "密码不正确!");
            return "login";
        }catch (UnknownAccountException uae){
            model.addAttribute("message", "用户名不存在!");
            return "login";
        }catch (ExcessiveAttemptsException eae){
            model.addAttribute("message", "登录次数过多");
            return "login";
        }

//        User user = userService.findByUsername(username);
        ActiviUser user= (ActiviUser) subject.getPrincipal();
        subject.getSession().setAttribute("user", user);
        model.addAttribute("menu",user.getTree());
        return "index";
    }

    @RequestMapping("/register.do")
    public String register(User user){
        PasswordHelper passwordHelper=new PasswordHelper();
        passwordHelper.encryptPassword(user);
        int i=userService.insertSelective(user);
        if (i>0){
            return "login";
        }else {
            return "register";
        }
    }
}
