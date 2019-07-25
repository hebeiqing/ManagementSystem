<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-图书编辑</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="${ctx}/Calendarcard/calendar.css" >
		<script type="text/javascript" src="${ctx}/Calendarcard/calendar.js" ></script>  
		<script type="text/javascript" src="${ctx}/Calendarcard/calendar-zh.js" ></script>
		<script type="text/javascript" src="${ctx}/Calendarcard/calendar-setup.js"></script>
</head>
<body>
	<%@ include file="/common/admin_header.jsp" %><!-- 引入头部 -->
		<div class="container">
			<div class="row">
			  <div class="col-xs-6 col-md-9" style="height:200px;">
				<form action="${ctx}/admin/Teacher" method="post" >
				
				  <input type="hidden" name="act" value="save"/> 	  			  
				    <input type="hidden" class="form-control" name="id" readonly="readonly" value="${teacherid.teacherId}">
				   <div class="layui-form-item">
				    <label class="layui-form-label">姓名</label>
				    <div class="layui-input-block">
				      <input type="text"  name="name"  value="${teacherid.teacherName}" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
				    </div>
				    </div>
				     <div class="layui-form-item">
				    <label class="layui-form-label">密码</label>
				    <div class="layui-input-block">
				     <input type="password"  name="password"  value="${teacherid.password}" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
				    </div>
				    </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">性别</label>
				    <div class="layui-input-block">
				      <input type="radio" name="sex" value="男" value="${teacherid.sex}" checked>男
				      <input type="radio" name="sex" value="女" value="${teacherid.sex}"   >女
				    </div>
				  </div>
				   <div class="layui-form-item">
				    <label class="layui-form-label">出生日期</label>
				  <div class="layui-inline">
				  <%-- <input type="text" class="layui-input" id="test1"  name="date" value="${teacherid.birthDate}"> --%>
				  <input type="text"  class="form-control"  id="EntTime"  name="date" value="${teacherid.birthDate}" name="EntTime" onclick="return showCalendar('EntTime', 'y-mm-dd');"  />
				</div></div>
				  <label >政治面貌</label>
				    <select name="face" >
				   <option value="群众">群众</option>  
				   <option value="团员">团员</option>
				   <option value="党员">党员</option>
				   <option value="预党员"> 预党员 </option>
				   <option value="民主党派"> 民主党派</option>
				   </select> 
				     <label>最高学历</label>
				   <%--  <input type="text" class="form-control" name="highe" value="${teacherid.highesDegree} "> --%>
				   <select name="highe" >
				   <option value="博士">博士</option>
				   <option value="研究生">研究生</option>
				   <option value="本科">本科</option>
				   <option value="专科">专科</option>
				   </select> 
				    <label>职务</label>
				   <%--  <input type="text" class="form-control" name="position" value="${teacherid.position}"> --%>
				    <select name="position" >
				   <option value="教授">教授</option>
				   <option value="副教授">副教授</option>
				   <option value="讲师">讲师</option>
				   <option value="助教">助教</option>
				   </select>
	
				 <%--  <div class="form-group">
				    <label>姓名</label>
				    <input type="text" class="form-control" name="name" value="${teacherid.teacherName}">
				  </div> --%>
				  <%-- <div class="form-group">
				    <label>密码</label>
				    <input type="text"  name="password" class="form-control"  value="${teacherid.password}">
				  </div> --%>
				  <%-- <div class="form-group">
				    <label>性别</label>
				    <input type="text"  name="sex" class="form-control"  value="${teacherid.sex}">
				  </div> --%>
				  <%-- <div class="form-group">
				    <label>出生日期</label>
				     <input type="text" class="form-control" name="date" value="${teacherid.birthDate}">
				  </div> --%>
				  <%-- <div class="form-group">
				    <label>政治面貌</label>
				     <input type="text" class="form-control" name="face" value="${teacherid.politicaFace}">
				  </div> --%>
				  <%-- <div class="form-group">
				    <label>籍贯</label>
				    <input type="text" class="form-control" name="natives" value="${teacherid.natives}">
				  </div> --%>
				  <div class="form-group">
				    <label>电话</label>
				    <input type="text" class="form-control" name="phone" value="${teacherid.tePhone}">
				  </div>
				  <div class="form-group">
				    <label>身份证</label>
				    <input type="text" class="form-control" name="idnum" value="${teacherid.IDNum}">
				  </div>
				  <div class="form-group">
				  <label>籍贯</label>
				      <input type="text"  name="natives" value="${teacherid.natives}" required  lay-verify="required" placeholder="请输入户口所在地" autocomplete="off" class="layui-input">
				    </div>
				     <div class="form-group">
				    <label>民族</label>
				    <input type="text" class="form-control" name="national" value="${teacherid.national}">
				  </div>
				  <div class="form-group">
				    <label>入校时间</label>   
				   <%--  <input type="text" class="form-control" name="intime" value="${teacherid.admissionTime}"> --%>
				   <input type="text" class="form-control"   id="intime"  name="intime" value="${teacherid.admissionTime}"  onclick="return showCalendar('intime', 'y-mm-dd');"  />   
				  </div>
				  <%-- <div class="form-group">
				    <label>最高学历</label>
				    <input type="text" class="form-control" name="highe" value="${teacherid.highesDegree} ">
				  </div>
				  <div class="form-group">
				    <label>职务</label>
				    <input type="text" class="form-control" name="position" value="${teacherid.position}">
				  </div> --%>
				 
				    <div class="form-group">
				    <label>所在部门</label>
				   <input type="hidden" class="form-control" name="depart" value="${teacherid.departmentID}" >${teacherid.department_name}<br><br>
				    <c:forEach items="${department}" var="teacher">
				    <input type="radio"  name="depid" value="${teacher.departmentID}">${teacher.department_name}
				    </c:forEach>
				  </div>
				  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
				</form>
			  </div>
			</div>
		</div>
		
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
</body>
</html>