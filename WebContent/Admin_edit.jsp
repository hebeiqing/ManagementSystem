<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-图书编辑</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/admin_header.jsp" %><!-- 引入头部 -->
		<div class="container">
			  <div class="col-xs-6 col-md-9" style="height:200px;">
			  	<ol class="breadcrumb">
				  <li><a href="#">管理员注册</a></li>
				</ol>
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>
				<form action="${ctx}/Adminregistered" method="post" >
				  <input type="hidden" name="act" value="save"/> 	  			  
				  <div class="form-group">
				    <label>ID</label>
				    <input type="text" class="form-control" name="id" readonly="readonly" value="${idstudent.stuId}">
				  </div>
				  <div class="form-group">
				    <label>姓名</label>
				    <input type="text" class="form-control" name="username" >
				  </div>
				  <div class="form-group">
				    <label>密码</label>
				  <input type="text" class="form-control" name="password" ">  
				  </div>
				   <div class="form-group">
				    <label>性别</label>
				  <input type="radio"  name="sex"  value="男">  男
				   <input type="radio"  name="sex"  value="女">  女
				  </div>
				  <div class="form-group">
				    <label>手机号码</label>
				     <input type="text" class="form-control" name="mobile" >
				  </div>
				  <button type="submit" class="btn btn-default">提交</button>
				</form>
			  </div>
			</div>
		</div>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
</body>
</html>
