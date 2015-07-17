<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户</title>
    
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
    <sf:form mothod="post" modelAttribute="user"> 
      username:<sf:input path="username"/> <sf:errors path="username"/> <br>
      password:<sf:input path="password"/> <sf:errors path="password"/><br>
      nickname:<sf:input path="nickname"/><br>
      email:<sf:input path="email"/> <sf:errors path="email"/><br>
      <input type="submit" value="提交按钮"/>
   </sf:form>   
  </body>
</html>
