package com.cjrj.edu.controller;

import com.cjrj.edu.entity.Department;
import com.cjrj.edu.entity.vo.SelectVO;
import com.cjrj.edu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/dept")
    @ResponseBody
    public Object selectDept(){
        List<Department> list=departmentService.selectAllDept();
        List<SelectVO> dept=new ArrayList<SelectVO>();
        for (Department department:list) {
            SelectVO selectVO=new SelectVO();
            selectVO.setId(department.getDeptId());
            selectVO.setText(department.getDeptName());
            dept.add(selectVO);
        }
        return list;
    }
}
