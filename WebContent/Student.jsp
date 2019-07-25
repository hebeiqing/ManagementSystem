<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>学生管理</title>
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
							<li><a href="${ctx}/studnetloginout">退出登录</a></li>
						
						</ul>

					</div>
					<div class="clearfix"> </div>	
				</nav>
			<div class="clearfix"> </div>
		</div>
</div>	

<!-- //Header -->
<!-- services inner -->
<div class="container">
<h3 class="heading-agileinfo">欢迎你！${studentlogin.stuName} <span>汇流纳川   修德砺能</span></h3>
				<div class="panel panel-primary" >
				
			  <div class="panel-heading"><h3>个人资料</h3></div>
			  <div class="panel-body">
			   <table class="table">
<thead><tr><th>姓名</th><th>密码</th><th>性别</th><th>出生日期</th><th>籍贯</th><th>入学时间</th><th>政治面貌</th><th>家庭地址</th><th>电话</th><th>学生民族</th></tr>
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
			<div class="panel panel-success" >
			  <div class="panel-heading"><h3>我的课程</h3></div>
			  <div class="panel-body">
			  <table class="table">
				<thead><tr><th>班级名称</th><th>课程名称</th></tr></thead>
				<tbody>
				<c:forEach items="${course}" var="course">
				<tr>
				<td>${course.tb_class.class_name}</td>
				<td>${course.course.courseName}</td>		
				</tr>
				</c:forEach>
				<th>体育选修课</th>
				<c:forEach items="${finBysportsCourse}" var="finBysportsCourse">
				<td>${finBysportsCourse.studentUnion.un_name}</td>
				</c:forEach>
				</tbody>
				</table>
			  </div>
			</div>
			<div class="panel panel-info" >
			  <div class="panel-heading"><h3>我的课程成绩</h3></div>
			  <div class="panel-body">
			   <table class="table">
				<thead><tr><th>课程名称</th><th>成绩</th></tr></thead>
				<thead>
				<tbody>
				<c:forEach items="${score}" var="score">
				<tr>
				<td>${score.course.courseName }</td>
				<td>${score.score }</td>
				</tr>
				</c:forEach>
				</tbody>
				
				</table>
			  </div>
			</div>
			<div class="panel panel-default">
			  <div class="panel-heading"><h3>体育选修课</h3></div>
			  <div class="panel-body">
			  <c:if test="${not empty message}">
				<div class="alert alert-success" role="alert">${message}</div>
				</c:if>	
			  <form action="${ctx}/sportstu" method="post" >	
			  <input type="hidden" name="id" value="${studentlogin.stuId}"/>   
			    <table class="table">
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
			  </div>
			</div>
			
  
</div>
			
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