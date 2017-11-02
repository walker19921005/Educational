<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<%-- <%@page import="com.cjrj.model.User"%>

<%
	User user = (User)request.getSession().getAttribute("USER");
%> --%>

<script type="text/javascript">
	var path = "${path}";
</script>

<!-- 引用Jquery的Js文件 -->
<%-- <script src="${path}/assets/js/jquery/jquery-1.11.1.min.js" type="text/javascript" ></script> --%>
<script
	src="${pageContext.request.contextPath}/static/js/jquery/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script src="${path}/static/js/jquery/jquery.portal.js"
	type="text/javascript"></script>
<script src="${path}/static/js/jquery/jquery.cookie.js"
	type="text/javascript"></script>
<!-- highcharts JS -->
<script src="${path}/static/js/jquery/highcharts.js"
	type="text/javascript"></script>
<script src="${path}/static/js/jquery/exporting.js"
	type="text/javascript"></script>

<!-- 引用Easy UI 修订过的Js文件 -->
<script src="${path}/static/js/easyui/jquery.easyui.min.core.js"
	type="text/javascript"></script>
<!-- 引用EasyUI的国际化文件,让它显示中文 -->
<script src="${path}/static/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<!-- 引入easyui扩展 -->
<script src="${path}/static/js/easyui/extEasyUI.js"
	type="text/javascript"></script>
<!-- 扩展jQuery -->
<script src="${path}/static/js/easyui/extJquery.js"
	type="text/javascript"></script>
<!-- 引入自己的js -->
<script src="${path}/js/main.js" type="text/javascript"></script>
<script src="${path}/static/js/easyui/jeasyui.common.js"
	type="text/javascript"></script>
<SCRIPT src="${path}/js/index/Clock.js" type=text/javascript></SCRIPT>

<!-- 导入Easy UI的主题Css文件 -->
<link id="easyuiTheme"
	href="${path}/js/easyui/themes/default/easyui.core.css"
	rel="stylesheet" type="text/css" />

<!-- 导入Easy UI的图标Css文件 -->
<link href="${path}/static/js/easyui/themes/icon.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet" type="text/css"
	href="${path}/static/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${path}/static/css/portal.css">
<link rel="stylesheet" type="text/css"
	href="${path}/static/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${path}/static/css/skin.css">
<!-- 对话框的样式 -->
<link href="${path}/static/css/list.css" rel="stylesheet"
	type="text/css" />
