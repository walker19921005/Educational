package com.cjrj.edu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjrj.edu.entity.Teacher;
import com.cjrj.edu.mapper.TeacherMapper;
import com.cjrj.edu.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherMapper teacherMapper;
	@Override
	public List<Teacher> getTeachList() {
		// TODO Auto-generated method stub
		return teacherMapper.getTeachList();
	}

}
