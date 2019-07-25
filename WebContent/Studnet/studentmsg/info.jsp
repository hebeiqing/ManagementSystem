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
<thead><tr><th>姓名</th><th>密码</th><th>性别</th>
<th>出生日期</th><th>籍贯</th><th>入学时间</th><th>政治面貌</th>
<th>家庭地址</th><th>电话</th><th>学生民族</th></tr>
				</thead>
				<tbody>	
				<tr>					
					<td>${studentlogin.stuName}</td>
					<td>${studentlogin.password}</td>
					<td>${studentlogin.sex}</td>
					<td>${studentlogin.birthDate}</td>
					<td>${studentlogin.natives}</td>
					<td>${studentlogin.entranceTime}</td>
					<td>${studentlogin.politicalFace}</td>
					<td>${studentlogin.address}</td>
					<td>${studentlogin.perPhone}</td>
					<td>${studentlogin.national}</td>		
				</tr>
				</tbody>
			   </table>
			  </div>
			</div>
   
</body>
</html>

    
   