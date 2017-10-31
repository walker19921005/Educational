package com.cjrj.edu.service;

import java.util.List;

import com.cjrj.edu.entity.Teacher;

public interface TeacherService {

	/**
     * 查询所有教师
     * @return
     */
    public List<Teacher>getTeachList();
}
