<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理-图书编辑</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
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
				<form action="${ctx}/admin/student" method="post" >
				  <input type="hidden" name="act" value="save"/> 	  			  
				    <input type="hidden" class="form-control" name="id" readonly="readonly" value="${idstudent.stuId}">			
				<label>院系</label>
				<select name="province" id="province" class="form-control"  >
			        <option>院系</option>
			   	</select>
			   	<label>专业</label>
					<select name="city" id="city" class="form-control">
			        <option>选择专业</option>
			       </select>
			       <label>班级</label>
			       <select name="grade" id="grade" class="form-control">
			        <option>选择班级</option>
			       </select>      
				  <div class="form-group">
				    <label>姓名</label>
				    <input type="text" class="form-control" name="name" value="${idstudent.stuName}">
				  </div>
				  <div class="form-group">
				    <label>密码</label>
				  <input type="password" class="form-control" name="password" value="${idstudent.password}">  
				  </div>
				   <div class="form-group">
				    <label>性别</label>
				 <%--  <input type="text" class="form-control" name="sex" value="${idstudent.sex}">   --%>
				      <input type="radio" name="sex" value="男" value="${idstudent.sex}" checked>男
				      <input type="radio" name="sex" value="女"   value="${idstudent.sex}"  >女
				  </div>
				  <div class="form-group">
				    <label>出生日期</label>
				     <%-- <input type="text" class="form-control" name="birthDate" value="${idstudent.birthDate}"> --%>
				       <input type="text" name="birthDate" value="${idstudent.birthDate}"   id="EntTime"  name="EntTime" onclick="return showCalendar('EntTime', 'y-mm-dd');"  />
				  </div>
				  <div class="form-group">
				    <label>入学时间</label>
				     <input type="text"   id="intime"  name="entranceTime" value="${idstudent.entranceTime}"  onclick="return showCalendar('intime', 'y-mm-dd');"  />   
				   <%--  <input type="text" class="form-control" name="entranceTime" value="${idstudent.entranceTime}"> --%>
				  </div>
				  
				  <div class="form-group">
				    <%-- <label>政治面貌</label>
				     <input type="text" class="form-control" name="politicalFace" value="${idstudent.politicalFace}"> --%>
				      <label >政治面貌</label>
				    <select name="politicalFace" class="form-control" >
				   <option value="群众">群众</option>  
				   <option value="团员">团员</option>
				   <option value="党员">党员</option>
				   <option value="预党员"> 预党员 </option>
				   <option value="民主党派"> 民主党派</option>
				   </select> 
				  </div>
				  <div class="form-group">
				    <label>籍贯</label>
				    <input type="text" class="form-control" name="natives" value="${idstudent.natives}">
				  </div>
				  <div class="form-group">
				    <label>电话</label>
				    <input type="text" class="form-control" name="perPhone" value="${idstudent.perPhone}">
				  </div>
				  <div class="form-group">
				    <label>身份证</label>
				    <input type="text" class="form-control" name="IDNum" value="${idstudent.IDNum}">
				  </div>
				  <div class="form-group">
				    <label>家庭地址</label>
				    <input type="text" class="form-control" name="address" value="${idstudent.address} ">
				  </div>
				  <div class="form-group">
				    <label>民族</label>
				    <input type="text" class="form-control" name="national" value="${idstudent.national}">
				  </div>
					<div class="layui-form-item">
				    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div></div>
				</form>
		</div></div>
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/wangEditor-3.1.1/wangEditor.min.js"></script>
    
  <script type="text/javascript">
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
            发送异步请求，得到所有省，然后使用每个省生成一个<option>元素添加到<select id ="province">中
        */
        //得到核心对象
        var xmlHttp = createXMLHttpRequest();
        //打开连接 在浏览器客户端执行，执行时已经改变
        xmlHttp.open("GET","<c:url value='/text'/>",true);
        //发送
        xmlHttp.send(null);
        //添加监听
        xmlHttp.onreadystatechange = function(){
            if(xmlHttp.readyState == 4 ){
                if(xmlHttp.status ==200){
                    //执行服务器发送过来的json字符串，得到js的对象
                    var proArray =  eval("("+xmlHttp.responseText+")");
                    for(var i =0; i<proArray.length;i++){
                        var pro  = proArray[i];//得到每个pro对象

                        //创建<option>元素
                        var optionEle = document.createElement("option");
                        //给<option>元素的value属性赋值
                        optionEle.value = pro.departmentID;//给<option>的实际值赋为pid,而不是name
                        var textNode = document.createTextNode(pro.department_name);//使用省名称来创建textNode
                        optionEle.appendChild(textNode);//把textNode添加到option元素中
                        //把option元素添加到select元素中
                        document.getElementById("province").appendChild(optionEle);
                    }
                }
            }   
        };
        /*
        2、给<select id="province">添加change监听
        */
        document.getElementById("province").onchange = function(){
            /*
            异步请求服务器，得到选择的省下城市
            */
            var xmlHttp = createXMLHttpRequest();
            //打开连接 在浏览器客户端执行，执行时已经改变
            xmlHttp.open("POST","<c:url value='/texts'/>",true);
            //设置请求头
            xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            //发送
            xmlHttp.send("pid="+this.value);//用户选择的省
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
                        var citySelect = document.getElementById("city");
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
                            optionEle.value = city.maid;//给<option>的实际值赋为pid,而不是name
                            var textNode = document.createTextNode(city.major_name);//使用城市名称来创建textNode
                            optionEle.appendChild(textNode);//把textNode添加到option元素中
                            //把option元素添加到select元素中
                            citySelect.appendChild(optionEle);
                        }
                    }
                }
            }
        }
        /*
        2、给<select id="province">添加change监听
        */
        document.getElementById("city").onchange = function(){
            /*
            异步请求服务器，得到选择的省下城市
            */
            var xmlHttp = createXMLHttpRequest();
            //打开连接 在浏览器客户端执行，执行时已经改变
            xmlHttp.open("POST","<c:url value='/texts'/>",true);
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
                        var citySelect = document.getElementById("grade");
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

</script>
    
    
    
</body>
</html>