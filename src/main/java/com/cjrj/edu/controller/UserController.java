package com.cjrj.edu.controller;

import com.cjrj.edu.entity.User;
import com.cjrj.edu.entity.vo.SelectVO;
import com.cjrj.edu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/chkUserName")
    @ResponseBody
    public String chkUsername(String username) throws IOException {
        User user=userService.findByUsername(username);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        if (user!=null){
            map.put("valid", false);
        }else {
            map.put("valid", true);
        }
        return new ObjectMapper().writeValueAsString(map);
    }

    @RequestMapping("/chkEmail")
    @ResponseBody
    public String chkEmail(String email) throws IOException {
        User user=userService.findByEmail(email);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        if (user!=null){
            map.put("valid", false);
        }else {
            map.put("valid", true);
        }
        return new ObjectMapper().writeValueAsString(map);
    }

    @RequestMapping("/deptid")
    @ResponseBody
    public Object selectUserByDeptid() throws IOException {
        List<User> user=userService.selectAllUser();
        List<SelectVO> list=new ArrayList<SelectVO>();
        for (User u :
                user) {
            SelectVO select = new SelectVO();
            select.setId(u.getUserId());
            select.setText(u.getUsername());
            list.add(select);
        }
        return list;
    }

    @RequestMapping("/student")
    public String getPage(){
        return "/user/student";
    }
}
