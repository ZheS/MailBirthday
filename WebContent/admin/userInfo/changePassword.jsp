<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/template.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码修改</title>

<script type="text/javascript">
	function check() {
		var password = document.getElementById("password");
		var oldPassword = document.getElementById("oldPassword");
		var newPassword = document.getElementById("newPassword");
		var confirmNewPassword = document.getElementById("confirmNewPassword");

		if (oldPassword.value == "") {
			alert("输入密码为空！");
			return false;
		} else if (oldPassword.value != password.value) {
			alert("输入密码错误！");
			return false;
		} else if (newPassword.value == "" || confirmNewPassword.value == "") {
			alert("新密码不能为空！");
			return false;
		} else if (newPassword.value != confirmNewPassword.value) {
			alert("新输入的密码不一致！");
			return false;
		} else {
			return true;
		}
	}

	function sub(actionName) {
		if (check()) {
			var form = document.getElementById("changePasswordExcute");
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
			<h3 style="text-align: center;">密码修改</h3>
			<s:form theme="simple" id="changePasswordExcute">
				<s:hidden id="password" value="%{loginUser.userPWD}" />
				<table width="30%" border="0" align="center"
					cellpadding="2" cellspacing="0" class="table_main">
					<tr>
						<td class="table_td" style="text-align: right;">请输入旧密码：</td>
						<td class="table_td" style="text-align: left;"><s:password
								id="oldPassword" name="oldPassword" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">请输入新密码：</td>
						<td class="table_td" style="text-align: left;"><s:password
								id="newPassword" name="newPassword" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">请重新输入新密码：</td>
						<td class="table_td" style="text-align: left;"><s:password
								id="confirmNewPassword" name="confirmNewPassword" /></td>
					</tr>
					<tr>
						<td class="table_td" colspan="2" align="center"><input
							type="button" value="确认更改" onclick="sub('changePasswordExcute')" />
							<s:reset value="重置" /></td>
					</tr>
				</table>
			</s:form>
		</div>
		<jsp:include page="../../footer.jsp"></jsp:include>
	</div>
</body>
</html>