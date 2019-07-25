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
<thead><tr><th>姓名</th><th>性别</th><th>密码</th><th>出生日期</th><th>政治面貌</th><th>籍贯</th><th>电话</th><th>身份证</th><th>入校时间</th><th>最高学历</th><th>职务</th><th>民族</th></tr></thead>
				<tbody>	
				<tr>
		           <td> ${loginteacher.teacherName}</td>
		           <td> ${loginteacher.sex} </td>
		            <td> ${loginteacher.password}</td>
		           <td> ${loginteacher.birthDate}</td>
		           <td> ${loginteacher.politicaFace}</td>
		           <td> ${loginteacher.natives}</td>
		            <td> ${loginteacher.tePhone} </td>
		            <td> ${loginteacher.IDNum}</td>
		             <td> ${loginteacher.admissionTime} </td>
		             <td>${loginteacher.highesDegree} </td>
		             <td> ${loginteacher.position}</td>
		              <td>${loginteacher.national} </td>	
					</tr>	
				</tbody>
			   </table>
		
   
</body>
</html>

    
   