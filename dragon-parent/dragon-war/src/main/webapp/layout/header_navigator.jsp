<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header_bg">
	<div class="wrap">
		<div class="header">
			<div class="logo">
				<a href="home/show"><img src="${ctx}/plugins/images/logo.png"
					alt="" /> </a>
			</div>
			<div class="social-icons">
				<ul>
					<c:if test="${empty sessionScope.userSessionInfo}">
						<li><a href="${ctx}/account/regPage.do" style="color: white;">注册</a></li>
						<li><a href="${ctx}/account/loginPage.do" style="color: white;">登录</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.userSessionInfo}">
						<li><a href="#" style="color: white;">${sessionScope.userSessionInfo.account}</a></li>
						<li><a href="${ctx}/j_spring_security_logout" style="color: white;">退出</a></li>
					</c:if>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
