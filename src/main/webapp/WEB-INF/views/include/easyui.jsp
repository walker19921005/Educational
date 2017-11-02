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

<%-- 
<!-- Mainly scripts -->
<script
	src="/static/js/jquery-3.1.1.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="${pageContext.request.contextPath}/static/js/inspinia.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/plugins/pace/pace.min.js"></script>
 --%>
 <script src="/static/js/bootstrap.js"></script>
<link
	href="${pageContext.request.contextPath}/static/bootstrap-file/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/bootstrap-select/bootstrap-select.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/bootstrap-file/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/prettify.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/css/animate.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/style.css"
	rel="stylesheet">

	<script src="${pageContext.request.contextPath}/static/bootstrap/js/jquery-1.10.2.min.js"></script>
	<!-- <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script> -->
	<script src="${pageContext.request.contextPath}/static/bootstrap-file/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap-select/bootstrap-select.min.js"></script>
 <style type="text/css">
html, body {
	height: 100%;
}

body {
	padding-top: 90px;
}

.wrap {
	min-height: 100%;
	height: auto;
	/* Negative indent footer by its height */
	margin: 0 auto -60px;
	/* Pad bottom by footer height */
	padding: 0 0 60px;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 45px auto;
}

.leaveform {
	max-width: 460px;
	padding: 15px;
	margin: 45px auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

#footer {
	height: 60px;
	background-color: #f5f5f5;
}

.container .text-muted {
	margin: 20px 0;
}

table tr, th {
	text-align: center;
}
</style>
  

