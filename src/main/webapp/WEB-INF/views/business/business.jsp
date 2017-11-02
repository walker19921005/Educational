<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="../include/easyui_core.jsp"%>
<script src="${path}/static/js/assets/user_list_tree.js" type="text/javascript" ></script>
</head>
<body class="easyui-layout" fit="true">
		<!-- 左半部-流程类型 -->
		<div id="div_flowTree" region="west" iconCls="icon-chart_organisation" split="true" title="流程类型" 
				style="width:200px;padding: 2px" collapsible="false"> 
			<ul id="flowTree"></ul>  
		</div>  
		staffTab
 
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
		url: '${path}/workflow/flowlist.action',  
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
