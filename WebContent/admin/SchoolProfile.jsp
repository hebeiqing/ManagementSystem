<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-学校介绍</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/admin_header.jsp" %><!-- 引入头部 -->
		<div class="container">
			<div class="row">
			  <div class="col-xs-6 col-md-3" style="height:200px;">
			  	<%@ include file="/common/admin_menu.jsp" %><!-- 引入左边菜单 -->
			  </div>
			  <div class="col-xs-6 col-md-9" style="height:200px;">
			  	<!-- <ol class="breadcrumb">
				  <li><a href="#">首页</a></li>
				  <li><a href="#">类别管理</a></li>
				  <li class="active">类别列表</li>
				</ol> -->
			<p class="navbar-text"><h1>北海职业学院</h1></p>
				<%-- <c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if> --%>
				<table class="table table-striped">
					<thead>
						<tr><th></th><th></th><th></th></tr>
					</thead>
					<tbody>
						<th>北海职业学院（BEIHAI VOCATIONAL COLLEGE）是北海市政府举办的唯一的公办普通高等院校，
						面向全国招收高中起点三年全日制大专生，于2003年8月8日经广西壮族自治区人民政府批准、国家教育部备案成立。
						学院位于美丽的滨海旅游城市——广西北海市，其南临北部湾，是中国第一批对外的14个沿海开放的城市之一。
						学院现开设港口物流设备与自动控制、艺术设计、计算机应用技术、酒店管理、物流管理等36个专业43个方向；
						其中港口物流设备与自动控制及酒店管理等两个专业建设项目已成为广西高等学校特色专业及课程一体化建设项目，并获得“中央财政支持的高等职业学校提升专业服务产业发展能力建设项目”的立项建设。</th>
					</tbody>
				</table>
			  </div>
			</div>
		</div>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
</body>
</html>