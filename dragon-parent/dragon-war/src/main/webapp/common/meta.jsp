<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	String ctx = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.useso.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
<link href="<%=ctx%>/plugins/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="<%=ctx%>/plugins/css/slider.css" />

<script type="text/javascript" src="<%=ctx%>/plugins/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/modernizr.custom.28468.js"></script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/jquery.cslider.js"></script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/move-top.js"></script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/easing.js"></script>


<!-- 项目根路径 -->
<input type="hidden" id="rootPath" value="<%=ctx%>" />

