<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="css/jquery-1.7.2.js"></script>
<style>
body {
	background: url(images/login-bg21.jpg) repeat-x;
	background-color: #cfcfcf;
}
</style>
</head>

<body>
	<div class="login_bg">
		<div class="center">
			<div class="logo"></div>
			<div class="login">
				<table>
					<tr style="height: 70px;">
						<td></td>
					</tr>
					<tr><td style="width: 140px;"></td>
						<td style="color: red;">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</td>
					</tr>
				</table>
				<form
					action="${pageContext.request.contextPath}/j_spring_security_check"
					method="post">
					<input type="text" name="j_username" class="input_name" /><br />
					<input type="password" name="j_password" class="input_pass" /><br />
					<input name="" type="submit" value="" class="conform" /> <input
						name="" type="reset" value="" class="reset" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>