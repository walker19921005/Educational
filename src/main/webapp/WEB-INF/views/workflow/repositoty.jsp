<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include/easyui_core.jsp"%>
<title>流程部署</title>
<script type="text/javascript">
	/**
	 *格式化操作，在每行的操作栏显示编辑和删除操作
	 */
	function formatAction(value, row, index) {
		var str = '';
		if (true) {
			//str += '<a href="javascript:onEdit()"><img src="../js/easyui/themes/icons/pencil.png" alt="编辑" title="编辑" /></a>';
			str += '<a href="javascript:delopen()">删除</a>';
		}
		str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
		if (true) {
			str += '<a href="javascript:getPicture()">查看流程图</a>';
		}
		return str;
	}
	//查看流程图
	function getPicture() {
		var row = $('#datagrid').datagrid('getSelected');
		//alert(row.diagramResourceName);h
		var url=path+"/workflow/getPicture.action?deploymentId="+row.id+"&imageName="+row.diagramResourceName;
		window.location.href=url;
		/* $("#dd").window({
			href:url,
			width:400,
			height:400,
			title:'流程图',
			type: 'POST',
			modal: true
		}); */
	}
	//刷新
	function reload() {
		$('#datagrid').datagrid('reload');
	}
	function addflow() {
		$("#dlg2").dialog('open').dialog('setTitle', '添加流程');

	}
	function uploadFile() {
		//alert($("#files").val()+"=="+$("#filename").val());
		$.ajax({
			type : 'post',
			dataType : 'json',
			data : {
				file : $("#files").val(),
				filename : $("#filename").val()
			},
			url : path + "/workflow/deployment.action",
			success : function(data) {
				if (data.obj != 0) {
					$.messager.alert('系统提示', '添加成功', 'info');
					$("#dlg2").dialog('close');
					$("#datagrid").datagrid("reload");
				} else {
					$.messager.alert('系统提示', '添加失败', 'info');
				}
			},
			error : function() {
				alert('error');
			}
		});

		
	}
	function delopen() {
		$("#dlg_delete").dialog('open').dialog('setTitle', '删除流程');
	}

	function del() {
		var row = $('#datagrid').datagrid('getSelected');
		//alert(row.id);
		$.ajax({
			url : path + "/workflow/delDeployment.action",
			type : 'post',
			dataType : 'json',
			data : {
				deploymentId : row.id
			},
			success : function(data) {
				if (data.obj != 0) {
					$.messager.alert('系统提示', '删除成功', 'info');
					$("#dlg_delete").dialog('close');
					$("#datagrid").datagrid("reload");
				} else {
					$.messager.alert('系统提示', '删除失败', 'info');
				}
			},
			error : function() {
				$.messager.alert('系统提示', '删除失败', 'info');
			}
		});
	}
</script>
</head>
<body class="easyui-layout" fit="true">
	<div id="dd"></div>  
	<div region="center" border="false" style="overflow: hidden;">
		<table id="datagrid" class="easyui-datagrid" fit="true"
			url="${path }/workflow/getInfo.action" toolbar="#toolbar"
			pagination="true" singleSelect="true" fitColumns="true"
			rownumbers="true" striped="true" border="false" nowrap="false">
			<thead>
				<tr>
					<th field="id" width="100">编号</th>
					<th field="name" width="100">流程名称</th>
					<th field="deploymentTime" width="100" class="easyui-datetimebox">创建时间</th>
					<th field="diagramResourceName" width="100">图片</th>

					<th data-options="field:'action',width:120,formatter:formatAction">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<!-- 按钮 -->
	<div id="toolbar">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-reload" plain="true" onclick="reload();">刷新</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="addflow();">新增</a>
	</div>

	<div id="dlg2" class="easyui-dialog"
		style="width: 400px; height: 180px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons2">
		<form id="uploadForm" action="${path}/workflow/deployment.action"
			method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>上传文件：</td>
					<td><input type="file" id="files" name="file" /></td>
				</tr>
				<tr>
					<td>流程名称：</td>
					<td><input id="filename" name="filename"
						class="easyui-validatebox" data-options="required:true" /></td>
				</tr>

			</table>
		</form>
	</div>
	<div id="dlg-buttons2">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="uploadFile()">上传</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg2').dialog('close')">关闭</a>
	</div>

	<!-- 删除对话框 -->
	<div id="dlg_delete" class="easyui-dialog"
		style="width: 300px; height: 200px; padding: 30px 20px" closed="true"
		buttons="#dlg-del-buttons">
		<div class="ftitle">请谨慎操作</div>
		<form id="fm" method="post" novalidate>
			<label>确定删除流程吗？</label>
		</form>
	</div>

	<!-- 删除对话框按钮 -->
	<div id="dlg-del-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="del()" style="width: 90px">删除</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlg_delete').dialog('close')"
			style="width: 90px">取消</a>
	</div>
</body>
</html>