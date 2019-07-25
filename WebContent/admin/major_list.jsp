<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-专业编辑</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<style type="text/css">
		.headshot{
			width:30px;
			height:30px;
		}
	</style>
</head>
<body>
	<%@ include file="/common/admin_header.jsp" %><!-- 引入头部 -->
		<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>				
					 <table class="layui-table" >
					  <colgroup>
					    <col width="150">
					    <col width="200">
					    <col>
					  </colgroup>
					  <thead>
					    <tr>
					      <th>专业名称</th>
					      <th>所属系部</th>
					      <th>操作</th>
					    </tr> 
					  </thead>
					  <tbody>
					  <c:forEach items="${list}" var="major">		
							<tr>
							<td>${major.major_name}</td>
							<td>${major.department.department_name}</td>
							<td>
					     <a href="${ctx}/admin/major?act=edit" class="btn btn-success"><i class="fa fa-plus"></i> 添加专业</a>
					     <a href="${ctx}/admin/major?act=edit&id=${major.maid}" class="btn btn-info "><i class="fa fa-edit"></i> 修改</a>
					     <a href="${ctx}/admin/major?act=delete&id=${major.maid}" class="btn btn-danger " onclick="return confirm('是否确认要删除？');"><i class="fa fa-remove"></i> 删除</a>
						</td>
					    </tr>
					    </c:forEach>
					  </tbody>
					</table>	
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
   
</body>
</html>