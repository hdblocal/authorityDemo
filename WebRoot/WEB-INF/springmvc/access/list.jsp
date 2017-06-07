<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="el" uri="/public/decode/decodeTag.tld"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
    <table border="1" bordercolor="#a0c6e5" style="border-collapse:collapse;" >
	<tr>
		<td colspan="3">
		</td>
		<td>
			<input type="button" value="addAccess" onclick="addAccess();"/>
		</td>
	</tr>
	<tr>
		<th style="width:25%;">角色名称</th>
		<th style="width:25%;">角色url</th> 
		<th style="width:25%;">创建时间</th>
		<th style="width:25%;">操作</th>
	</tr>	
		<c:choose> 
			<c:when test="${not empty accessList}">
				<c:forEach items="${accessList}" var="access">
					<tr> 
						<td>${access.title }</td> 
						<td>${access.urls }</td>  
						<td>${access.createdTime }</td> 
						<td>
							<a href="${ctx }/access/edit/${access.id }">修改</a>
							<a href="${ctx }/access/delete/${access.id }">删除</a>
						</td>
					</tr>				
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5"> 
						<font color="red">暂时没有任何数据</font>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>  
	</table>
	
  </body>
  <script type="text/javascript">
  	function addAccess(){
  		window.location.href="access/add" ;
  	}
  </script>
</html>
