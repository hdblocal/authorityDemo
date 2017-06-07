<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editAccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${ctx}/public/jquery/jquery.min.js" 
		charset="utf-8"></script>
	
  </head>
  
  <body>
  
		<form id="addForm" action="${ctx }/role/saveAccess" method="post">
			<input type="hidden" name="roleId" value="${roleId }"/>
    		权限名称:<br/>
    		<c:forEach items="${accessList }" var="access">
    			<input type="checkbox" name="accessId" value="${access.id }">${access.title }
    		</c:forEach> 
    		<br/>
    		<input type="button" value="save" onclick="saveAccess()"/>
    	</form>  
  
  </body>
  <script type="text/javascript">
  		function saveAccess(){ 
  			$("#addForm").submit() ;
  		}
  </script>
</html>
