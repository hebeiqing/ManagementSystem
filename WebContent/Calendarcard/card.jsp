<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
          <link type="text/css" rel="stylesheet" href="${ctx}/Calendarcard/calendar.css" >
		<script type="text/javascript" src="${ctx}/Calendarcard/calendar.js" ></script>  
		<script type="text/javascript" src="${ctx}/Calendarcard/calendar-zh.js" ></script>
		<script type="text/javascript" src="${ctx}/Calendarcard/calendar-setup.js"></script>
<title>日历卡</title>
</head>
<body>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择时间：<input type="text" id="EntTime" name="EntTime" onclick="return showCalendar('EntTime', 'y-mm-dd');"  />
 <input type="text" id="EntTime"  class="form-control"  name="EntTime" onclick="return showCalendar('EntTime', 'y-mm-dd');"  />

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>固定块</legend>
</fieldset>
 
<p>囖，就页面右下角的那个。</p>
 
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>倒计时</legend>
</fieldset>
请选择要计算的日期：
<div class="layui-inline">
  <input type="text" class="layui-input" id="test1" value="2099-01-01 00:00:00">
</div>
<blockquote class="layui-elem-quote" style="margin-top: 10px;">
  <div id="test2"></div>
</blockquote>
 
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>某个时间在当前时间的多久前</legend>
</fieldset>
 
请选择要计算的日期：
<div class="layui-inline">
  <input type="text" class="layui-input" id="test3">
</div>
 
<span class="layui-word-aux" id="test4"></span>
              
          
<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['util', 'laydate', 'layer'], function(){
  var util = layui.util
  ,laydate = layui.laydate
  ,layer = layui.layer;
  //固定块
  util.fixbar({
    bar1: true
    ,bar2: true
    ,css: {right: 50, bottom: 100}
    ,bgcolor: '#393D49'
    ,click: function(type){
      if(type === 'bar1'){
        layer.msg('icon是可以随便换的')
      } else if(type === 'bar2') {
        layer.msg('两个bar都可以设定是否开启')
      }
    }
  });
  
  //倒计时
  var thisTimer, setCountdown = function(y, M, d, H, m, s){
    var endTime = new Date(y, M||0, d||1, H||0, m||0, s||0) //结束日期
    ,serverTime = new Date(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的
     
    clearTimeout(thisTimer);
    util.countdown(endTime, serverTime, function(date, serverTime, timer){
      var str = date[0] + '天' + date[1] + '时' +  date[2] + '分' + date[3] + '秒';
      lay('#test2').html(str);
      thisTimer = timer;
    });
  };
  setCountdown(2099,1,1);
  
  laydate.render({
    elem: '#test1'
    ,type: 'datetime'
    ,done: function(value, date){
      setCountdown(date.year, date.month - 1, date.date, date.hours, date.minutes, date.seconds);
    }
  });
  
  
  //某个时间在当前时间的多久前
  var setTimeAgo = function(y, M, d, H, m, s){
    var str = util.timeAgo(new Date(y, M||0, d||1, H||0, m||0, s||0));
    lay('#test4').html(str);
  };
  
  laydate.render({
    elem: '#test3'
    ,type: 'datetime'
    ,done: function(value, date){
      setTimeAgo(date.year, date.month - 1, date.date, date.hours, date.minutes, date.seconds);
    }
  });
  
});
</script>


</body>
</html>