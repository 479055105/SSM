<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <a href="managerinfo_execute.action" >查看信息(struts)</a>
    
    <a href="managerinfo.action" >查看信息(springmvc)</a>
    
	<a href="MyJsp.jsp">测试 Json</a>
	<a href="download.action?filename=2016中国软件开发者白皮书.pdf">测试下载</a>
	<a href="MyJsp2.jsp">测试文件上传</a>
  </body>
</html>
