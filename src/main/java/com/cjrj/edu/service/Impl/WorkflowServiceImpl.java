package com.cjrj.edu.service.Impl;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjrj.edu.entity.LeaveBill;
import com.cjrj.edu.entity.PageHelper;
import com.cjrj.edu.entity.User;
import com.cjrj.edu.entity.WorkflowBean;
import com.cjrj.edu.mapper.LeaveBillMapper;
import com.cjrj.edu.service.WorkflowService;
import com.cjrj.edu.util.Const;
import com.cjrj.edu.util.ResultDO;

@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowService{
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private HistoryService historyService;
	@Autowired
	private LeaveBillMapper leaveBillMapper;

	
	public ResultDO<Integer> repositoty(WorkflowBean bean) {
		int result = 0;
		
		ZipInputStream zip;
		try {
			InputStream in = new FileInputStream(bean.getFile());
			zip = new ZipInputStream(in);
			repositoryService.createDeployment()//创建部署对象
			.name(bean.getFilename())
			.addZipInputStream(zip) 
			.deploy();
			result=1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		return new ResultDO<Integer>(result);
	}


	/**
	 * 流程部署查询
	 */
	public List<Deployment> getInfo(PageHelper page) {
		int start = (page.getPage()-1)*page.getPage();
		int end = page.getPage()*page.getRows();
		List<Deployment> list = repositoryService.createDeploymentQuery()
						
						.listPage(start, end);
						
		return list;
	}
	/**查询流程定义的信息，对应表（act_re_procdef）*/
	
	public ProcessDefinition findProcessDefinitionList(String deploymentId) {
		ProcessDefinition pro = repositoryService.createProcessDefinitionQuery()//创建流程定义查询
							.orderByProcessDefinitionVersion().asc()//
							.deploymentId(deploymentId)
							.singleResult();
		return pro;
	}


	
	@SuppressWarnings("deprecation")
	public ResultDO<Integer> delDeploymentById(String id) {
		int result = 0;
		try {
			repositoryService.deleteDeploymentCascade(id);
			result=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResultDO<Integer>(result);
	}
	
	
	public InputStream getPictureByDeploymentId(WorkflowBean bean) {
		InputStream in=null;
		try {
			in = repositoryService.getResourceAsStream(bean.getDeploymentId(), bean.getImageName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;				
		
	}
	
	/**更新请假状态，启动流程实例，让启动的流程实例关联业务*/
	
	public void saveStartProcess(HttpServletRequest request,WorkflowBean workflowBean) {
		//1：获取请假单ID，使用请假单ID，查询请假单的对象LeaveBill
		Long id = workflowBean.getId();
		LeaveBill leaveBill = leaveBillMapper.findLeaveBillById(id);
		//2：更新请假单的请假状态从0变成1（初始录入-->审核中）
		leaveBill.setStatus("审核中");
		Integer result = leaveBillMapper.updateStatus(leaveBill);
		//3：使用当前对象获取到流程定义的key（对象的名称就是流程定义的key）
		String key = leaveBill.getClass().getSimpleName();
		/**
		 * 4：从Session中获取当前任务的办理人，使用流程变量设置下一个任务的办理人
			    * inputUser是流程变量的名称，
			    * 获取的办理人是流程变量的值
		 */
		Map<String, Object> variables = new HashMap<String,Object>();
		User user =(User)request.getSession().getAttribute(Const.SESSION_USER);
		variables.put("inputUser", user.getUsername());//表示惟一用户
		/**
		 * 5：	(1)使用流程变量设置字符串（格式：LeaveBill.id的形式），通过设置，让启动的流程（流程实例）关联业务
   				(2)使用正在执行对象表中的一个字段BUSINESS_KEY（Activiti提供的一个字段），让启动的流程（流程实例）关联业务
		 */
		//格式：LeaveBill.id的形式（使用流程变量）
		String objId = key+"."+id;
		variables.put("objId", objId);
		//6：使用流程定义的key，启动流程实例，同时设置流程变量，同时向正在执行的执行对象表中的字段BUSINESS_KEY添加业务数据，同时让流程关联业务
		runtimeService.startProcessInstanceByKey(key,objId,variables);
		
	}
	/**2：使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>*/

	public List<Task> findTaskListByName(String name) {
		List<Task> list = taskService.createTaskQuery()//
					.taskAssignee(name)//指定个人任务查询
					.orderByTaskCreateTime().asc()//
					.list();
		return list; 
	}
	
	/**
	 * 办理当前任务
	 */
	/**一：使用任务ID，查找请假单ID，从而获取请假单信息*/
	public LeaveBill findLeaveBillByTaskId(String taskId) {
		//1：使用任务ID，查询任务对象Task
		Task task = taskService.createTaskQuery()//
						.taskId(taskId)//使用任务ID查询
						.singleResult();
		//2：使用任务对象Task获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		//3：使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		//4：使用流程实例对象获取BUSINESS_KEY
		String buniness_key = pi.getBusinessKey();
		//5：获取BUSINESS_KEY对应的主键ID，使用主键ID，查询请假单对象（LeaveBill.1）
		String id = "";
		if(StringUtils.isNotBlank(buniness_key)){
			//截取字符串，取buniness_key小数点的第2个值
			id = buniness_key.split("\\.")[1];
		}
		//查询请假单对象
		
		LeaveBill leaveBill = leaveBillMapper.findLeaveBillById(Long.parseLong(id));
		return leaveBill;
	}
	
	/**二：已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中*/
	public List<String> findOutComeListByTaskId(String taskId) {
		//返回存放连线的名称集合
		List<String> list = new ArrayList<String>();
		//1:使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()//
					.taskId(taskId)//使用任务ID查询
					.singleResult();
		//2：获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		//3：查询ProcessDefinitionEntiy对象
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
		//使用任务对象Task获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		//使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
					.processInstanceId(processInstanceId)//使用流程实例ID查询
					.singleResult();
		//获取当前活动的id
		String activityId = pi.getActivityId();
		//4：获取当前的活动
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
		//5：获取当前活动完成之后连线的名称
		List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
		if(pvmList!=null && pvmList.size()>0){
			for(PvmTransition pvm:pvmList){
				String name = (String) pvm.getProperty("name");
				if(StringUtils.isNotBlank(name)){
					list.add(name);
				}
				else{
					list.add("默认提交");
				}
			}
		}
		return list;
	}
	
	/**指定连线的名称完成任务*/
	
	public void saveSubmitTask(HttpServletRequest request,WorkflowBean workflowBean) {
		//获取任务ID
		String taskId = workflowBean.getTaskId();
		//获取连线的名称
		String outcome = workflowBean.getOutcome();
		//批注信息
		String message = workflowBean.getComment();
		//获取请假单ID
		Long id = workflowBean.getId();
		
		/**
		 * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
		 */
		//使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = taskService.createTaskQuery()//
						.taskId(taskId)//使用任务ID查询
						.singleResult();
		//获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		/**
		 * 注意：添加批注的时候，由于Activiti底层代码是使用：
		 * 		String userId = Authentication.getAuthenticatedUserId();
			    CommentEntity comment = new CommentEntity();
			    comment.setUserId(userId);
			  所有需要从Session中获取当前登录人，作为该任务的办理人（审核人），对应act_hi_comment表中的User_ID的字段，不过不添加审核人，该字段为null
			 所以要求，添加配置执行使用Authentication.setAuthenticatedUserId();添加当前任务的审核人
		 * */
		User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
		Authentication.setAuthenticatedUserId(user.getUsername());
		taskService.addComment(taskId, processInstanceId, message);
		/**
		 * 2：如果连线的名称是“默认提交”，那么就不需要设置，如果不是，就需要设置流程变量
		 * 在完成任务之前，设置流程变量，按照连线的名称，去完成任务
				 流程变量的名称：outcome
				 流程变量的值：连线的名称
		 */
		Map<String, Object> variables = new HashMap<String,Object>();
		if(outcome!=null && !outcome.equals("默认提交")){
			variables.put("outcome", outcome);
		}

		//3：使用任务ID，完成当前人的个人任务，同时流程变量
		taskService.complete(taskId, variables);
		//4：当任务完成之后，需要指定下一个任务的办理人（使用类）-----已经开发完成
		
		/**
		 * 5：在完成任务之后，判断流程是否结束
   			如果流程结束了，更新请假单表的状态从1变成2（审核中-->审核完成）
		 */
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		//流程结束了
		if(pi==null){
			//更新请假单表的状态从1变成2（审核中-->审核完成）
			LeaveBill bill = leaveBillMapper.findLeaveBillById(id);
			bill.setStatus("审核完成");
			Integer result = leaveBillMapper.updateStatus(bill);
		}
	}

	/**使用请假单ID，查询历史批注信息*/
	
	public List<Comment> findCommentByLeaveBillId(Long id) {
		//使用请假单ID，查询请假单对象
		LeaveBill leaveBill = leaveBillMapper.findLeaveBillById(id);
		//获取对象的名称
		String objectName = leaveBill.getClass().getSimpleName();
		//组织流程表中的字段中的值
		String objId = objectName+"."+id;
		
		/**1:使用历史的流程实例查询，返回历史的流程实例对象，获取流程实例ID*/
//		HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery()//对应历史的流程实例表
//						.processInstanceBusinessKey(objId)//使用BusinessKey字段查询
//						.singleResult();
//		//流程实例ID
//		String processInstanceId = hpi.getId();
		/**2:使用历史的流程变量查询，返回历史的流程变量的对象，获取流程实例ID*/
		HistoricVariableInstance hvi = historyService.createHistoricVariableInstanceQuery()//对应历史的流程变量表
						.variableValueEquals("objId", objId)//使用流程变量的名称和流程变量的值查询
						.singleResult();
		//流程实例ID
		String processInstanceId = hvi.getProcessInstanceId();
		List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
		return list;
	}


	
	public List<Deployment> getFlowlist() {
		List<Deployment> list = repositoryService.createDeploymentQuery()
						.list();
		return list;
	}
	
	
	
}
