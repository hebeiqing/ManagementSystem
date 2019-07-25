<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-作者编辑</title>
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
					<thead>
						<tr><th>课程名称</th><th>学分</th><th>专业名称</th><th>操作</th></tr>
					</thead>
					<tbody>
					<c:forEach items="${course}" var="course">
					<tr>
						<th>${course.courseName}</th>
						<th>${course.creDits}</th>
						<th>${course.major_name}</th>
						<td>
						<a href="${ctx}/admin/course?act=edit" class="btn btn-success"><i class="fa fa-plus"></i> 添加课程</a>
						<a href="${ctx}/admin/course?act=edit&id=${course.courseID}" class="btn btn-info "><i class="fa fa-edit"></i> 修改</a>
						<a href="${ctx}/admin/course?act=delect&id=${course.courseID}" class="btn btn-danger " onclick="return confirm('是否确认要删除？');"><i class="fa fa-remove"></i> 删除</a>
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