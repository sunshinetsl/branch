<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
final String queryString = request.getQueryString();
final String url = request.getContextPath() + "/home/show";
response.sendRedirect(url);
%>


