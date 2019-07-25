<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>教师管理</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- // custom-theme -->
<!--css links-->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /><!--bootstrap-->
<link href="css/font-awesome.css" rel="stylesheet"><!--font-awesome-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" /><!--stylesheet-->
<!--//css links-->
<!--fonts-->
<link href="http://fonts.googleapis.com/css?family=Raleway:200,300,400,500,600,700" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=PT+Serif:400,700" rel="stylesheet">
<!--//fonts-->
</head>
<body>
<!-- Header -->
<div id="home" class="banner inner-banner-w3l">
		<div class="header-nav">
			<nav class="navbar navbar-default">
			<div class="header-top">
					<div class="navbar-header logo">
								<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
								<h1>
									<a class="navbar-brand" href="index.html"><i class="fa fa-graduation-cap" aria-hidden="true"></i>北海职业学院</a>
								</h1>
					</div>
					<!-- navbar-header -->
					<div class="contact-bnr-w3-agile">
								<ul>
									<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:info@example.com">info@example.com</a></li>
									<li><i class="fa fa-phone" aria-hidden="true"></i>+1 (100)222-0-33</li>	
								</ul>
							</div>
							</div>
					<div class="collapse navbar-collapse cl-effect-13" id="bs-example-navbar-collapse-1">

						<ul class="nav navbar-nav navbar-right">
							<li><a href="${ctx}/teacherloginout">退出登录</a></li>
						
						</ul>

					</div>
					<div class="clearfix"> </div>	
				</nav>
							<div class="clearfix"> </div>
		</div>
</div>	
<!-- //Header -->
<!-- services inner -->
<div class="agileinfo_services_grids inner-padding">
<div class="container">
<h3 class="heading-agileinfo">欢迎你！${loginteacher.teacherName}<span>汇流纳川   修德砺能</span></h3>			
			<div class="panel panel-primary" >
			  <div class="panel-heading"><h3>个人资料</h3></div>
			  <div class="panel-body">
			   <table class="table">
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
		              <td>${loginteacher.department_name} </td>	
					</tr>	
				</tbody>
			   </table>
			  </div>
			</div>
			<div class="panel panel-success" >
			  <div class="panel-heading"><h3>教学课程</h3></div>
			  <div class="panel-body">
			 <table class="table">
			<thead><th>班级名称</th><th>课程名称</th></thead>
			<tbody>
			<c:forEach items="${Teachercourse}" var="Teachercourse">
			<tr>
			<td>${Teachercourse.class1.class_name}</td>
			<td>${Teachercourse.course.courseName}</td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			  </div>
			</div>
			<div class="panel panel-info" >
			  <div class="panel-heading"><h3>学生</h3></div>
			  <div class="panel-body">
			   <form action="${ctx}/ChangePoints" method="post" >	
			   
			   	<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
			   <table class="table">
				<thead><th>班级名称</th><th>课程名称</th><th>学生姓名</th></thead>
				<tbody>
				<c:forEach items="${TeacherStudent}" var="TeacherStudent">
				<tr>
				<td>${TeacherStudent.class1.class_name}</td>
				<td>${TeacherStudent.course.courseName}</td>
				<td>${TeacherStudent.student.stuName}</td>
				</td>
				</tr>
				</c:forEach>	
				</tbody>	
			   </table>
			 </form>
			 </div>
			</div>
			<%--<div class="panel panel-warning">
		   <div class="panel-heading">学生成绩</div>
		  <div class="panel-body">
		    
	 <form action="${ctx}/ChangePoints" method="post" >  
	     <table class="table">
	     <thead><th>学生</th></thead>
        <c:forEach items="${findByscore}" var="findByscore">
        <tr>
		<td><input type="radio" " name="Stuid" value="${findByscore.stuId}">${findByscore.student.stuName}</td>
		</tr>
		</c:forEach>	
	    <thead><th>课程</th></thead>
		<c:forEach items="${findByscore}" var="findByscore">
		<tr>
		<td><input type="radio" " name="courseid" value="${findByscore.courseID}">${findByscore.course.courseName}</td>
		</tr>
		</c:forEach>
		</table>
		 <div class="form-group">
		 <label>分数</label>
		<input type="text" class="form-control" name="score" >  
		 </div>
		  <button type="submit" class="btn btn-default" >提交</button>
		</form>    
		    
		  </div>
		</div>
	 --%>
	
	
	
</div>
</div>
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!--//js -->
<script src="js/SmoothScroll.min.js"></script>
<!--Scrolling-top -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!--//Scrolling-top -->
<!-- smooth scrolling -->
	<script type="text/javascript">
		$(document).ready(function() {						
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
</body>
</html>