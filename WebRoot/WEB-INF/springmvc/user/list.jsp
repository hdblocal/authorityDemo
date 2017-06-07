<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="el" uri="/public/decode/decodeTag.tld"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1" bordercolor="#a0c6e5" style="border-collapse:collapse;" >
	<tr>
		<td colspan="3">
		</td>
		<td>
			<input type="button" value="addUser" onclick="addUser();"/>
		</td>
	</tr>
	<tr>
		<th style="width:20%;">用户名称</th>
		<th style="width:20%;">邮件</th>
		<th style="width:20%;">所屬角色</th>
		<th style="width:20%;">创建时间</th>
		<th style="width:20%;">操作</th>
	</tr>	
		<c:choose> 
			<c:when test="${not empty userList}">
				<c:forEach items="${userList}" var="user">
					<tr> 
						<td>${user[1] }</td> 
						<td>${user[2] }</td> 
						<td>${user[4] }</td> 
						<td>${user[3] }</td> 
						<td>
							<a href="${ctx }/user/edit/${user[0] }">修改</a>
							<a href="${ctx }/user/delete/${user[0] }">删除</a>
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
function addUser(){
	window.location.href = "${ctx}/user/add" ;
}
</script>
</html>