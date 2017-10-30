<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: excalibur
  Date: 2017/10/27
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INSPINIA | Register</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
</head>
<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">CJ</h1>

        </div>
        <h3>Register to IN+</h3>
        <form class="m-t" role="form" action="/register.do" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="请输入用户名" name="username" required="">
            </div>
            <div class="form-group">
                <input type="email" class="form-control" placeholder="请输入Email" name="email" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="请输入密码" name="password" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="请再次输入密码" name="repassword" required="">
            </div>
            <c:if test="${!empty dept}">
            <div class="form-group">
                <select class="select2-results__group form-control" name="deptid" placeholder="请选择部门" required="">
                    <c:forEach items="${dept}" var="dept">
                        <option class="" value="${dept.deptId}">${dept.deptName}</option>
                    </c:forEach>
                </select>
            </div>
            </c:if>
            <button type="submit" class="btn btn-primary block full-width m-b">立即注册</button>

            <p class="text-muted text-center"><small>点此登录</small></p>
            <a class="btn btn-sm btn-white btn-block" href="/">Login</a>
        </form>
    </div>
</div>

<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/static/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function(){
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green'
        });
    });
</script>
</body>
</html>
