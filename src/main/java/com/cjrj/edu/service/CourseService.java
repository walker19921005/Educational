package com.cjrj.edu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.cjrj.edu.entity.Course;

public interface CourseService {


	/**
	 * 添加课程
	 * @return
	 */
	public int addCourse(Course course);
	
	/**
	 * 分页查找所有课程
	 * @return
	 */
	public List<Course>getCourseList(Map<String,Object>map);
	
	/**
	 * 统计所有课程数量
	 * @return
	 */
	public int getCourseCount();
	
	/**
	 * 更新课程信息
	 * @param course
	 * @return
	 */
	public int updateCourse(Course course);
	
	/**
	 * 根据课程id查找课程信息
	 * @param course_id
	 * @return
	 */
	public Course getCourseById(int course_id);
	
	/**
	 * 删除
	 * @param del_flag
	 * @return
	 */
	public int delCourse(Map<String,Object>map);

}
