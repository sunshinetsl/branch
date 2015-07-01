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
	<form action="${ctx}/j_spring_security_check" method="post" id="regForm">
		<div>
			<input type="text" name="j_username" class="username" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="j_password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" name="j_repassword" class="repassword" placeholder="确认密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="text" name="captcha" class="captcha" placeholder="验证码" oncontextmenu="return false" onpaste="return false" style="width: 120px;float: left;"/>
			<img class="capimg" id="reg_captcha" src="${ctx}/kaptcha.jpg" style="width:150px;margin: 28px auto 0 auto;">
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
		var captcha = $('.captcha').val();
		var repassword = $('.repassword').val();
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
		if(captcha == ''){
			jError('请输入验证码！',{
				autoHide : true,
				TimeShown : 1000,
				HorizontalPosition : 'center',
				VerticalPosition : 'center',
				ShowOverlay : false
			});
			return;
		}
		if(password != repassword){
			jError('两次密码不一样！',{
				autoHide : true,
				TimeShown : 1000,
				HorizontalPosition : 'center',
				VerticalPosition : 'center',
				ShowOverlay : false
			});
			return;
		}
		var url = $('#rootPath').val() + '/account/reg.do';
		$.ajax({
			url : url,
			type : 'post',
			cache : false,
			async : false,
			dataType : "json",
			data:{
				account : username,
				passWord : password,
				rePassWord : repassword,
				captcha  : captcha
			},
			success : function(data) {
				if(data.callBack.flag == '1'){
					jError(''+data.callBack.cause+'！',{
						autoHide : true,
						TimeShown : 1000,
						HorizontalPosition : 'center',
						VerticalPosition : 'center',
						ShowOverlay : false
					});
					return;
				}else{
					jSuccess('登录成功',{
						autoHide : true,
						TimeShown : 1000,
						HorizontalPosition : 'center',
						VerticalPosition : 'center',
						ShowOverlay : false
					});
					$('#regForm').submit();
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