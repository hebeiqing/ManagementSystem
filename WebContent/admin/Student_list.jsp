<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-学生编辑</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/admin_header.jsp" %><!-- 引入头部 -->
	
				  <table class="layui-table" >
<thead>
<tr><th>姓名</th><th>密码</th><th>性别</th><th>出生日期</th><th>籍贯</th><th>入学时间</th><th>政治面貌</th><th>家庭地址</th><th>电话</th><th>身份证</th><th>民族</th><th>所在部门</th><th>所在专业</th><th>所在班级</th><th>操作</th></tr>
					</thead>
					<tbody>
					<c:forEach items="${student}" var="student">
					<tr>					
					<td>${student.stuName}</td>
					<td>${student.password}</td>
					<td>${student.sex}</td>
					<td>${student.birthDate}</td>
					<td>${student.natives}</td>
					<td>${student.entranceTime}</td>
					<td>${student.politicalFace}</td>
					<td>${student.address}</td>
					<td>${student.perPhone}</td>
					<td>${student.IDNum}</td>
					<td>${student.national}</td>
					<td>${student.department.department_name}</td>
					<td>${student.major.major_name}</td>					
					<td>${student.tb_class.class_name}</td>
					<td>
					<a href="${ctx}/admin/Student_edit.jsp" class="btn btn-success"><i class="fa fa-plus"></i> 添加学生</a>
					<a href="${ctx}/admin/student?act=edit&id=${student.stuId}" class="btn btn-info "><i class="fa fa-edit"></i> 修改</a>
					<a href="${ctx}/admin/student?act=delete&id=${student.stuId}" class="btn btn-danger " onclick="return confirm('是否确认要删除？');"><i class="fa fa-remove"></i> 删除</a>
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