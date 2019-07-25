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
			
			   <form action="${ctx}/ChangePoints" method="post" >	
			   	<c:if test="${not empty error}">
				<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				   <table class="layui-table" >
				<thead><th>班级名称</th><th>课程名称</th><th>学生姓名</th></thead>
				<tbody>
				<c:forEach items="${TeacherStudent}" var="TeacherStudent">
				<tr>
				<td>${TeacherStudent.class1.class_name}</td>
				<td>${TeacherStudent.course.courseName}</td>
				<td>${TeacherStudent.student.stuName}</td>
				</tr>
				</c:forEach>	
				</tbody>	
			   </table>
			 </form>
			
		
   
</body>
</html>

    
   