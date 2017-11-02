package com.cjrj.edu.service;

import java.io.File;


import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import com.cjrj.edu.entity.LeaveBill;
import com.cjrj.edu.entity.PageHelper;
import com.cjrj.edu.entity.WorkflowBean;
import com.cjrj.edu.util.ResultDO;

 

public interface WorkflowService {

	public ResultDO<Integer> repositoty(WorkflowBean bean);
	public List<Deployment> getInfo(PageHelper page);
	public ProcessDefinition findProcessDefinitionList(String deploymentId);
	public ResultDO<Integer> delDeploymentById(String id);
	public  InputStream  getPictureByDeploymentId(WorkflowBean bean);
	public void saveStartProcess(HttpServletRequest request,WorkflowBean bean);
	public List<Task> findTaskListByName(String name);
	public LeaveBill findLeaveBillByTaskId(String taskId);
	public List<String> findOutComeListByTaskId(String taskId);
//	public List<Comment> findCommentByTaskId(String taskId);
	public void saveSubmitTask(HttpServletRequest request,WorkflowBean bean);
	public List<Comment> findCommentByLeaveBillId(Long id);
	public List<Deployment> getFlowlist();
	
}
