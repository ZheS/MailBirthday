<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/template.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加下属企业</title>
</head>
<body>
	<div id="container" class="div_main">
		<jsp:include page="../../header.jsp"></jsp:include>
		<jsp:include page="../template/sidebar.jsp"></jsp:include>
		<div id="content">
			<h3 style="text-align: center;">添加下属企业</h3>
			<s:form theme="simple" action="createCorporationExcute">
				<table width="30%" border="0" align="center" cellpadding="2"
					cellspacing="0" class="table_main">
					<tr>
						<td class="table_td" style="text-align: right;" width="35%">企业名称：</td>
						<td class="table_td" style="text-align: left;"><s:textfield
								name="corporation.name" /></td>
					</tr>
					<tr>
						<td class="table_td" colspan="2" align="center" class="table_td"><s:submit
								value="添加" /><input type="button" value="返回"
							onclick="window.location.href='index.action'"></td>
					</tr>
				</table>
			</s:form>
		</div>
		<jsp:include page="../../footer.jsp"></jsp:include>
	</div>
</body>
</html>