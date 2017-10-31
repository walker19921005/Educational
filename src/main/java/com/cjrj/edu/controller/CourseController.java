package com.cjrj.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjrj.edu.entity.Course;
import com.cjrj.edu.entity.Stage;
import com.cjrj.edu.entity.Teacher;
import com.cjrj.edu.service.CourseService;
import com.cjrj.edu.service.StageService;
import com.cjrj.edu.service.TeacherService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StageService stageService;
	/**
	 * 跳转到课程管理页面
	 * @return
	 */
	@RequestMapping("/coursepage")
	public String gotoCourse(){
		return "myfile/course";
	}
	
	/**
	 * 分页查询课程  
	 * 必须要返回 rows(封装数据的集合) total(总数)
	 * @param pageNumber 当前页
	 * @param pageSize  显示条数
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCourseList")
	public Map<String,Object> getCourseList(@RequestParam(value="pageNumber",defaultValue="1",required=false)int pageNumber,@RequestParam(value="pageSize")int pageSize){
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("startPage", (pageNumber-1)*pageSize);
		map.put("endPage", pageNumber*pageSize);
		List<Course>courselist=courseService.getCourseList(map);
		int count=courseService.getCourseCount();
		Map<String,Object>maps=new HashMap<String,Object>();
		maps.put("rows", courselist);
		maps.put("total", count);
		return maps;
	}
	
	/**
	 * 添加课程信息
	 * @param course
	 * @return
	 */
	@Transactional
	@ResponseBody
	@RequestMapping("/addcou.do")
	public int  addCourse(Course course){
		course.setCreatename("admin");
		int i=courseService.addCourse(course);
		return i;
	}
	
	/**
	 * 添加之前查询所有教师，阶段
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSelList")
	public Map<String,Object> getSelList(){
		Map<String,Object>map=new HashMap<String,Object>();
		List<Teacher>tlist=teacherService.getTeachList();
		List<Stage>slist=stageService.getStageList();
		map.put("tlist", tlist);
		map.put("slist", slist);
		return map;
	}
	
	/**
	 * 根据课程id获取课程信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getCourseById")
	public Map<String,Object> getCourseById(@RequestParam("course_id")int id){
		Course course=courseService.getCourseById(id);
		List<Teacher>tlist=teacherService.getTeachList();
		List<Stage>slist=stageService.getStageList();
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("tlist", tlist);
		map.put("course", course);
		map.put("slist", slist);
		return map;
	}
	
	/**
	 * 更新课程信息
	 * @param course
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCourse")
	@Transactional
	public int updateCourse(Course course){
		course.setModifyname("admin");
		int i=courseService.updateCourse(course);
		return i;
	}
	
	/**
	 * 删除课程
	 */
	@Transactional
	@ResponseBody
	@RequestMapping("/delCourse")
	public int delCourse(@RequestParam("id")int id){
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("course_id", id);
		map.put("del_flag", 1);
		int i=courseService.delCourse(map);
		return i;
	}
	
	/**
	 * 批量删除
	 * @return
	 */
	@ResponseBody
	@Transactional
	@RequestMapping("/delAll")
	public boolean delAllCourse(@RequestParam("ids")int[] course_ids){
		Map<String,Object>map=new HashMap<String,Object>();
		boolean flag=false;
		map.put("del_flag", 1);
		int n=0;
		for(int c:course_ids){
			map.put("course_id", c);
			int i=courseService.delCourse(map);
			if(i>0){
				n++;
			}
		}
		if(n==course_ids.length){
			flag=true;
		}
		return flag;
	}
}
