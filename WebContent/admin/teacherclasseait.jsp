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
			   
			    <div class="layui-input-block">	
				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>
        <form action="${ctx}/admin/tealass" method="post" >  
		<input type="hidden" name="act" value="save"/> 
		<input type="hidden" class="form-control" name="id" readonly="readonly" value="${idteacherclass.tealass_ID}">		
		<h3>请选择老师</h3>
		<select name="teacherid" class="form-control" >
		<c:forEach items="${teacher}" var="teacher">
		<option value="${teacher.teacherId}"> ${teacher.teacherName}</option>
		</c:forEach>
		</select>
		<%--  <c:forEach items="${teacher}" var="teacher">
		<input type="radio" name="teacherid" value="${teacher.teacherId}"><b>${teacher.teacherName}</b><br>
		 </c:forEach>  --%>
		  <h3>请选择班级</h3>
		  <select name="classid" class="form-control"  id="classid">
		  <c:forEach items="${teclass}" var="teclass">
		  <option value="${teclass.classId}">${teclass.class_name}</option>
		  </c:forEach>
		  </select>
		  <%-- </select value="${teclass.classId}">
		<input type="radio" name="classid" value="${teclass.classId}"><b>${teclass.class_name}</b><br>
		 </c:forEach> --%> 
		  <label><h3>请选择课程 按照班级遍历专业</h3></label>
		  <select name="courseid" class="form-control">
		  <c:forEach items="${couse}" var="couse">
		  <option value="${couse.courseID}">${couse.courseName}</option>
		  </c:forEach>
		  </select><br>
		 <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div></div>
		<%-- <<%-- input type="radio" name="courseid" value="${couse.courseID}"><b>${couse.courseName}</b><br>
		 </c:forEach><br> --%> 
		</form>
       </div>
       </div>
      
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
  <!--  <script type="text/javascript">
/*
 * 1、在文档加载完成后
    获取所有省，添加到<select id="province">中
    给<select id="province">这个元素添加onchange事件
   事件内容
    1、获取当前选择的省id
    2、使用省id访问servlet，得到该省下所有市
    3、把每个市添加到<select id="city">中
 */
 function createXMLHttpRequest(){
        try{
            return new XMLHttpRequest();
        }catch(e){
            try{
                return new ActiveXObject("Msxm12.XMLHTTP");
            } catch(e){
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
}
 window.onload = function(){
        /*
        2、给<select id="province">添加change监听
        */
        document.getElementById("classid").onchange = function(){
            /*
            异步请求服务器，得到选择的省下城市
            */
            var xmlHttp = createXMLHttpRequest();
            //打开连接 在浏览器客户端执行，执行时已经改变
            xmlHttp.open("POST","<c:url value='/teacherclass'/>",true);
            //设置请求头
            xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            //发送
            xmlHttp.send("classid="+this.value);//用户选择的省
            //添加监听
            xmlHttp.onreadystatechange = function(){
                if(xmlHttp.readyState == 4 ){
                    if(xmlHttp.status ==200){
                        /*
                        0、先要清空原来的<option>元素
                        1、得到服务器发送过来的所有市
                        2、使用每个市生成<option>元素添加到<select id="city">中
                        */
                        /*
                        清空<select id="city">中的选项
                        */
                        var citySelect = document.getElementById("classid");
                        //获取select中的所有元素
                        var cityOptionArray = citySelect.getElementsByTagName("option");
                        while(cityOptionArray.length>1){//这里只控制循环的次数
                            citySelect.removeChild(cityOptionArray[1]);//只删除1下标，不会删除0
                        }
                        /*
                        得到服务器发送过来的所有市
                        */
                        var cityArray = eval("("+xmlHttp.responseText+")");
                        //循环变量每个city对象，用来生成<option>元素添加到<select id="city">中
                        for(var i=0; i<cityArray.length;i++){
                            var city  = cityArray[i];//得到每个city对象

                            //创建<option>元素
                            var optionEle = document.createElement("option");
                            //给<option>元素的value属性赋值
                            optionEle.value = city.classId;//给<option>的实际值赋为pid,而不是name
                            var textNode = document.createTextNode(city.class_name);//使用城市名称来创建textNode
                            optionEle.appendChild(textNode);//把textNode添加到option元素中
                            //把option元素添加到select元素中
                            citySelect.appendChild(optionEle);
                        }
                    }
                }
            }
        }
 }

</script>  -->
</body>
</html>