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
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 鐧诲綍
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/login.do")
    public String login(@RequestParam("Username") String username,@RequestParam("Password") String password, Model model){
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("message", "瀵嗙爜涓嶆纭�!");
            return "login.jsp";
        }catch (UnknownAccountException uae){
            model.addAttribute("message", "鐢ㄦ埛鍚嶄笉瀛樺湪!");
            return "login.jsp";
        }catch (ExcessiveAttemptsException eae){
            model.addAttribute("message", "鐧诲綍娆℃暟杩囧");
            return "login.jsp";
        }
        ActiviUser user= (ActiviUser) subject.getPrincipal();
        subject.getSession().setAttribute("user", user);
        return "index";
    }

    /**
     * 娉ㄥ唽
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/register.do")
    public String register(User user, HttpServletRequest request,Model model){
        if ("post".equalsIgnoreCase(request.getMethod())) {
            PasswordHelper passwordHelper = new PasswordHelper();
            passwordHelper.encryptPassword(user);
            int i = userService.insertSelective(user);
            if (i > 0) {
                return "login.jsp";
            }
        }else {
            //model.addAttribute("dept",departmentMapper.selectAllDept());
        }
        return "register";
    }
}
