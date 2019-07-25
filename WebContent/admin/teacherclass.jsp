<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-类别编辑</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/admin_header.jsp" %><!-- 引入头部 -->
				 <table class="layui-table" >
					<thead>
						<tr><th>班级名称</th><th>教师姓名</th><th>课程名称</th><th>操作</th></tr>
					</thead>
					<tbody>
					<c:forEach items="${teacherclass}" var="teacherclass">
					<tr>
					<td>${teacherclass.classa.class_name}</td> 
					<td>${teacherclass.teacher.teacherName}</td> 
					<td>${teacherclass.course.courseName}</td> 
					 <td>
					 	<a href="${ctx}/admin/tealass?act=edit" class="btn btn-success"><i class="fa fa-plus"></i> 添加教师课程</a>
						<a href="${ctx}/admin/tealass?act=edit&id=${teacherclass.tealass_ID}" class="btn btn-info "><i class="fa fa-edit"></i> 修改</a>
						<a href="${ctx}/admin/tealass?act=delect&id=${teacherclass.tealass_ID}" class="btn btn-danger " onclick="return confirm('是否确认要删除？');"><i class="fa fa-remove"></i> 删除</a>
					</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#editor')
        editor.create();
    </script>
</body>
</html>