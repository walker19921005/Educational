package com.cjrj.edu.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.cjrj.edu.entity.Student;
import com.cjrj.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getAllStudent(@RequestParam("pageNumber")Integer pageNumber,@RequestParam("pageSize")Integer pageSize){
        Page<Student> page=new Page<Student>(pageNumber,pageSize);
        page=studentService.selectAllStudent(page);
        return page;
    }
}
