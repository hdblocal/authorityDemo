<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctx}/public/jquery/jquery.min.js" charset="utf-8"></script>
  </head>
  
  <body>
   
   		<form id="editForm" action="${ctx }/role/update" method="post">
   			<input type="hidden" name="id" id="id" value="${role.id }"/>
   			<input type="hidden" name="status" id="status" value="${role.status }"/> 
    		角色名称:<input type="text" name="name" id="name" value="${role.name }" style="width:40%;" />  
    		<input type="button" value="update" onclick="updateRole()"/>
    	</form>
   
  </body>
<script type="text/javascript">
	function updateRole(){
		$("#editForm").submit() ;
	}
</script>
</html>
