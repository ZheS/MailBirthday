<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/template.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发送信息查询</title>
</head>
<body>
	<div id="container" class="div_main">
		<jsp:include page="../../header.jsp"></jsp:include>
		<jsp:include page="../template/sidebar.jsp"></jsp:include>
		<div id="content">
			<h3 style="text-align: center;">今日生日员工</h3>
			<div>
			<div id="about" style="background-color: white; padding: 0px;"
				align="center">
				<table width="800px" border="0" align="center" cellpadding="2"
				cellspacing="1" class="table_main">
					<thead>
						<tr>
							<th class="table_line">姓名</th>
							<th class="table_line">邮箱</th>
							<th class="table_line">备注</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="sendMessages" status="status">
							<tr>
								<td class="table_td"><s:property value="employees[#status.index].name"></s:property>
								</td>
								<td class="table_td"><s:property value="employees[#status.index].email"></s:property>
								</td>
								<td class="table_td"><s:property value="sendMessages[#status.index].memo"></s:property>
								</td>
							</tr>
						</s:iterator>
					</tbody>
			</table>
			</div>
		</div>
		</div>
		<jsp:include page="../../footer.jsp"></jsp:include>
	</div>
</body>
</html>