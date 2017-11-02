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
			str += '<a id="a" href="javascript:delopen()">审核详情</a>';
		}
		str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
		if (true) {
			str += '<a id="b" href="javascript:request()">提出申请</a>';
		}
		return str;
	}
	//启动流程
	function request(){
		
		var row = $('#datagrid').datagrid('getSelected');
		//alert(row.id);
		window.location.href=path+"/worktime/start.action?id="+row.id;
		/* $("#b").hide();
		$("#a").show(); */
	}

	//刷新
	function reload() {
		$('#datagrid').datagrid('reload');
	}
	function addflow() {
		$("#dlg").dialog('open').dialog('setTitle', '添加加班');

	}
	
	function addworktime(){
		var param = $("#fm").serialize();
		//alert(path+'/leaveBill/addLeaveBill.action?'+param);
		var url = path+'/worktime/addworktime.action';
		$.ajax({
			type:'post',
			dataType:'json',
			url:url,
			data:param,
			success:function(data){
				if(data.obj!=0){
					$.messager.show({
						title:'系统提示',
						msg:'添加成功'
					});
					$("#dlg").dialog('close');
					$("#datagrid").datagrid("reload");
				}else{
					$.messager.show({
						title:'系统提示',
						msg:'添加失败'
					});
					$("#dlg").dialog('close');
				}
			},
			error:function(){
				alert('error');
			}
		});
		/* $.post(url,'',function(data){
			if(data.obj!=0){
				$.messager.show({
					title:'系统提示',
					msg:'添加成功'
				});
				$("#dlg").dialog('close');
				$("#datagrid").datagrid("reload");
			}else{
				$.messager.show({
					title:'系统提示',
					msg:'添加失败'
				});
				$("#dlg").dialog('close');
			}
		}); */
		
	}
	function delopen() {
		
		var row = $('#datagrid').datagrid('getSelected');
		
		$("#rids").val(row.id);
		var url = "${path}/worktime/comment.action?id="+row.id ;
		// window.open(url,'','width=800,height=600');
		
		$("#cc")
				.dialog(
						{
							title : '审核详情',
							width : 450,
							height : 500,
							closed : false,
							cache : false,
							buttons : '#dlg-del-buttons',
							content : $
									.formatString(
											'<iframe name="roleiframe" id="roleiframe" src="{0}" allowTransparency="true" style="border:0;width:99%;height:99%;padding-left:2px;" frameBorder="0"></iframe>',
											url), 
							modal : false
						});
		$("#dlg_delete").dialog('open').dialog('setTitle', '审核详情');
	}

	function del() {
		var row = $('#datagrid').datagrid('getSelected');
		//alert(row.id);
		$.ajax({
			url : path + "/leaveBill/delLeaveBill.action",
			type : 'post',
			dataType : 'json',
			data : {
				id : row.id
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
	<div region="center" border="false" style="overflow: hidden;">
		<table id="datagrid" class="easyui-datagrid" fit="true"
			url=" ${path }/worktime/getInfo.action " toolbar="#toolbar"
			pagination="true" singleSelect="true" fitColumns="true"
			rownumbers="true" striped="true" border="false" nowrap="false">
			<thead>
				<tr>
					<th field="id" width="100">编号</th>
					<th field="name" width="100">申请人</th>
					<!-- <th field="days" width="100">请假天数</th> -->
					<th field="content" width="100">加班原因</th>
					<th field="remark" width="100">备注</th>
					<th field="beginTime" width="100">开始时间</th>
					<th field="endTime" width="100">结束时间</th>
					<th field="statu" width="100">审核状态</th>
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
	<!-- 添加/修改对话框 -->
		<div id="dlg" class="easyui-dialog"
			style="width:400px;height:300px;padding:30px 20px" closed="true"
			buttons="#dlg-buttons">
			<form id="fm" method="post" novalidate>
				<!-- <div class="fitem">
					<input name="id"  type="hidden">
				</div> -->
				<!-- <div class="fitem">
					<label>加班原因:</label> <input name="days" class="easyui-textbox" >
				</div> -->
				<div class="fitem">
					<label>加班原因:</label> <input name="content" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>备注:</label> 
					 <input name="remark" class="easyui-textbox" >
				</div>
				<div class="fitem">
					<label>开始时间:</label> <input name="beginTime" type="text" class="easyui-datetimebox" />
				</div>
				<div class="fitem">
					<label>结束时间:</label> <input name="endTime" type="text" class="easyui-datetimebox" />
				</div>
				<div class="fitem">
					<label>加班时长:</label> <input name="time" type="text" class="easyui-textbox"  />
				</div>
				<!-- <div class="fitem">
					<label>请假人:</label> <input name="name" class="easyui-textbox" >
				</div> -->
				
				
			</form>
		</div>
		
		<!-- 添加/修改对话框按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="addworktime()" style="width:90px">保存</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a>
		</div>

	<!-- 删除对话框 -->
	<!-- <div id="dlg_delete" class="easyui-dialog"
		style="width: 300px; height: 200px; padding: 30px 20px" closed="true"
		buttons="#dlg-del-buttons">
		<div class="ftitle">请谨慎操作</div>
		<form id="fm" method="post" novalidate>
			<label>确定删除流程吗？</label>
		</form>
		
		
	</div> -->
	<div id="cc"></div>

	<!-- 删除对话框按钮 -->
	<div id="dlg-del-buttons" style="display: none">
		<!-- <a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="del()" style="width: 90px">删除</a>  --><a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#cc').dialog('close')"
			style="width: 90px">取消</a>
	</div>
</body>
</html>