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
		 <table class="layui-table" >
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>			
					<thead>
						<tr><th>体育课名称</th><th>操作</th></tr>
					</thead>
					
					<tbody>					
				<c:forEach items="${StudentUnion}" var="un">
					<tr>
					<td>${un.un_name}</td>
					<td>
					<a href="${ctx}/admin/studentUnion?act=edit" class="btn btn-success"><i class="fa fa-plus"></i> 添加体育选修课</a>
					<a href="${ctx}/admin/studentUnion?act=edit&id=${un.un_ID}" class="btn btn-info "><i class="fa fa-edit"></i> 修改</a>
					<a href="${ctx}/admin/studentUnion?act=delete&id=${un.un_ID}" class="btn btn-danger " onclick="return confirm('是否确认要删除？');"><i class="fa fa-remove"></i> 删除</a>
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
<script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#editor')
        editor.create();
    </script>