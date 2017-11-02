package com.cjrj.edu.controller;

import java.io.File;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cjrj.edu.entity.DeploymentProcessBean;
import com.cjrj.edu.entity.LeaveBill;
import com.cjrj.edu.entity.PageHelper;
import com.cjrj.edu.entity.TaskBean;
import com.cjrj.edu.entity.User;
import com.cjrj.edu.entity.WorkflowBean;
import com.cjrj.edu.entity.vo.ActiviUser;
import com.cjrj.edu.mapper.LeaveBillMapper;
import com.cjrj.edu.service.WorkflowService;
import com.cjrj.edu.util.Const;
import com.cjrj.edu.util.DataGrid;
import com.cjrj.edu.util.ResultDO;
import com.cjrj.edu.util.Tree;

 

@Controller
public class WorkflowController {
	
	@Autowired
	private WorkflowService workflowService;
	@Autowired
	private LeaveBillMapper leaveBillService;
	/**
	 * 跳转页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/workflow/repository.action")
	public String toRepositoryPage(Model model){
		return "workflow/repositoty";
	}
	@RequestMapping("/workflow/listflow.action")
	public String toflow(Model model){
		return "business/worktime";
	}
	@RequestMapping("/workflow/todealtpage.action")
	public String todealtPage(Model model){
		return "business/dealtwith";
	}
	/**
	 * 流程部署
	 */
	@RequestMapping("/workflow/deployment.action")
	@ResponseBody
	public ResultDO<Integer> repository(WorkflowBean bean,HttpServletRequest request,HttpServletResponse response){
		
		ResultDO<Integer> rdo = workflowService.repositoty(bean);
		return rdo;
	}
	/**
	 * 获取流程列表树(请求)
	 */
	@RequestMapping("/workflow/flowlist.action")
	@ResponseBody
	public List<Tree> flowlist(){
		List<Deployment> deployment = workflowService.getFlowlist();
		List<Tree> listTree = new ArrayList<Tree>();
		for(Deployment dep : deployment){
			Tree tree = new Tree();
			if(dep.getId().equals("115001")){
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("url", "/worktime/listpage.action");
				tree.setAttributes(attr);
			}else if(dep.getId().equals("35001")){
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("url", "/leaveBill/list.action");
				tree.setAttributes(attr);
			}
			tree.setId(Integer.parseInt(dep.getId()));
			tree.setText(dep.getName());
			listTree.add(tree);
		}
		return listTree;
	}
	//待办流程树
	@RequestMapping("/workflow/dealt.action")
	@ResponseBody
	public List<Tree> flowlist1(){
		List<Deployment> deployment = workflowService.getFlowlist();
		List<Tree> listTree = new ArrayList<Tree>();
		for(Deployment dep : deployment){
			Tree tree = new Tree();
			if(dep.getId().equals("115001")){
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("url", "/worktime/listtask.action");
				tree.setAttributes(attr);
			}else if(dep.getId().equals("35001")){
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("url", "/leaveflow/tasklist.action");
				tree.setAttributes(attr);
			}
			tree.setId(Integer.parseInt(dep.getId()));
			tree.setText(dep.getName());
			listTree.add(tree);
		}
		return listTree;
	}
	/**
	 * 流程定义部署查询
	 */
	@RequestMapping("/workflow/getInfo.action")
	@ResponseBody
	public List<DeploymentProcessBean> getInfo(PageHelper page){
		List<DeploymentProcessBean> deplist = new ArrayList<DeploymentProcessBean>();
		List<Deployment> list = workflowService.getInfo(page);
		for(Deployment dep : list){
			ProcessDefinition process = workflowService.findProcessDefinitionList(dep.getId());
			DeploymentProcessBean bean = new DeploymentProcessBean();
			bean.setId(dep.getId());
			bean.setDeploymentTime(dep.getDeploymentTime().toLocaleString());
			bean.setName(dep.getName());
			bean.setDiagramResourceName(process.getDiagramResourceName());
			deplist.add(bean);
		}
		

		return deplist;
	}
	/**
	 * 删除流程
	 * @param bean
	 * @return
	 */
	@RequestMapping("/workflow/delDeployment.action")
	@ResponseBody
	public ResultDO<Integer> delDep(WorkflowBean bean){
		ResultDO<Integer> rdo = workflowService.delDeploymentById(bean.getDeploymentId());
		return rdo;
	}
	/**
	 * 查看流程图
	 * @param bean
	 * @param response
	 * @return
	 */
	@RequestMapping("/workflow/getPicture.action")
	public String getPicture(WorkflowBean bean,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		
		InputStream in = workflowService.getPictureByDeploymentId(bean);
		// 3：从response对象获取输出流
		OutputStream out;
		try {
			out = response.getOutputStream();
			// 4：将输入流中的数据读取出来，写到输出流中
			for (int b = -1; (b = in.read()) != -1;) {
				out.write(b);
			}
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	//跳转待办页面
	@RequestMapping("/leaveflow/tasklist.action")
	public String toTaskList(Model model){
		return "workflow/tasklist";
	}
	/**
	 * 获取当前人任务
	 * @return
	 */
	@RequestMapping("/leaveflow/list.action")
	@ResponseBody
	public DataGrid getTaskList(HttpServletRequest request){
		List<TaskBean> tasklist = new ArrayList<TaskBean>(); 
		//User user = (User)request.getSession().getAttribute(Const.SESSION_USER);
		Subject subject= SecurityUtils.getSubject();
		 
		ActiviUser user = (ActiviUser) subject.getSession().getAttribute("user");
System.out.println(user.getUsername()+"AAAAAAAAAAAAAA");		
		DataGrid dg = new DataGrid();
		List<Task> list = workflowService.findTaskListByName(user.getUsername());
		for(Task task:list){
			TaskBean tb = new TaskBean();
			tb.setAssignee(task.getAssignee());
			tb.setCreateTime(task.getCreateTime().toLocaleString());
			tb.setId(task.getId());
			tb.setName(task.getName());
			tasklist.add(tb);
System.out.println(task.getName()+"BBBBBBBBBBBBBBBB");
		}
		dg.setRows(tasklist);
		return dg;
	}
	
	/**
	 * 办理当前任务
	 */
	// 准备表单数据
		@RequestMapping("/leaveflow/audit.action")
		@ResponseBody
		public ResultDO<LeaveBill> audit(WorkflowBean bean,Model model){
			//获取任务ID
			String taskId = bean.getTaskId();
			/**一：使用任务ID，查找请假单ID，从而获取请假单信息*/
			LeaveBill leaveBill = workflowService.findLeaveBillByTaskId(taskId);
			
			/**二：已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中*/
			List<String> outcomeList = workflowService.findOutComeListByTaskId(taskId);
			//String[] outcome = ConvertUtil.listToString(outcomeList, "-").split("-");
			leaveBill.setOutcomeList(outcomeList);
			
			return new ResultDO<LeaveBill>(leaveBill);
		}
		
		
		/**
		 * 提交任务
		 */
		@RequestMapping("/workflow/end.action")
		@ResponseBody
		public ResultDO<Boolean> submitTask(HttpServletRequest request,WorkflowBean bean){
			workflowService.saveSubmitTask(request,bean);
			return new ResultDO<Boolean>(true);
		}
		
		// 查看历史的批注信息
		@RequestMapping("/workflow/comment.action")
		public String viewHisComment(WorkflowBean workflowBean,Model model){
			//获取清单ID
			Long id = workflowBean.getId();
			//1：使用请假单ID，查询请假单对象，将对象放置到栈顶，支持表单回显
			LeaveBill leaveBill = leaveBillService.findLeaveBillById(id);
			//ValueContext.putValueStack(leaveBill);
			//2：使用请假单ID，查询历史的批注信息
			List<Comment> commentList = workflowService.findCommentByLeaveBillId(id);
			//ValueContext.putValueContext("commentList", commentList);
			System.out.println(commentList.get(0).getFullMessage());
			model.addAttribute("leaveBill",leaveBill);
			model.addAttribute("commentList", commentList);
			return "business/comment";
		}
	
}
