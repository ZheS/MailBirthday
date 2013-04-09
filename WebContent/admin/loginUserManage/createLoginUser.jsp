<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/template.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加后台账户</title>

<script type="text/javascript">
	function check() {
		var password = document.getElementById("password");
		var confirmPassword = document.getElementById("confirmPassword");
		if (password.value == "") {
			alert("输入密码为空！");
			return false;
		} else if (password.value != confirmPassword.value) {
			alert("新输入的密码不一致！");
			return false;
		} else {
			return true;
		}
	}

	function sub(actionName) {
		if (check()) {
			var form = document.getElementById("createLoginUserExcute");
			form.action = actionName + ".action";
			form.submit();
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<div id="container" class="div_main">
		<jsp:include page="../../header.jsp"></jsp:include>
		<jsp:include page="../template/sidebar.jsp"></jsp:include>
		<div id="content">
			<h3 style="text-align: center;">添加后台账户</h3>
			<s:form theme="simple" id="createLoginUserExcute">
				<table width="30%" border="0" align="center" cellpadding="2"
					cellspacing="0" class="table_main">
					<tr>
						<td class="table_td" style="text-align: right;" width="35%">账号：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								id="userID" name="loginUser.userID" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">密码：</td>
						<td class="table_td" style="text-align: left;"><s:password
								id="password" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">确认密码：</td>
						<td class="table_td" style="text-align: left;"><s:password
								id="confirmPassword" name="loginUser.userPWD" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">姓名：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								id="name" name="loginUser.name" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">所属企业：</td>
						<td class="table_td" style="text-align: left;"><s:select
								name="loginUser.corporation" value="#{loginUser.corporation}"
								list="corporations" listKey="name" listValue="name" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">所属部门：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="loginUser.department" value="%{loginUser.department}" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">职位：</td>
						<td class="table_td" style="text-align: left;"><s:select
								name="loginUser.position" value="#{loginUser.position}"
								list="positions" listKey="name" listValue="name" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">手机号：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="loginUser.mobilePhone" value="%{loginUser.mobilePhone}" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">电话：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="loginUser.telephone" value="%{loginUser.telephone}" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">电子邮箱：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="loginUser.email" value="%{loginUser.email}" /></td>
					</tr>
					<tr>
						<td class="table_td" colspan="2" align="center" class="table_td"><input
							type="button" value="添加" onclick="sub('createLoginUserExcute')"><input
							type="button" value="返回"
							onclick="window.location.href='index.action'"></td>
					</tr>
				</table>
			</s:form>
		</div>
		<jsp:include page="../../footer.jsp"></jsp:include>
	</div>
</body>
</html>