package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Student;
import com.cjrj.edu.mapper.StudentMapper;
import com.cjrj.edu.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService{
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Page<Student> selectAllStudent(Page page) {
        return page.setRecords(studentMapper.selectAllStudent(page));
    }
}
