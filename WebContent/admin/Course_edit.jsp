<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-新建专业</title>
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
	
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>
        <form action="${ctx}/admin/course" method="post" >  
		<input type="hidden" name="act" value="save"/> 
		<input type="hidden" class="form-control" name="id" readonly="readonly" value="${editcourse.courseID}">
		 <div class="layui-form-item">
		<label class="layui-form-label">专业</label>	  
		<%--  <c:forEach items="${major}" var="major">
		<input type="radio" name="maid" value="${major.maid}"><b>${major.major_name}</b>
		 </c:forEach>  --%>
		 <select name="maid" class="form-control">
		  <c:forEach items="${major}" var="major">
		 <option  value="${major.maid}">${major.major_name}</option>
		 </c:forEach>
		 </select><br> 
		 </div>
		  <div class="layui-form-item">
		  <label class="layui-form-label">学分</label>
		 <select name="creDits" class="form-control">
		 <option value="2">2</option>
		 <option value="3">3</option>
		 <option value="4">4</option>
		  <option value="5">5</option>
		  <option value="6">5</option>
		 </select><br></div>
		 <label>请输入课程名称</label>
		<input type="text" class="form-control" name="name" value="${editcourse.courseName}" placeholder="请输入课程名称">
		 <div class="form-group">
		 <br>	
		  <div class="layui-form-item">
		 <div class="layui-input-block">
		<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
		 <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	 </div></div></div>
		</form>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
   
</body>
</html>