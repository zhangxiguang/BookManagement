<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>图书管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes"/>
	<meta name="full-screen" content="yes">
	<meta name="browsermode" content="application">
	<meta name="x5-fullscreen" content="true">
	<meta name="x5-page-mode" content="app">

	<script src="js/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="css/auth.css">
	<%--<script src="js/auth.js"></script>--%>
	<link rel="stylesheet" href="css/layui.css"  media="all">
	<script src="js/layui.js" charset="utf-8"></script>
</head>



<body>
	<div class="lowin">
		<div class="lowin-brand">
			<img src="img/kodinger.jpg" alt="logo">
		</div>
		<div class="lowin-wrapper">
			<div class="lowin-box lowin-login">
				<div class="lowin-box-inner">
					<form action="/userServlet?method=login" method="post">
						<p>管理员账户登录</p>
						<div class="lowin-group">
							<label>账户 <a href="#" class="login-back-link">还未注册?</a></label>
							<input type="text" autocomplete="email" name="username" class="lowin-input">
						</div>
						<div class="lowin-group password-group">
							<label>密码 <a href="#" class="forgot-link">忘记密码?</a></label>
							<input type="password" name="password" autocomplete="current-password" class="lowin-input">
						</div>
						<button id="loginButton" class="lowin-btn login-btn">
							登录
						</button>

						<div class="text-foot"  id="erorrMessage"  >
							<span  style="color: red;font-size: 14px;display: none;">密码或账户错误，请重试!</span>
						</div>
					</form>
				</div>
			</div>

			<%--<div class="lowin-box lowin-register">--%>
				<%--<div class="lowin-box-inner">--%>
					<%--<form>--%>
						<%--<p>Let's create your account</p>--%>
						<%--<div class="lowin-group">--%>
							<%--<label>Name</label>--%>
							<%--<input type="text" name="name" autocomplete="name" class="lowin-input">--%>
						<%--</div>--%>
						<%--<div class="lowin-group">--%>
							<%--<label>Email</label>--%>
							<%--<input type="email" autocomplete="email" name="email" class="lowin-input">--%>
						<%--</div>--%>
						<%--<div class="lowin-group">--%>
							<%--<label>Password</label>--%>
							<%--<input type="password" name="password" autocomplete="current-password" class="lowin-input">--%>
						<%--</div>--%>
						<%--<button class="lowin-btn">--%>
							<%--Sign Up--%>
						<%--</button>--%>

						<%--<div class="text-foot">--%>
							<%--Already have an account? <a href="" class="login-link">Login</a>--%>
						<%--</div>--%>
					<%--</form>--%>
				<%--</div>--%>
			<%--</div>--%>
		</div>
	

	</div>


	<c:choose>
		<c:when test="${sessionScope.errorLogin==null}">
			<script>
                // alert("1")
                // $("#erorrMessage").hide()
			</script>
		</c:when>
		<c:when test="${sessionScope.errorLogin!=null}">
			<script>
                alert("密码或账户错误，请重试!")
                // $("#erorrMessage").show()
                // alert("2")
			</script>
		</c:when>
	</c:choose>


</body>
</html>