<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>北职教务系统</title>
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="width:350px;margin-top:100px;">
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<h2 class="text-center">后台管理-登录页面</h2>
		<form action="${ctx}/adminLogin" method="post">
		  <div class="form-group">
		    <label>用户名</label>
		    <input type="text" class="form-control" name="username" placeholder="请输入用户名">
		  </div>
		  <div class="form-group">
		    <label>密码</label>
		    <input type="password" class="form-control" name="password" placeholder="请输入密码">
		  </div>
        <p><a href="Admin_edit.jsp">注册管理员</a></p>
		  <button type="submit" class="btn btn-warning btn-block">登录</button> 
		</form>
	</div>
	<script src="static/js/jquery.js"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>