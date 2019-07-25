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
				<thead><tr><th>班级名称</th><th>课程名称</th></tr></thead>
				<tbody>
				<c:forEach items="${course}" var="course">
				<tr>
				<td>${course.tb_class.class_name}</td>
				<td>${course.course.courseName}</td>		
				</tr>
				</c:forEach></tbody>
				<th>体育选修课</th>
				<c:forEach items="${finBysportsCourse}" var="finBysportsCourse">
				<td>${finBysportsCourse.studentUnion.un_name}</td>
				</c:forEach>
				</tbody>
				</table>
</body>
</html>

    
   