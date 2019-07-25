<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>在线书店-首页</title>
	<script src="${ctx}/static/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctx}/static/js/jquery.SuperSlide.2.1.1.js"></script>
	<link  href="${ctx}/static/css/common.css" type="text/css" rel="stylesheet" />
	<link href="${ctx}/static/css/style.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
		$(document).ready(function(){
		 $(".q_code ").hover(function(){
					$(this).find(".q_code_layer").addClass("hover").css("display","block");
				},function(){
					$(this).find(".q_code_layer").removeClass("hover").css("display","none");  
		
				}
			); 
			 $(".diagram ").hover(function(){
					$(this).addClass("hover");
				},function(){
					$(this).removeClass("hover");  
		
				}
			); 
		})
	</script>
</head>
<body>
</body>
</html>