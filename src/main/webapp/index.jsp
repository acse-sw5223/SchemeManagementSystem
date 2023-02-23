<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	pageContext.setAttribute("adminPath", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="${adminPath }/static/mui/css/pintuer.css">
    <link rel="stylesheet" href="${adminPath }/static/mui/css/admin.css">
    <script src="${adminPath }/static/mui/js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><%-- <img src="${adminPath }/static/images/default.jpg" class="radius-circle rotate-hover" height="50" alt="" /> --%>${projectName }</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-red" href="${adminPath}/user?method=logout"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  
  <h2><span class="icon-user"></span>个人中心</h2>
   <ul>
 	 <li><a href="${adminPath}/user?method=userInfo" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
	 <li><a href="${adminPath}/user?method=userPassFix" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
   </ul>

   <c:if test="${login!=null && login.role=='1' }">
    <h2><span class="icon-user"></span>系统管理</h2>
    <ul>
    	<li><a href="${adminPath}/user?method=list" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
 		<li><a href="${adminPath}/deptInfo?method=list" target="right"><span class="icon-caret-right"></span>部门管理</a></li>
  	 </ul>
   </c:if>
    <h2><span class="icon-user"></span>方案管理</h2>
    <ul>
        <li><a href="${adminPath}/planDemandInfo?method=list" target="right"><span class="icon-caret-right"></span>方案需求</a></li>
        <c:if test="${login.role != '3'}">
        <li><a href="${adminPath}/bookMakes?method=needAudit" target="right"><span class="icon-caret-right"></span>待审核制定书</a></li>
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
  <li><a href="${adminPath }/inform?method=welcome" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="${adminPath}/user?method=userInfo" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>