<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/template.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有部门</title>
<script type="text/javascript" src="../css/jquery-1.7.2.js"></script>

<script type="text/javascript">
	function delete_confirm(sender) {
		if (confirm('是否删除该项？')) {
			window.location.href = sender;
		}
	}
</script>
</head>
<body>
	<script type="text/javascript" src="departmentManage/viewDepartment.js"></script>
	<div id="container" class="div_main">
		<jsp:include page="../../header.jsp"></jsp:include>
		<jsp:include page="../template/sidebar.jsp"></jsp:include>
		<div id="content">
			<h3 style="text-align: center;">查看所有部门</h3>
			<table width="800px" border="0" align="center" cellpadding="2"
				cellspacing="1" class="table_main">
				<s:if test="departments.size > 0">
					<thead>
						<tr>
							<th class="table_line">企业名称</th>
							<th class="table_line">创建时间</th>
							<th class="table_line">操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="departments" status="status">
							<tr>
								<td class="table_td"><s:property value="name"></s:property>
								</td>
								<td class="table_td"><s:date name="createDate"
										format="yyyy-MM-dd HH:mm:ss" nice="false"></s:date></td>
								<td class="table_td"><input type="button" value="编辑"
									onclick="window.location.href = 'modifyDepartment.action?id=<s:property value="id" />'" />
									<input type="button" value="删除"
									onclick="delete_confirm('deleteDepartment.action?id=<s:property value="id" />')" /></td>
							</tr>
						</s:iterator>
					</tbody>
					<s:if test="count>10">
						<tr>
							<td class="table_td" colspan="3">
								<div style="font-size: 13px;">
									第 <span id="page">${page}</span>页，共 <span id="totalPage">${totalPage}</span>页
									<a id="pre" href="viewDepartment.action?page=${page-1}">上一页</a>
									， <a id="next" href="viewDepartment.action?page=${page+1}">下一页</a>
									转到：第 <input type=text id="pageNo" size=1 value="${page}">
									页 <input type=button id="go" value=GO
										onclick="gotoPage(${totalPage})">
								</div>
							</td>
						</tr>
					</s:if>
				</s:if>
				<s:else>
					 没有找到相关结果
				</s:else>
			</table>
		</div>
		<jsp:include page="../../footer.jsp"></jsp:include>
	</div>
</body>
</html>