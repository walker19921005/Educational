package com.cjrj.edu.entity;

import java.util.Date;

public class Course {

	//课程表
	private int course_id;
	private String course_name;
	private int stageid;
	private int course_days;
	private String course_desc;
	private int teachid;
	private Date createdate;
	private String createname;
	private Date modifydate;
	private String modifyname;
	private int del_flag;
	private int[] ids;
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getStageid() {
		return stageid;
	}
	public void setStageid(int stageid) {
		this.stageid = stageid;
	}
	public int getCourse_days() {
		return course_days;
	}
	public void setCourse_days(int course_days) {
		this.course_days = course_days;
	}
	public String getCourse_desc() {
		return course_desc;
	}
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}
	public int getTeachid() {
		return teachid;
	}
	public void setTeachid(int teachid) {
		this.teachid = teachid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getCreatename() {
		return createname;
	}
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public String getModifyname() {
		return modifyname;
	}
	public void setModifyname(String modifyname) {
		this.modifyname = modifyname;
	}
	public int getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}
}
