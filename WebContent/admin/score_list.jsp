<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-学生成绩编辑</title>
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
						<tr><th>学生姓名</th><th>课程名称</th><th>成绩</th><th>操作</th></tr>
					</thead>
					<tbody>
					<c:forEach items="${score}" var="score">
						<tr>
						<td>${score.student.stuName}</td>
						<td>${score.course.courseName }</td>
						<td>${score.score }</td>
							<td>
							<a href="${ctx}/admin/score_edit.jsp" class="btn btn-success"><i class="fa fa-plus"></i> 录入课程成绩</a>
							<a href="${ctx}/admin/score?act=edit&id=${score.stuId}" class="btn btn-info "><i class="fa fa-edit"></i> 修改</a>
							<a href="${ctx}/admin/score?act=delect&id=${score.scoreID}" class="btn btn-danger " onclick="return confirm('是否确认要删除？');"><i class="fa fa-remove"></i> 删除</a>
							</td>
						</tr>
					</tbody>
				</c:forEach>		
				</table>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
   
</body>
</html>