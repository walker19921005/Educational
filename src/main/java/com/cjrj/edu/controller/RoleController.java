package com.cjrj.edu.controller;

import com.cjrj.edu.entity.Role;
import com.cjrj.edu.entity.vo.SelectVO;
import com.cjrj.edu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/role")
    @ResponseBody
    public Object selectAllRole(){
        Set<Role> roles=roleService.selectAllRoles();
        List<SelectVO> list=new ArrayList<SelectVO>();
        for (Role r :
                roles) {
            SelectVO select = new SelectVO();
            select.setId(r.getRoleId());
            select.setText(r.getRoleDesc());
            list.add(select);
        }
        return list;
    }
}
