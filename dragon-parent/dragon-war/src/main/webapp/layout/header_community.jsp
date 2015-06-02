<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
</head>
<body>
	<div class="header_btm">
		<div class="wrap">
			<div class="header_sub">
				<div class="h_menu">
					<ul>
						<li class="active"><a href="home/show">主页</a></li>
						<li><a href="about/page">关于我们</a></li>
						<li><a href="jsp/demo/service.html">服务</a></li>
						<li><a href="jsp/demo/index.html">页面</a></li>
						<li><a href="jsp/demo/blog.html">论坛</a></li>
						<li><a href="jsp/demo/contact.html">加入我们</a></li>
					</ul>
				</div>
				<div class="h_search">
					<form>
						<input type="text" value="" placeholder="search something...">
						<input type="submit" value="">
					</form>
				</div>
				<div class="menu">
					<ul>
						<li class="active"><a href="jsp/demo/index.html">Home</a></li>
						<li><a href="jsp/demo/about.html">About us</a></li>
						<li><a href="jsp/demo/service.html">Service</a></li>
						<li><a href="jsp/demo/index.html">Pages</a></li>
						<li><a href="jsp/demo/blog.html">Blog</a></li>
						<li><a href="jsp/demo/contact.html">Contact us</a></li>
					</ul>
				</div>
				<div class="search">
					<form action="/iphone/search.html">
						<input type="text" value="Search" onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = 'Search';}"
							class="text">
					</form>
				</div>
				<div class="sub-head">
					<ul>
						<li><a href="#" id="menu">Menu <span></span></a></li>
						<li><a href="#" id="search">Search <span></span></a></li>
					</ul>
					<div class="clear"></div>
				</div>
				<script type="text/javascript">
		$(".menu,.search").hide();
		$("#menu").click(function(){
			$(".menu").toggle();
			$(".search").hide();
			$("#search").removeClass("active");
			$("#menu").toggleClass("active");
		});
		$("#search").click(function(){
			$(".search").toggle();
			$(".menu").hide();
			$("#menu").removeClass("active");
			$("#search").toggleClass("active");
			$(".text").focus();
		});
	</script>
				<script type="text/javascript" src="../plugins/js/script.js"></script>
				<div class="clear"></div>

				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>