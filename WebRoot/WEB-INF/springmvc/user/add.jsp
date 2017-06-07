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
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctx}/public/jquery/jquery.min.js" 
			charset="utf-8"></script>
  </head>
  
  <body>
    <form id="addForm" action="${ctx }/user/save" method="post">
    <input type="hidden" id="status" name="status" value="1"/>
    <input type="hidden" id="isAdmin" name="isAdmin" value="0"/>
    <center>
	    <table  border="1" bordercolor="#a0c6e5" style="border-collapse:collapse;" >
	    <tr>
	    	<td>
	    		用户姓名:<input type="text" name="name" id="name" style="width:40%;" />  
   			</td>
   		</tr>
   		<tr>
	    	<td>
	    		邮箱:<input type="text" name="email" id="email" style="width:40%;" />  
   			</td>
   		</tr>
   		 <tr>
   			<td>
	    		用户角色:
	    			<select id="roleId" name="roleId">
			    		<c:forEach items="${roleList }" var="role">
							<option value="${role.id }">${role.name }</option>			    				
			    		</c:forEach>
	    			</select>
	    	</td>
	    </tr>	 
	    <tr>
   			<td>
	    		<input type="button" value="save" onclick="saveRole()"/>
	    	</td>
	    </tr>	
	    </table>
    </center>
    </form>
  </body>
 <script type="text/javascript">
	function saveRole(){
			$("#addForm").submit() ;
	} 
 </script> 
</html>
