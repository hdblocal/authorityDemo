<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="el" uri="public/decode/decodeTag.tld"%>  	
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="${ctx}/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/public/bootstrap/css/dashboard.css">
<script type="text/javascript" src="${ctx}/public/jquery/jquery.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${ctx}/public/bootstrap/js/bootstrap.min.js" charset="utf-8"></script>
	

</head>

<body>

	<!--导航条-->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	    <div class="container-fluid">
	        <!-- Brand and toggle get grouped for better mobile display -->
	        <div class="navbar-header">
	            <a class="navbar-brand" href="#">RBAC</a>
	        </div>
	
	        <div class="collapse navbar-collapse">
	            <ul class="nav navbar-nav">
	                <li class="active"><a href="/">首页</a></li>
	            </ul> 
	            <p class="navbar-text navbar-right">Hi,
	            	<!-- 判断用户是否已经登录,如果登录,显示用户名 -->
	            	${el:FunctionsEl(cookie.username.value)} 
	            </p>
	        </div>
	    </div>
	</nav>

	<!-- 菜单栏和内容区域  左右 -->
	<!--菜单栏和内容区域-->
	<div class="container-fluid">
	    <div class="col-sm-2 col-md-2 col-lg-2 sidebar">
	        <ul class="nav nav-sidebar">
	            <li>权限演示页面</li>
	            <li><a href="user/list">测试页面一</a></li>
	            <li><a href="#">测试页面二</a></li>
	            <li><a href="#">测试页面三</a></li>
	            <li><a href="#">测试页面四</a></li>
	            <li><a href="#">测试页面五</a></li>
	            <li>系统设置</li>
	            <li><a href="user/list">用户管理</a></li>
	            <li><a href="role/list">角色管理</a></li>
	            <li><a href="access/list">权限管理</a></li>
	        </ul>
	    </div>
	    <div class="col-sm-10 col-sm-offset-2 col-md-10  col-md-offset-2 col-lg-10 col-lg-offset-2 main">
	       <div class="row placeholders">
	       	132
	       </div>
	        <hr/>
	        <footer>
	            <p class="pull-left">@毕竟我很菜</p>
	            <p class="pull-right">Power By hdblocal </p>
	        </footer>
	    </div>
	</div>

</body>
</html>
