<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${ctx}/public/jquery/jquery.min.js" charset="utf-8"></script>
</head>
<body>

	<table border="1" bordercolor="#a0c6e5" style="border-collapse:collapse;" >
	<tr>
		<td>
		</td>
		<td>
			<input type="button" value="addRole" onclick="addRole();"/>
		</td>
	</tr>
	<tr>
		<th style="width:30%;">角色名称</th>
		<th style="width:30%;">创建时间</th>
		<th style="width:40%;">操作</th>
	</tr>	
		<c:choose> 
			<c:when test="${not empty roleList}">
				<c:forEach items="${roleList}" var="role">
					<tr>
						<td>${role.name }</td>
						<td>${role.updatedTime }</td>
						<td>
							<a href="${ctx }/role/edit/${role.id }">修改</a>
							<a href="${ctx }/role/eidtAccess/${role.id }">设置权限</a>
						</td>
					</tr>				
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="3"> 
						<font color="red">暂时没有任何数据</font>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>  
	</table>

</body> 
<script type="text/javascript">
	function addRole(){
		window.location.href="${ctx}/role/add" ;		
	}
</script>
</html>