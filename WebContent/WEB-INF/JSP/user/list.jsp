<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>用户列表</title>

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

	<hr/>
	<table width="700" align="center" border="1">
	   <tr>
	      <td>用户标识</td> <td>用户名</td> <td>用户昵称</td> <td>用户密码</td> <td>用户邮箱</td> <td>操作 </td>
	   </tr>
	   <c:if test="${pagers.total le 0}">
           <tr >
                 <td colspan="6">没有任何记录</td>
           </tr>
       </c:if>
	   <c:if test="${pagers.total gt 0}">
		  	<c:forEach items="${pagers.datas }" var="u">
				<tr>
					<td>${u.id }</td><td>${u.username }</td>
					<td><a href="/user/${u.id }">${u.nickname }</a></td>
					<td>${u.password }</td><td>${u.email }</td>
					<td><a href="user/${u.id }/update">更新</a>&nbsp;<a href="user/${u.id }/delete">删除</a></td>
				</tr>
		</c:forEach>
		   <tr>
		      <td colspan="6" >
		        <jsp:include page="/inc/pager.jsp">
					<jsp:param value="users" name="url"/>
					<jsp:param value="${pagers.total}" name="items"/>
				</jsp:include>
		      </td>
		   </tr>
	   </c:if>
	</table>

</body>
</html>
