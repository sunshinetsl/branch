<!DOCTYPE html>
<html lang="zh-cn">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ include file="/common/meta.jsp" %>
<%@ include file="/common/taglibs.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <base href="<%=basePath%>">
    <title></title>
     <decorator:head /> 
</head>
<body class="c_nav-top">
	<!-- header start -->
	<%@ include file="/layout/header_navigator.jsp" %> 
	<%@ include file="/layout/header_community.jsp" %>
	<!-- header end -->
	<!-- main start -->
	<decorator:body />
	<!-- main end -->
	<!-- footer start -->
	<%@ include file="/layout/footer_community.jsp" %>
	<!-- footer end -->
</body>
</html>
   