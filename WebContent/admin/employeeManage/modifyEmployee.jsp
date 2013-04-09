<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/template.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑部门</title>

<script type="text/javascript">
	function sub(actionName) {
		if (confirm("您确认要修改吗？")) {
			var form = document.getElementById("modifyDepartmentExcute");
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
			<h3 style="text-align: center;">编辑部门</h3>
			<s:form theme="simple" id="modifyDepartmentExcute">
				<s:hidden name="id" value="%{department.id}" />
				<table width="30%" border="0" align="center" cellpadding="2"
					cellspacing="0" class="table_main">
					<tr>
						<td class="table_td" style="text-align: right;">创建时间：</td>
						<td class="table_td" style="text-align: left;"><s:date
								name="department.createDate" format="yyyy-MM-dd HH:mm:ss"
								nice="false"></s:date></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;">修改时间：</td>
						<td class="table_td" style="text-align: left;"><s:date
								name="department.modifyDate" format="yyyy-MM-dd HH:mm:ss"
								nice="false"></s:date></td>
					</tr>
					<tr>
						<td class="table_td" style="text-align: right;" width="35%">部门名称：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="name" value="%{department.name}" /></td>
					</tr>
					<tr>
						<td class="table_td" colspan="8" align="center"><input
							type="button" value="修改信息"
							onclick="sub('modifyDepartmentExcute')"><input
							type="button" value="返回"
							onclick="window.location.href='viewDepartment.action'"></td>
					</tr>
				</table>
			</s:form>
		</div>
		<jsp:include page="../../footer.jsp"></jsp:include>
	</div>
</body>
</html>