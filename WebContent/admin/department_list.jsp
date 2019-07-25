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
					      <th>院系名称</th>
					      <th>操作</th>
					    </tr> 
					  </thead>
					  <tbody>
					  <c:forEach items="${department}" var="dep">
					    <tr>
					     <td><b>${dep.department_name}</b></td>
					     <td>
 <a href="${ctx}/admin/department?act=edit" class="btn btn-success"><i class="fa fa-plus"></i> <b>添加系部</b></a>
<a href="${ctx}/admin/department?act=edit&id=${dep.departmentID}" class="btn btn-info "><i class="fa fa-edit"></i> <b>修改</b></a>
<a href="${ctx}/admin/department?act=delete&id=${dep.departmentID}" class="btn btn-danger " onclick="return confirm('是否确认要删除？');"><i class="fa fa-remove"></i> <b>删除</b></a>
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

    
   