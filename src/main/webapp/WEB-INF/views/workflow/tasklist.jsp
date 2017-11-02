<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include/easyui_core.jsp"%>
<title>我的请求</title>
<script type="text/javascript">
	/**
	 *格式化操作，在每行的操作栏显示编辑和删除操作
	 */
	function formatAction(value, row, index) {
		var str = '';
		if (true) {
			//str += '<a href="javascript:onEdit()"><img src="../js/easyui/themes/icons/pencil.png" alt="编辑" title="编辑" /></a>';
			str += '<a href="javascript:runtask()">办理任务</a>';
		}
		str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
		if (true) {
			str += '<a href="javascript:getPicture()">查看当前流程图</a>';
		}
		return str;
	}
	//办理任务
	function runtask(){
		//alert('123');
		var row = $('#datagrid').datagrid('getSelected');
		$("#taskId").val(row.id);
		//alert(row.id);
		$.ajax({
			url: path+'/leaveflow/audit.action',
			type:'post',
			dataType:'json',
			data:{
				taskId:row.id
			},
			success:function(data){
				var list = data.obj.outcomeList;
				$("#uploadForm").form('load',data.obj);
				var obj="";
				for(var i=0;i<list.length;i++){
					obj+="<input type='button' onclick='endTask(this)' name='outcome' value='"+list[i]+"'> &nbsp;&nbsp;&nbsp;&nbsp;";
				}
				$(obj).prependTo("#cc");
				$("#dlg2").dialog('open').dialog('setTitle','假单详情');
			},
			error:function(){
				alert('error');
			}
		}); 
		
	}
	//刷新
	function reload() {
		$('#datagrid').datagrid('reload');
	}
	//提交流程
	function endTask(obj){
		var taskId = $("#taskId").val();
		var outcome = $(obj).val();
		var ids = $("#ids").val();
		var message = $("#message").val();
		$.ajax({
			url: path+'/workflow/end.action',
			type:'post',
			dataType:'json',
			data:{
				taskId:taskId,
				id:ids,
				outcome:outcome,
				comment:message
			},
			success:function(data){
				//alert(data.ok);
				if(data.ok){
					$.messager.show({
						title:'系统提示',
						msg:'申请成功'
					});
					$("#dlg2").dialog('close');
					$("#cc").text('');
					$('#datagrid').datagrid('reload');
				}else{
					$.messager.show({
						title:'系统提示',
						msg:'申请失败'
					});
					$("#dlg2").dialog('close');
					$("#cc").text('');
					$('#datagrid').datagrid('reload');
				}
			},
			error:function(){
				alert('error');
			}
		});
	}
	
</script>
</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<table id="datagrid" class="easyui-datagrid" fit="true"
			url="${path }/leaveflow/list.action"  toolbar="#toolbar" 
			pagination="true" singleSelect="true" fitColumns="true"
			rownumbers="true" striped="true" border="false" nowrap="false">
			<thead>
				<tr>
					<th field="id" width="100">任务ID</th>
					<th field="name" width="100">任务名称</th>
					<th field="createTime" width="100">创建时间</th>
					<th field="assignee" width="100">任务人</th>
					
					<th data-options="field:'action',width:120,formatter:formatAction">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<!-- 按钮 -->
	<div id="toolbar">
		<!-- <a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-reload" plain="true" onclick="reload();">刷新</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="addflow();">新增</a> -->
	</div>
	<div id="dlg2" class="easyui-dialog"
		style="width: 400px; height: 400px; padding: 10px 20px" closed="true"
		>
		<form id="uploadForm" action=""
			method="post" enctype="multipart/form-data">
			<input name="id" id="ids" type="hidden">
			<input name="taskId" id="taskId" type="hidden">
			<div class="fitem">
					<label>请假天数:</label> <input name="days" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>请假原因:</label> <input name="content" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>请假备注:</label> 
					 <input name="remark" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>请假日期:</label> <input name="leaveDate" type="text" class="easyui-datebox" readonly="readonly"/>
				</div>
				<div class="fitem">
					<label>请假人:</label> <input name="name" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>批注:</label> <textarea id="message" rows=5 name="message"  class="textarea easyui-validatebox" ></textarea>
				</div>
				<div id="cc" style="width:200px;padding: 20px 80px;">
					
				</div>
		</form>
	</div>
	

	
</body>
</html>