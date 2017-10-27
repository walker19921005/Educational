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

            <h1 class="logo-name">IN+</h1>

        </div>
        <h3>Welcome to IN+</h3>
        <p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
            <!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
        </p>
        <p>Login in. To see it in action.</p>
        <form class="m-t" role="form" action="index.jsp">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="Username" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

            <a href="#"><small>Forgot password?</small></a>
            <p class="text-muted text-center"><small>Do not have an account?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>
        </form>
        <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small> </p>
    </div>
</div>

<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.js" type="text/javascript"></script>

</body>
</html>
