<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-教师编辑</title>
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
				
		         <div class="panel-heading">教師資料</div>
		          <table class="layui-table" >
					<thead>
						<tr>
							<th>姓名</th>
							<th>性别</th>
							<th>密码</th>
							<th>出生日期</th>
							<th>政治面貌</th>
							<th>籍贯</th>
							<th>电话</th>
							<th>身份证</th>
							<th>入校时间</th>
							<th>最高学历</th>
							<th>职务</th>
							<th>照片</th>
							<th>民族</th>
							<th>所在部門</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${Teacher}" var="teacher">
					<tr>
		           <td> ${teacher.teacherName}</td>
		           <td> ${teacher.sex} </td>
		            <td> ${teacher.password}</td>
		           <td> ${teacher.birthDate}</td>
		           <td> ${teacher.politicaFace}</td>
		           <td> ${teacher.natives}</td>
		            <td> ${teacher.tePhone} </td>
		            <td> ${teacher.IDNum}</td>
		             <td> ${teacher.admissionTime} </td>
		             <td>${teacher.highesDegree} </td>
		             <td> ${teacher.position}</td>
		             <td> ${teacher.photo} </td>
		              <td>${teacher.national} </td>	
		              <td>${teacher.department_name} </td>	
		              <td>
		              	<a href="${ctx}/admin/Teacher?act=edit" class="btn btn-success"><i class="fa fa-plus"></i> 添加教师</a>
						<a href="${ctx}/admin/Teacher?act=edit&id=${teacher.teacherId}" class="btn btn-info "><i class="fa fa-edit"></i> 修改</a>
						<a href="${ctx}/admin/Teacher?act=delect&id=${teacher.teacherId}" class="btn btn-danger " onclick="return confirm('是否确认要删除？');"><i class="fa fa-remove"></i> 删除</a>
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