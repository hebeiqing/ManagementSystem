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
			<div class="layui-form-item">
			 <label class="layui-form-label"></label>
			 <div class="layui-input-block">
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>
        <form action="${ctx}/admin/Sportstu" method="post" >  
		<input type="hidden" name="act" value="save"/> 
		<input type="hidden" class="form-control" name="id" readonly="readonly" value="${idstuun.stuId}">		
		  <h4>请选择学生</h4>
		  <select name="stuid" class="form-control">
		  <c:forEach items="${student}" var="student">
		  <option value="${student.stuId}">${student.stuName}</option>
		   </c:forEach> 
		  </select>
		<%-- <input type="radio" name="stuid" value="${student.stuId}"><b>${student.stuName}</b> --%>
		 <h4>请选择体育选修课</h4>
		 <select name="unid" class="form-control" >
		  <c:forEach items="${unin}" var="unin">
		 <option value="${unin.un_ID}">${unin.un_name}</option>
		 </c:forEach>
		 </select >
		<br><br>
		
		 <div class="layui-form-item">
		 <div class="layui-input-block">
		 <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
		 <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
         </div></div></div>
		</form>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
   
</body>
</html>