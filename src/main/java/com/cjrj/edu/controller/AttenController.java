package com.cjrj.edu.controller;

import com.cjrj.edu.entity.User;
import com.cjrj.edu.entity.vo.ActiviUser;
import com.cjrj.edu.mapper.DepartmentMapper;
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

import javax.servlet.http.HttpServletRequest;


@Controller
public class AttenController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 我的请求
     * @param  
     * @param  
     * @param  
     * @return
     */
    @RequestMapping("/business/business")
    public String login( ){
    
        return "business/leaveBill";
    }
    
    /**
     * 部署流程
     * @param  
     * @param  
     * @param  
     * @return
     */
    @RequestMapping("flow/atten")
    public String deploy( ){
    
        return "workflow/repositoty";
    }
    
    
 
}
