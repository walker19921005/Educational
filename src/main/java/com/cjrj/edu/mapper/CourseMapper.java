package com.cjrj.edu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cjrj.edu.entity.Course;

@Repository
public interface CourseMapper {

	/**
	 * 添加课程
	 * @return
	 */
	@Insert("insert into stage_course(course_id,course_name,stageid,course_days,course_desc,teachid,createdate,createname,del_flag) values(#{course_id},#{course_name},#{stageid},#{course_days},#{course_desc},#{teachid},sysdate,#{createname},0)")
	@SelectKey(statement="select course_seq.nextval from dual",keyProperty="course_id",before=true,resultType=Integer.class)
	public int addCourse(Course course);
	
	/**
	 * 分页查找所有课程
	 * @return
	 */
	//@Select("select course_id course_name,stageid,course_days,course_desc,teachid from (select  s.*,rownum rn from stage_course s)  where rn>#{startPage} and rn<=#{endPage}")
	public List<Course> getCourseList(Map<String,Object>map);
	
	/**
	 * 统计所有课程数量
	 * @return
	 */
	@Select("select count(*) as count from stage_course where del_flag=0")
	public int getCourseCount();
	
	/**
	 * 更新课程信息
	 * @param course
	 * @return
	 */
	//@Update("update stage_course set course_name=#{course_name},stageid=#{stageid},course_days=#{course_days},course_desc=#{course_desc},teachid=#{teachid},modifydate=sysdate,modifyname=#{modifyname},del_flag=#{del_flag} where course_id=#{course_id}")
	public int updateCourse(Course course);
	
	/**
	 * 根据课程id查找课程信息
	 * @param course_id
	 * @return
	 */
	//@Select("select * from stage_course where course_id=#{course_id}")
	public Course getCourseById(int course_id);
	
	/**
	 * 删除
	 * @param del_flag
	 * @return
	 */
	public int delCourseById(Map<String,Object>map);
}
