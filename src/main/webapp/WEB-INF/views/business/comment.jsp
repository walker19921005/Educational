<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include/easyui_core.jsp"%>
<title>批注信息</title>
</head>
<body>
<div class="fitem">
					<label>请假天数:</label> <input name="days" value="${leaveBill.days }" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>请假原因:</label> <input name="content" value="${leaveBill.content }" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>请假备注:</label> 
					 <input name="remark" class="easyui-textbox" value="${leaveBill.remark }" readonly="readonly">
				</div>
				<div class="fitem">
					<label>请假日期:</label> <input name="leaveDate" value="${leaveBill.leaveDate }" type="text" class="easyui-datebox" readonly="readonly"/>
				</div>
				<div class="fitem">
					<label>请假人:</label> <input name="name" value="${leaveBill.name }" class="easyui-textbox" readonly="readonly">
				</div>
				<c:forEach items="${commentList }" var="list">
					<div class="fitem">
					<label>${list.userId }批注:</label> <textarea id="message" rows=3  name="message"  class="textarea easyui-validatebox" readonly="readonly">${list.fullMessage }</textarea>
				</div>
				</c:forEach>
				<!-- <div id="cc" style="width:200px;padding: 20px 80px;">
					
				</div> -->
</body>
</html>