<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="../include/easyui.jsp"%>
<script src="${path}/js/assets/user_list_tree.js" type="text/javascript" ></script>
</head>
<body class="easyui-layout" fit="true">
		<!-- 左半部-流程类型 -->
		<div id="div_flowTree" region="west" iconCls="icon-chart_organisation" split="true" title="流程类型" 
				style="width:200px;padding: 2px" collapsible="false"> 
			<ul id="flowTree"></ul>  
		</div>  
		staffTab
		<!-- 右半部-流程列表-->
		<!-- <div id="div_flowGird" region="center" iconCls="icon-users" style="overflow: hidden">  -->
			<!-- 按钮 -->
			<!-- <div id="toolbar">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-reload" plain="true" onclick="reload();">刷新</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="addUser();">新增</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editUser();">编辑</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true" onclick="deleteUser();">删除</a>
				<span>用户名:</span><input name="search_username" id="search_username" value="" size=10 /> 
	  			<a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton"
					iconCls="icon-jright" plain="true" onclick="searchUser();">更多查询</a>
			</div>
			员工列表
			<table id="flowGird" toolbar="#toolbar"></table>  --> 
		<!-- </div>   -->
		
		<%-- <%@include file="/WEB-INF/jsp/business/worktime.jsp" %> --%>
		<div region="center">  
            <div class="easyui-tabs" id="mainTabs" fit="true" border="false">  
            </div>
        </div>
</body>
<script type="text/javascript">
$(function() {
	//1.1 加载流程列表
	$('#flowTree').tree({  
		lines: true,  
		url: '${path}/workflow/dealt.action',  
		//parentField : 'pid',
		onClick: function(node) {  
			if (node.attributes.url) {
				var src = path + node.attributes.url;
				if (!$.startWith(node.attributes.url, '/')) {	
					src = node.attributes.url;
				}
				var tabs = $('#mainTabs');
				var opts = {
					title : node.text,
					closable : true,
					iconCls : node.iconCls,
					content : $.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:99%;height:99%;padding-left:2px;" frameBorder="0"></iframe>', src),
					border : false,
					fit : true
				};
				if (tabs.tabs('exists', opts.title)) {
					tabs.tabs('select', opts.title);
				} else {
					tabs.tabs('add', opts);
				}
			}  
		}  
	});
	
	
	
});	


</script>
</html>
