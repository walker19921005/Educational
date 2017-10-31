package com.cjrj.edu.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjrj.edu.entity.Course;
import com.cjrj.edu.mapper.CourseMapper;
import com.cjrj.edu.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper courseMapper;
	
	/**
	 * 添加课程
	 */
	@Override
	public int addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.addCourse(course);
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<Course> getCourseList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 List<Course> list=courseMapper.getCourseList(map);
		return list;
	}

	/**
	 * 查询统计所有课程数量
	 */
	@Override
	public int getCourseCount() {
		// TODO Auto-generated method stub
		return courseMapper.getCourseCount();
	}

	/**
	 * 更新课程信息
	 */
	@Override
	public int updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseMapper.updateCourse(course);
	}

	/**
	 * 根据课程id查找课程信息
	 */
	@Override
	public Course getCourseById(int course_id) {
		// TODO Auto-generated method stub
		return courseMapper.getCourseById(course_id);
	}

	/**
	 * 删除
	 * @param del_flag
	 * @return
	 */
	@Override
	public int delCourse(Map<String,Object>map) {
		// TODO Auto-generated method stub
		return courseMapper.delCourseById(map);
	}

}
