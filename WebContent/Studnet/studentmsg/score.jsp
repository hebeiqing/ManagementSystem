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
				<thead><tr><th>课程名称</th><th>成绩</th></tr></thead>
				<thead>
				<tbody>
				<c:forEach items="${score}" var="score">
				<tr>
				<td>${score.course.courseName }</td>
				<td>${score.score }</td>
				</tr>
				</c:forEach>
				</tbody>
				
				</table>
</body>
</html>

    
   