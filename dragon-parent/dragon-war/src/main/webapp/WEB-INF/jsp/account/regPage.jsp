<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/meta.jsp" %>
<head>
<script>
 $(document).ready(function(){
	 $('#sub').click(function(){
		 var account = $('#account').val();
		 var passWord = $('#passWord').val();
		 var rePassWord = $('#rePassWord').val();
		 if(passWord != rePassWord){
			 alert('两次密码输入不一样');
			 return false;
		 }
		 var url = $('#rootPath').val()+'/account/reg';
		 $.ajax({
			url : url,
			type : 'post',
			cache : false,
			async : false,
			dataType : "json",
			data:{
				account:account,
				passWord:passWord,
				rePassWord:rePassWord
			},
			dataType : "json",
			success : function(data) {
				if(data.callBack.flag == 1){
					alert(data.callBack.cause);
				}else{
					alert("注册成功");
					window.location.href = $('#rootPath').val()+'/homePage.html';
				}
			}
		 });
	 });
 });
</script>
</head>
<body>
<div class="top_bg">
<div class="wrap">
	<div class="top">
		<h2>contact us</h2>
 	</div>
</div>
</div>
<!-- start main -->
<div class="wrap">
	<div class="main">
	 	 <div class="contact">				
			  <div class="contact-form">
		    	<div>
			    	<span><label>用户名</label></span>
			    	<span><input id="account" name="userDTO.account" type="text" class="textbox"></span>
			    </div>
			    <div>
			    	<span><label>密码</label></span>
			    	<span><input id="passWord" name="userDTO.passWord" type="password" class="textbox"></span>
			    </div>
			    <div>
			     	<span><label>确认密码</label></span>
			    	<span><input id="rePassWord"  name="userDTO.rePassWord" type="password" class="textbox"></span>
			    </div>
			   <div>
			   		<span><input id="sub" type="button" class="" value="提交" ></span>
			  </div>
			 </div>
			<div class="clear"> </div>		
		</div>
	</div>
</div>
</body>
</html>