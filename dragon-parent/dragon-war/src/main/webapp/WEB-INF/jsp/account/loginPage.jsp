<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/meta.jsp" %>
<head>
	<!-- CSS -->
	<link rel="stylesheet" href="${ctx}/plugins/login/css/reset.css">
	<link rel="stylesheet" href="${ctx}/plugins/login/css/supersized.css">
	<link rel="stylesheet" href="${ctx}/plugins/login/css/style.css">
	<link rel="stylesheet" href="${ctx}/plugins/jNotify/jNotify.jquery.css">
</head>
<body oncontextmenu="return false">
<div class="page-container">
	<h1>用 户 登 录</h1>
	<form action="${ctx}/j_spring_security_check" method="post" id="loginForm">
		<div>
			<input type="text" name="username" class="username" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="sub" type="button">登录</button>
	</form>
	<div class="connect">
		<p>If we can only encounter each other rather than stay with each other,then I wish we had never encountered.</p>
		<p style="margin-top:20px;">如果只是遇见，不能停留，不如不遇见。</p>
	</div>
</div>

<!-- Javascript -->
<script src="${ctx}/plugins/js/jquery.min.js"></script>
<script src="${ctx}/plugins/login/js/supersized.3.2.7.min.js"></script>
<script src="${ctx}/plugins/login/js/supersized-init.js"></script>
<script src="${ctx}/plugins/jNotify/jNotify.jquery.js"></script>
<script>
	$("#sub").live('click',function(){
		var username = $(".username").val();
		var password = $(".password").val();
		if(username == '' || password == ''){
			jError('用户名或密码不能空着！',{
				autoHide : true,
				TimeShown : 1000,
				HorizontalPosition : 'center',
				VerticalPosition : 'center',
				ShowOverlay : false
			});
			return;
		}
		var url = $('#rootPath').val() + '/account/check.do';
		$.ajax({
			url : url,
			type : 'post',
			cache : false,
			async : false,
			dataType : "json",
			data:{
				username:username,
				password:password
			},
			success : function(data) {
				if(data.callBack.flag == '1'){
					alert(data.callBack.cause);
				}else{
					jSuccess('登录成功',{
						autoHide : true,
						TimeShown : 1000,
						HorizontalPosition : 'center',
						VerticalPosition : 'center',
						ShowOverlay : false
					});
					$('#loginForm').submit();
				}
			}
		});
	});
	window.onload = function() {
		$(".connect p").eq(0).animate({"left":"0%"}, 600);
		$(".connect p").eq(1).animate({"left":"0%"}, 400);
	}
</script>
</body>
</html>