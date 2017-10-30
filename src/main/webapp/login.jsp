<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INSPINIA | Login</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/animate.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
</head>
<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">CJ</h1>

        </div>
        <h3>Welcome to EducationalOA</h3>
        <br>
        <form class="m-t" role="form" action="/login.do" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Username" name="Username" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" name="Password" required="">
            </div>
            <c:if test="${!empty message}">
            <div class="form-group">
                <br>
                <div class="col-sm-10">
                    <div class="alert alert-danger">${message}</div>
                </div>
            </div>
            </c:if>
            <button type="submit" class="btn btn-primary block full-width m-b">登录</button>

            <a href="#"><small>忘记密码?</small></a>
            <a class="btn btn-sm btn-white btn-block" href="/register.do">创建新用户</a>
        </form>
    </div>
</div>

<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.js" type="text/javascript"></script>

</body>
</html>
