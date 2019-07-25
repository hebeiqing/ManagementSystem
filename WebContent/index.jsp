<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
<title>北海职业学院教务系统</title>
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
<style type="text/css">

 .callbacks_here a:after{

    background: #f8b239;
    border: 1px solid #f8b239;
    height: 24px;
    width: 40px;
    /* border-radius: 0; */
    /* margin: 0 0px; */
} 
.callbacks_tabs a:after{
   content: "\f111";
    font-size: 0;
    font-family:FontAwesome ;
   
    visibility: visible;
    display: block;
    width: 34px;
    height: 26px;
    display: inline-block;
    background: #f8b239;
    /* border-radius: 50%; */
    border: 4px solid #f8b239;

} 
.banner-text p{
color:white;
}

</style>
</head>
<body>
<!-- Header -->
<div id="home" class="banner w3l">
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
									<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:info@example.com">beizhi@example.com</a></li>
									<li><i class="fa fa-phone" aria-hidden="true"></i>+1 (100)222-0-33</li>	
								</ul>
							</div>
							</div>
					<div class="collapse navbar-collapse cl-effect-13" id="bs-example-navbar-collapse-1">

						<ul class="nav navbar-nav navbar-right">
							<li><a href="${ctx}/index.jsp" class="active">首页</a></li>
							<%-- <li><a href="${ctx}/services.jsp">Services</a></li> --%>
						</ul>

					</div>
					<div class="clearfix"> </div>	
				</nav>
							<div class="clearfix"> </div>
		</div>
		<div class="container">
		<div class="banner-info wow bounceInDown" data-wow-duration="1s" data-wow-delay="0s">
			<div  class="callbacks_container">
				<ul class="rslides" id="slider3">
					<li>
						<div class="banner-text">
							<h3>学生登录</h3>
							<form action="${ctx}/studentLogin" method="post">
						  <div class="form-group">
						   
						    <input type="text" class="form-control" name="studentname" placeholder="请输入你的用户名" >
						  </div>
						  <div class="form-group">
						    
						    <input type="password" class="form-control" name="studentpassword" placeholder="请输入你的密码">
						  </div>
						  <button type="submit" class="btn btn-warning btn-block">登录</button>
						</form>
						<br>
						<div class="more-button" title="学生登录" >  <p style="position: absolute;float: left;margin-top: 50px;">点击按钮切换用户登录</p>
			              <br>
			              <br>		              
		            </div> 
					</li>
					<li>
						<div class="banner-text">
							<h3>教师登录</h3>
							<form action="${ctx}/teacherlogin" method="post">
						  <div class="form-group">
						  
						    <input type="text" class="form-control" name="teacharname" placeholder="请输入你的用户名">
						  </div>
						  <div class="form-group">
						 
						    <input type="password" class="form-control" name="teacharpassword" placeholder=" 请输入你的密码">
						  </div>
						  <button type="submit" class="btn btn-warning btn-block">登录</button>
						</form>			
		                <br>
						<div class="more-button" >  <p style="position: absolute;float: left;margin-top: 50px;">点击按钮切换用户登录</p>
			              <br>
			              <br>		              
		            </div> 
					</li>
					<li>
						<div class="banner-text">
							<h3>管理员登录</h3>
							<form action="${ctx}/adminLogin" method="post">
						  <div class="form-group">
						  
						    <input type="text" class="form-control" name="username" placeholder="请输入你的用户名">
						  </div>
						  <div class="form-group">
						
						    <input type="password" class="form-control" name="password" placeholder="请输入你的密码">
						  </div>
						  <button type="submit" class="btn btn-warning btn-block">登录</button>
						</form>
							<br>
							<div class="more-button"> <p style="position: absolute;float: left;margin-top: 50px;">点击按钮切换用户登录</p>
							<br>
							<br>	
		                    </div>
						</div>
					</li>
					<!-- <li>
						<div class="banner-text">
							<h3>Better education for a</h3>
							<h4>Better world</h4>
							<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem ab illo.</p>
							<div class="more-button">
			<a href="#" data-toggle="modal" data-target="#myModal1">Read More</a>
		</div>
						</div>
					</li> -->
				</ul>
			</div>	
		</div>
		
		</div>
</div>	
<!-- //Header -->
<!-- Modal1 -->
						<div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
							<div class="modal-dialog">
							<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4>åæµ·èä¸å­¦é¢</h4>
										<img src="images/bann.jpg" alt=" " class="img-responsive">
										<h5>çµå­ä¿¡æ¯å·¥ç¨ç³»</h5>
										<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting.</p>
									</div>
								</div>
							</div>
						</div>
<!-- //Modal1 -->
<!-- Events-Modal-Popup-->
<!-- Modal2 -->
						<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
							<div class="modal-dialog">
							<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4>Emphasize</h4>
										<img src="images/a1.jpg" alt=" " class="img-responsive">
										<h5>Emphasize Summer 2017</h5>
										<div class="detail-bottom">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>30 May</li>
									<li><i class="fa fa-map-marker" aria-hidden="true"></i>LONDON, UK</li>
								</ul>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore sed do eiusmod tempor incididunt ut labore.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore sed do eiusmod tempor incididunt ut labore.</p>
							</div>
									</div>
								</div>
							</div>
						</div>
<!-- //Modal2 -->
<!-- Modal3 -->
						<div class="modal fade" id="myModal3" tabindex="-1" role="dialog">
							<div class="modal-dialog">
							<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4>Emphasize</h4>
										<img src="images/a2.jpg" alt=" " class="img-responsive">
										<h5>Summer online courses</h5>
										<div class="detail-bottom">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>15 June</li>
									<li><i class="fa fa-map-marker" aria-hidden="true"></i>BERLIN, GERMANY</li>
								</ul>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore sed do eiusmod tempor incididunt ut labore.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore sed do eiusmod tempor incididunt ut labore.</p>
							</div>
									</div>
								</div>
							</div>
						</div>
<!-- //Modal3 -->
<!-- Modal4 -->
						<div class="modal fade" id="myModal4" tabindex="-1" role="dialog">
							<div class="modal-dialog">
							<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4>Emphasize</h4>
										<img src="images/a3.jpg" alt=" " class="img-responsive">
										<h5>Education tour 2017</h5>
										<div class="detail-bottom">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>25June</li>
									<li><i class="fa fa-map-marker" aria-hidden="true"></i>VENICE, ITALY</li>
								</ul>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore sed do eiusmod tempor incididunt ut labore.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore sed do eiusmod tempor incididunt ut labore.</p>
							</div>
									</div>
								</div>
							</div>
						</div>
<!-- //Modal4 -->
<!-- Modal5 -->
						<div class="modal fade" id="myModal5" tabindex="-1" role="dialog">
							<div class="modal-dialog">
							<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4>Emphasize</h4>
										<img src="images/a4.jpg" alt=" " class="img-responsive">
										<h5>Good Results</h5>
										<div class="detail-bottom">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>01 July</li>
									<li><i class="fa fa-map-marker" aria-hidden="true"></i>NEWYORK, USA</li>
								</ul>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore sed do eiusmod tempor incididunt ut labore.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore sed do eiusmod tempor incididunt ut labore.</p>
							</div>
									</div>
								</div>
							</div>
						</div>
<!-- //Modal5 -->
<!-- //Events-Modal-Popup-->
<!-- <div class="tlinks">Collect from <a href="http://www.cssmoban.com/" ><h1>ddd</h1></a></div> -->
<!-- about-agileits -->
<div class="about-agileits">
		<div class="container">	
		<h3 class="heading-agileinfo">北海职业学院<span>接收良好的教育</span></h3>
			<div class="agileits_banner_bottom">
			<p>北海职业学院（BEIHAI VOCATIONAL COLLEGE）是北海市政府举办的唯一的公办普通高等院校，面向全国招收高中起点三年全日制大专生，于2003年8月8日经广西壮族自治区人民政府批准、国家教育部备案成立。学院位于美丽的滨海旅游城市——广西北海市，其南临北部湾，是中国第一批对外的14个沿海开放的城市之一。学院现开设港口物流设备与自动控制、艺术设计、计算机应用技术、酒店管理、物流管理等36个专业43个方向；其中港口物流设备与自动控制及酒店管理等两个专业建设项目已成为广西高等学校特色专业及课程一体化建设项目，并获得“中央财政支持的高等职业学校提升专业服务产业发展能力建设项目”的立项建设</p>
			</div>
			<div class="w3ls_banner_bottom_grids">
				<ul class="cbp-ig-grid">
					<li>
						<div class="w3_grid_effect">
							<span class="cbp-ig-icon w3_road"></span>
							<h4 class="cbp-ig-title">Who we are</h4>
							<span class="cbp-ig-category">Emphasize</span>
						</div>
					</li>
					<li>
						<div class="w3_grid_effect">
							<span class="cbp-ig-icon w3_cube"></span>
							<h4 class="cbp-ig-title">What we do</h4>
							<span class="cbp-ig-category">Emphasize</span>
						</div>
					</li>
					<li>
						<div class="w3_grid_effect">
							<span class="cbp-ig-icon w3_users"></span>
							<h4 class="cbp-ig-title">activities</h4>
							<span class="cbp-ig-category">Emphasize</span>
						</div>
					</li>
					<li>
						<div class="w3_grid_effect">
							<span class="cbp-ig-icon w3_ticket"></span>
							<h4 class="cbp-ig-title">Experience</h4>
							<span class="cbp-ig-category">Emphasize</span>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
<!-- about-agileits -->
<!-- Stats -->
<!-- 	<div class="stats-agileits" id="stats">
	<div class="container">
		<h3 class="heading-agileinfo white-w3ls">我们值得骄傲的事<span class="black-w3ls">Sed lectus tellus , feugiat porttitor nulla.</span></h3>
	</div>
		<div class="stats-info agileits w3layouts">
		<div class="container">
			<div class="col-md-3 agileits w3layouts col-sm-6 stats-grid stats-grid-1">
				<div class="numscroller agileits-w3layouts" data-slno='1' data-min='0' data-max='2500' data-delay='3' data-increment="2">2500</div>
				<div class="stat-info-w3ls">
					<h4 class="agileits w3layouts">Foreign Followers</h4>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 agileits w3layouts stats-grid stats-grid-2">
				<div class="numscroller agileits-w3layouts" data-slno='1' data-min='0' data-max='150' data-delay='3' data-increment="2">150</div>
				<div class="stat-info-w3ls">
					<h4 class="agileits w3layouts">Certified Teachers</h4>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 stats-grid agileits w3layouts stats-grid-3">
				<div class="numscroller agileits-w3layouts" data-slno='1' data-min='0' data-max='3421' data-delay='3' data-increment="2">3421</div>
				<div class="stat-info-w3ls">
					<h4 class="agileits w3layouts">Students Enrolled</h4>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 stats-grid stats-grid-4 agileits w3layouts">
				<div class="numscroller agileits-w3layouts" data-slno='1' data-min='0' data-max='210' data-delay='3' data-increment="2">210</div>
				<div class="stat-info-w3ls">
					<h4 class="agileits w3layouts">Complete Courses</h4>
				</div>
			</div>
			<div class="clearfix"></div>
			</div>
		</div>
	</div>
	//Stats
Events 
		<div class="events-agileits-w3layouts">
		<h3 class="heading-agileinfo">汇流纳川修德砺能<span>校训</span></h3>
		
				<div class="popular-grids">
					<div class="col-md-3 popular-grid">
						<img src="images/a1.jpg" class="img-responsive" alt=""/>
						<div class="popular-text">
							<h5><a href="#" data-toggle="modal" data-target="#myModal2">电子信息工程系</a></h5>
							<div class="detail-bottom">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>30 May</li>
									<li><i class="fa fa-map-marker" aria-hidden="true"></i>LONDON, UK</li>
								</ul>
								<p>建系以来，为适应培养生产、管理、服务于一线，且具有一定创新能力的高素质技能型专门人才的需要，采用“双证（学历证书与职业资格证书）并重”、“产学结合”的教学体系，融学历教育与职业技能培训、理论教学与实践教学为一体的运行机制，以职业课程为主干、职业技能训练为重点，直接面向市场需求培养人才。</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 popular-grid">
						<img src="images/a2.jpg" class="img-responsive" alt=""/>
						<div class="popular-text">
							<h5><a href="#" data-toggle="modal" data-target="#myModal3">旅游商贸系</a></h5>
							<div class="detail-bottom">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>15 June</li>
									<li><i class="fa fa-map-marker" aria-hidden="true"></i>BERLIN, GERMANY</li>
								</ul>
								<p>旅游商贸系拥有一支结构合理、理论教学和实践经验丰富、创新能力突出的教师队伍，专业教师33人，其中博士1人，硕士研究生以上学历的教师6人，双师型教师18人。初步形成了特色鲜明、分布合理、紧密结合就业岗位需求的专业群</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 popular-grid">
						<img src="images/a3.jpg" class="img-responsive" alt=""/>
						<div class="popular-text">
							<h5><a href="#" data-toggle="modal" data-target="#myModal4">经济管理系</a></h5>
							<div class="detail-bottom">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>25June</li>
									<li><i class="fa fa-map-marker" aria-hidden="true"></i>VENICE, ITALY</li>
								</ul>
								<p>经济管理系是以财经、管理两大类专业为主的综合系，一贯坚持“以服务为宗旨，以就业为导向，走产学结合发展道路”的理念，培养适应地方经济和社会发展所需的各种高素质技能型专门人才。师资队伍力量雄厚，除了有一批教学经验丰富的校内专任教师，还长期聘请各专业的行业专家、技术能手为专业指导委员会成员，参与专业建设和担任各专业的课程教学工作</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 popular-grid">
						<img src="images/a4.jpg" class="img-responsive" alt=""/>
						<div class="popular-text">
							<h5><a href="#" data-toggle="modal" data-target="#myModal5">文化传媒系</a></h5>
							<div class="detail-bottom">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i>01 July</li>
									<li><i class="fa fa-map-marker" aria-hidden="true"></i>NEWYORK, USA</li>
								</ul>
								<p>文化与传媒系一直以“夯实传统文化底蕴，培养艺术审美情趣，练就过硬专业技能”为目标，有专任教师45人，副高以上职称10人，硕士研究生11人。积极推进仿真实务训练，情景模拟，案例分析等实训活动，以强化学生的职业能力和实践能力，努力打造视野开阔，基础扎实，具有现代意识和创新精神的高素质技能型专门人才</p>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
		</div>
//Events 
testimonials
<div id="testimonials" class="testimonials">
	<div class="container">
		<h3 class="heading-agileinfo">社团介绍<span>兴趣是最好的老师</span></h3>
		<div class="flex-slider">
			<ul id="flexiselDemo1">			
				<li>
					<div class="laptop">
						<div class="col-md-8 team-right">
							<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur,
								adipisci velit, sed quia non numquam.</p>
							<div class="name-w3ls">
								<h5>Federica</h5>
								<span>lorem ipsum</span>
							</div>
						</div>
						<div class="col-md-4 team-left">
							<img class="img-responsive" src="images/test1.jpg" alt=" " />
						</div>
						<div class="clearfix"></div>
					</div>
				</li>
				<li>
					<div class="laptop">
						<div class="col-md-8 team-right">
							<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur,
								adipisci velit, sed quia non numquam.</p>
							<div class="name-w3ls">
								<h5>Thompson</h5>
								<span>lorem ipsum</span>
							</div>
						</div>
						<div class="col-md-4 team-left">
							<img class="img-responsive" src="images/test2.jpg" alt=" " />
						</div>
						<div class="clearfix"></div>
					</div>
					
				</li>
			</ul>
			
		</div>

	</div>
</div> -->
<!--//testimonials-->
<!-- footer -->

<!-- <div class="contact-w3ls ">
<div class="contact-top-w3-agile">
</div>
	<div class="container">
		<h2 class="heading-agileinfo white-w3ls">Contact Us<span class="black-w3ls">Welcome to our Emphasize. We are glad to have you around.</span></h2>
		<ul class="w3_address">
			<li><i class="fa fa-map-marker" aria-hidden="true"></i><span>Melbourne St, QLD 4101, Australia.</span></li>
			<li><i class="fa fa-volume-control-phone" aria-hidden="true"></i><span>+1234 567 567<br>+1567 567 234</span></li>
			<li><i class="fa fa-envelope-o" aria-hidden="true"></i><span><a href="mailto:info@example.com">info@example1.com</a><br><a href="mailto:info@example.com">info@example2.com</a></span></li>
			<li><i class="fa fa-comments-o" aria-hidden="true"></i></li>
		</ul>
			<div class="clearfix"></div>
		<div class="copy">
				<ul class="banner-menu-w3layouts">
					<li><a href="index.html">é¦é¡µ</a></li>
					<li><a href="services.html">Services</a></li>
					
					
				</ul>
				<ul class="agileits_social_list">
					<li><a href="#" class="w3_agile_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="#" class="agile_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3_agile_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3_agile_vimeo"><i class="fa fa-vimeo" aria-hidden="true"></i></a></li>
				</ul>
		</div>
	</div> -->
</div>
<!--//footer -->
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!--//js -->
<script src="js/SmoothScroll.min.js"></script>
<!-- responsiveslides -->
<script src="js/responsiveslides.min.js"></script>
			<script>
									// You can also use "$(window).load(function() {"
									$(function () {
									 // Slideshow 4
									$("#slider3").responsiveSlides({
										auto: false,
										pager: true,
										nav: true,
								 	   speed: 500, 
							     namespace: "callbacks",  
										before: function () {
									$('.events').append("<li>before event fired.</li>");
									},
									after: function () {
										$('.events').append("<li>after event fired.</li>");
										}
										});
										});
			</script>
<!-- //responsiveslides -->
<!-- OnScroll-Number-Increase-JavaScript -->
	<script type="text/javascript" src="js/numscroller-1.0.js"></script>
<!-- //OnScroll-Number-Increase-JavaScript -->
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
 <!--flexiselDemo1 -->
 <script type="text/javascript">
							$(window).load(function() {
								$("#flexiselDemo1").flexisel({
									visibleItems: 2,
									animationSpeed: 1000,
									autoPlay: true,
									autoPlaySpeed: 3000,    		
									pauseOnHover: true,
									enableResponsiveBreakpoints: true,
									responsiveBreakpoints: { 
										portrait: { 
											changePoint:480,
											visibleItems: 1
										}, 
										landscape: { 
											changePoint:640,
											visibleItems: 1
										},
										tablet: { 
											changePoint:991,
											visibleItems: 1
										}
									}
								});
								
							});
			</script>
			<script type="text/javascript" src="js/jquery.flexisel.js"></script>
<!--//flexiselDemo1 -->
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