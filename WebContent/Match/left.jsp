<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html >

<head>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="index.html" target="rightFrame">首页模版</a><i></i></li>
        <li class="active"><cite></cite><a href="${ctx}/admin/department?act=list" target="rightFrame">系部管理</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/major?act=list" target="rightFrame">专业管理</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/classmg?act=list" target="rightFrame">班级管理</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/course?act=list" target="rightFrame">课程管理</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/Teacher?act=list" target="rightFrame">教师管理</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/student?act=list" target="rightFrame">学生管理</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/score?act=list" target="rightFrame">学生成绩</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/studentUnion?act=list" target="rightFrame">体育选修课</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/tealass?act=list"  target="rightFrame">教师选课</a><i></i></li>
        <li><cite></cite><a href="${ctx}/admin/Sportstu?act=list" target="rightFrame">学生选课</a><i></i></li>
        <li><cite></cite><a href="tab.html" target="rightFrame">留言功能</a><i></i></li>
        <li><cite></cite><a href="error.html" target="rightFrame">404页面</a><i></i></li>
        </ul> 
        
    <div class="title">
    <span><img src="images/leftico02.png" /></span>其他设置
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">编辑内容</a><i></i></li>
        <li><cite></cite><a href="#">发布信息</a><i></i></li>
        <li><cite></cite><a href="#">档案列表显示</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>编辑器</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>日期管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>
    
    </dd>   
    
    </dl>
</body>
</html>
