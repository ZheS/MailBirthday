<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/MailBirthday/skin/blue/css.css">
<link rel="stylesheet" type="text/css"
	href="/MailBirthday/css/template.css">
<script type="text/javascript">
	function chs() {
		var obj1 = document.getElementById("menu1");
		var li1 = obj1.getElementsByTagName("a");
		if (li1.length == 0) {
			document.getElementById("menuBox1").style.display = "none";
		}
		var obj2 = document.getElementById("menu2");
		var li2 = obj2.getElementsByTagName("a");
		if (li2.length == 0) {
			document.getElementById("menuBox2").style.display = "none";
		}

		var obj3 = document.getElementById("menu3");
		var li3 = obj3.getElementsByTagName("a");
		if (li3.length == 0) {
			document.getElementById("menuBox3").style.display = "none";
		}

		var obj4 = document.getElementById("menu4");
		var li4 = obj4.getElementsByTagName("a");
		if (li4.length == 0) {
			document.getElementById("menuBox4").style.display = "none";
		}

		var obj5 = document.getElementById("menu5");
		var li5 = obj5.getElementsByTagName("a");
		if (li5.length == 0) {
			document.getElementById("menuBox5").style.display = "none";
		}
	}
	function hideOrShow(divId) {
		div = document.getElementById(divId);
		if (div.style.display == "") {
			div.style.display = "none";
		} else {
			div.style.display = "";
		}
	}
</script>
</head>
<body onload="chs()">
	<div id="sidebar">
		<table border="0" cellpadding="0" cellspacing="0" align="center"
			width="170px" style="border: 2px #E2E2E2 solid; margin: 5px 0px;">
			<tr>
				<td class="nav_f" onclick="hideOrShow('menu1')"
					style="cursor: pointer">首页</td>
			</tr>
			<tr>
				<td>
					<div id="menu1">
						<table border="0" cellpadding="0" cellspacing="0" align="center"
							width="96%">
							<tr>
								<td class="nav_s"><a
									href="/MailBirthday/admin/sendMessage.action">首页</a></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		
		<table border="0" cellpadding="0" cellspacing="0" align="center"
			width="170px" style="border: 2px #E2E2E2 solid; margin: 5px 0px;">
			<tr>
				<td class="nav_f" onclick="hideOrShow('menu2')"
					style="cursor: pointer">个人信息</td>
			</tr>
			<tr>
				<td>
					<div id="menu2">
						<table border="0" cellpadding="0" cellspacing="0" align="center"
							width="96%">
							<tr>
								<td class="nav_s"><a
									href="/MailBirthday/admin/userInfo.action">个人信息修改</a></td>
							</tr>
							<tr>
								<td class="nav_s"><a
									href="/MailBirthday/admin/changePassword.action">密码修改</a></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>

		<table border="0" cellpadding="0" cellspacing="0" align="center"
			width="170px" style="border: 2px #E2E2E2 solid; margin: 5px 0px;">
			<tr>
				<td class="nav_f" onclick="hideOrShow('menu3')"
					style="cursor: pointer">人员管理</td>
			</tr>
			<tr>
				<td>
					<div id="menu3">
						<table border="0" cellpadding="0" cellspacing="0" align="center"
							width="96%">
							<tr>
								<td class="nav_s"><a
									href="/MailBirthday/admin/createDepartment.action">添加人员信息</a></td>
							</tr>
							<tr>
								<td class="nav_s"><a
									href="/MailBirthday/admin/viewDepartment.action">维护人员信息</a></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>

		<table border="0" cellpadding="0" cellspacing="0" align="center"
			width="170px" style="border: 2px #E2E2E2 solid; margin: 5px 0px;">
			<tr>
				<td class="nav_f" onclick="hideOrShow('menu4')"
					style="cursor: pointer">退出系统</td>
			</tr>
			<tr>
				<td>
					<div id="menu4">
						<table border="0" cellpadding="0" cellspacing="0" align="center"
							width="96%">
							<tr>
								<td class="nav_s"><a
									href="/MailBirthday/j_spring_security_logout">退出</a></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>