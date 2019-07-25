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
			  <c:if test="${not empty message}">
				<div class="alert alert-success" role="alert">${message}</div>
				</c:if>	
			  <form action="${ctx}/sportstu" method="post" >	
			  <input type="hidden" name="id" value="${studentlogin.stuId}"/>   
			   <table class="layui-table" > 
				<thead><tr><th>选修课名称</th></tr></thead>
				<tbody>
				<c:forEach items="${union}" var="union">
				<tr>	
				<c:if test="${not empty finBysportsCourse}">
			 <td><label><input type="checkbox" value="${union.un_ID} " name="sportsid"  disabled="disabled">${union.un_name }</label></td> 
				</c:if>	
				<c:if test="${ empty finBysportsCourse}">
			 <td><label><input type="checkbox" value="${union.un_ID} " name="sportsid" >${union.un_name }</label></td> 
				</c:if>		
			    
			    </tr>
				</c:forEach>
				
				</tbody>
				</table>
				<button type="submit" class="btn btn-primary" id="submitbtn">提交</button>	
				</form>
</body>
</html>

    
   