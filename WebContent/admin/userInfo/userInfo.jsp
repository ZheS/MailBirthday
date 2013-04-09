<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/template.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息修改</title>

<script type="text/javascript">
	function sub(actionName) {
		if (confirm("您确认要修改吗？")) {
			var form = document.getElementById("userInfoMod");
			form.action = actionName + ".action";
			form.submit();
		}
	}
</script>
</head>
<body>
	<div id="container" class="div_main">
		<jsp:include page="../../header.jsp"></jsp:include>
		<jsp:include page="../template/sidebar.jsp"></jsp:include>
		<div id="content">
			<h3 style="text-align: center;">个人信息修改</h3>
			<s:form theme="simple" id="userInfoMod">
				<s:hidden name="loginUser.id" />
				<table width="30%" border="0" align="center" cellpadding="2"
					cellspacing="0" class="table_main">
					<tr>
						<td width="40%" class="table_td" style="text-align: right;">账号：</td>
						<td class="table_td" style="text-align: left;"><s:property
								value="loginUser.userID" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">姓名：</td>
						<td class="table_td" style="text-align: left;"><s:property
								value="loginUser.name" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">创建时间：</td>
						<td class="table_td" style="text-align: left;"><s:date
								name="loginUser.createDate" format="yyyy-MM-dd HH:mm:ss"
								nice="false"></s:date></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">修改时间：</td>
						<td class="table_td" style="text-align: left;"><s:date
								name="loginUser.modifyDate" format="yyyy-MM-dd HH:mm:ss"
								nice="false"></s:date></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">所属企业：</td>
						<td class="table_td" style="text-align: left;"><s:select
								name="corporation" value="#{loginUser.corporation}"
								list="corporations" listKey="name" listValue="name" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">所属部门：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="department" value="%{loginUser.department}" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">职位：</td>
						<td class="table_td" style="text-align: left;"><s:select
								name="position" value="#{loginUser.position}" list="positions"
								listKey="name" listValue="name" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">手机号：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="mobilePhone" value="%{loginUser.mobilePhone}" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">电话：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="telephone" value="%{loginUser.telephone}" /></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">电子邮箱：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="email" value="%{loginUser.email}" /></td>
					</tr>
					<tr>
						<td class="table_td" colspan="8" align="center"><input
							type="button" value="修改信息" onclick="sub('userInfoMod')">
							<input type="button" value="返回"
							onclick="window.location.href='index.action'"></td>
					</tr>
				</table>
			</s:form>
		</div>
		<jsp:include page="../../footer.jsp"></jsp:include>
	</div>
</body>
</html>