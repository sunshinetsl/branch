<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%@ include file="/common/taglibs.jsp" %>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	String ctx = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:400,600'>
<link rel="stylesheet" type="text/css" href="<%=ctx%>/plugins/css/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="<%=ctx%>/plugins/css/slider.css" />

<script type="text/javascript" src="<%=ctx%>/plugins/js/jquery-1.10.2.mini.js"></script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/modernizr.custom.28468.js"></script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/jquery.cslider.js"></script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/move-top.js"></script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/easing.js"></script>

<!-- 引用控制层插件样式 -->
<link rel="stylesheet" href="<%=ctx %>/plugins/control/css/zyUpload.css" type="text/css">
<!-- 引用核心层插件 -->
<script src="<%=ctx %>/plugins/control/js/zyFile.js"></script>
<!-- 引用控制层插件 -->
<script src="<%=ctx %>/plugins/control/js/zyUpload.js"></script>

<!-- 项目根路径 -->
<input type="hidden" id="rootPath" value="<%=ctx%>" />

