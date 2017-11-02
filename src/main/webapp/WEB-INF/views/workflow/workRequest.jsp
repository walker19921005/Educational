<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include/easyui_core.jsp"%>
<title>我的请求</title>
<script type="text/javascript">
	/** tree
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
			url: path+'/worktime/audit.action',
			type:'post',
			dataType:'json',
			data:{
				taskId:row.id
			},
			success:function(data){
				//alert(data.obj.outcomeList);
				var list = data.obj.outcomeList;
				$("#uploadForm").form('load',data.obj);
				var obj="";
				for(var i=0;i<list.length;i++){
					obj+="<input type='button' onclick='endTask(this)' name='outcome' value="+list[i]+">";
				}
				$(obj).prependTo("#cc");
				//$("#cc").val();
				$("#dlg2").dialog('open').dialog('setTitle','加班详情');
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
		
	//alert();
		var taskId = $("#taskId").val();
		var outcome = $(obj).val();
		var ids = $("#ids").val();
		var message = $("#message").val();
		//alert(ids+"=="+taskId+"=="+outcome);
		$.ajax({
			url: path+'/worktime/end.action',
			type:'post',
			dataType:'json',
			data:{
				taskId:taskId,
				id:ids,
				outcome:outcome,
				comment:message
			},
			success:function(data){
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
			url="${path }/worktime/list.action"  toolbar="#toolbar" 
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
		style="width: 350px; height: 300px; padding: 10px 20px" closed="true"
		>
		<form id="uploadForm" action=""
			method="post" enctype="multipart/form-data">
			<input name="id" id="ids" type="hidden">
			<input name="taskId" id="taskId" type="hidden">
			<!-- <div class="fitem">
					<label>请假天数:</label> <input name="days" class="easyui-textbox" readonly="readonly">
				</div> -->
				<div class="fitem">
					<label>加班原因:</label> <input name="content" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>备注:</label> 
					 <input name="remark" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>开始时间:</label> <input name="beginTime" type="text" class="easyui-datetimebox" readonly="readonly"/>
				</div>
				<div class="fitem">
					<label>结束时间:</label> <input name="endTime" type="text" class="easyui-datetimebox" readonly="readonly"/>
				</div>
				<div class="fitem">
					<label>加班时长:</label> <input name="time" type="text" class="easyui-textbox" readonly="readonly"/>
				</div>
				<div class="fitem">
					<label>申请人:</label> <input name="name" class="easyui-textbox" readonly="readonly">
				</div>
				<div class="fitem">
					<label>批注:</label> <textarea id="message" rows=5 name="message"  class="textarea easyui-validatebox" ></textarea>
				</div>
				<div id="cc">
					
				</div>
		</form>
	</div>
	

	
</body>
</html>