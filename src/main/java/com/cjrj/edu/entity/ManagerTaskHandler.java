package com.cjrj.edu.entity;

import javax.servlet.http.HttpServletRequest;


import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContext;

 


/**
 * 员工经理任务分配
 *
 */
@SuppressWarnings("serial")
public class ManagerTaskHandler implements TaskListener {
	
	@Override
	public void notify(DelegateTask delegateTask) {
		/**懒加载异常*/
//		Employee employee = SessionContext.get();
//		//设置个人任务的办理人
//		delegateTask.setAssignee(employee.getManager().getName());
		/**从新查询当前用户，再获取当前用户对应的领导*/
/*		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		User currentUser = (User) request.getSession().getAttribute(Const.SESSION_USER);
		//当前用户
		String name = currentUser.getUsername();
		int sysid = currentUser.getSysid();*/
		//使用当前用户名查询用户的详细信息
		//从web中获取spring容器

		/*		@SuppressWarnings("static-access")
		UserService userService = SpringContextHolder.getContextBean(UserService.class);
		
		//IEmployeeService employeeService = (IEmployeeService) ac.getBean("employeeService");
		User user= userService.findManagerByName(name,sysid);
		//设置个人任务的办理人
		delegateTask.setAssignee(user.getUsername());*/
		
	}

}
