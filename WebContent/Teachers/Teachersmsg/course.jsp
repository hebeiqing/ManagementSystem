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
			<thead><th>班级名称</th><th>课程名称</th></thead>
			<tbody>
			<c:forEach items="${Teachercourse}" var="Teachercourse">
			<tr>
			<td>${Teachercourse.class1.class_name}</td>
			<td>${Teachercourse.course.courseName}</td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			  </div>
			</div></table>
		
   
</body>
</html>

    
   