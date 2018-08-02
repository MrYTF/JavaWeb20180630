<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" %>
<%@ taglib prefix="aa" uri="/testtags" %>
<%@ taglib prefix="c" uri="/jstlc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>账户管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" /><c:out value="${username}" /></h1>
  </div>
  <div class="head-l" style="margin-top: 18px">&nbsp;&nbsp;&nbsp;<a class="button button-little bg-green" href="logoutServlet"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本信息</h2>
  <ul style="display:block">
  <c:if test="${superuser==1}">
    <li><a href="admin/superuser.jsp" target="right"><span class="icon-caret-right"></span>用户信息管理</a></li>
   </c:if>
  <c:if test="${superuser != 1}">
    <li><a href="personal.jsp" target="right"><span class="icon-caret-right"></span>个人信息管理</a></li>
  </c:if>
    <li><a href="course.jsp" target="right"><span class="icon-caret-right"></span>课程信息管理</a></li>
  <c:if test="${superuser==1}"> 
    <li><a href="admin/costomer.jsp" target="right"><span class="icon-caret-right"></span>客户信息管理</a></li>  
  </c:if>
    <li><a href="teacher.jsp" target="right"><span class="icon-caret-right"></span>教师信息管理</a></li>   
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>基本设置</h2>
  <ul>
   	<li><a href="pass.jsp" target="right"><span class="icon-caret-right"></span>账号密码修改</a></li>
  <c:if test="${superuser==1}">	
    <li><a href="admin/InsertCostomer.jsp" target="right"><span class="icon-caret-right"></span>添加客户</a></li>
    <li><a href="admin/InsertTeacher.jsp" target="right"><span class="icon-caret-right"></span>添加教师</a></li>
    <li><a href="admin/InsertCourse.jsp" target="right"><span class="icon-caret-right"></span>添加课程</a></li>        
  </c:if>
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="course.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>