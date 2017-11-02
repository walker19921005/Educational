package com.cjrj.edu.entity;

import java.util.List;



/**
 * 请假单
 */
public class LeaveBill {
	private Long id;//主键ID
	private String days;// 请假天数
	private String content;// 请假内容
	private String leaveDate ;// 请假时间
	private String remark;// 备注
	private String name;//请假人
	private List<String> outcomeList;
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getOutcomeList() {
		return outcomeList;
	}

	public void setOutcomeList(List<String> outcomeList) {
		this.outcomeList = outcomeList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Integer state=0;// 请假单状态 0初始录入,1.开始审批,2为审批完成

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
