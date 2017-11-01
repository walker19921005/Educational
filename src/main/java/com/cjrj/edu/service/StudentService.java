package com.cjrj.edu.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.cjrj.edu.entity.Student;

public interface StudentService {
    Page<Student> selectAllStudent(Page page);
}
