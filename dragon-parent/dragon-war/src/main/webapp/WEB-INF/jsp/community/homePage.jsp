<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/meta.jsp" %>
<head>
<title></title>
<script type="text/javascript">
		$(function() {
			$('#da-slider').cslider({
				autoplay	: true,
				bgincrement	: 450
			});
		});
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
</head>
<body>
<div class="slider_bg">
<div class="wrap">
	<div class="slider">
				<div id="da-slider" class="da-slider">
				<div class="da-slide">
					<h2>Welcome to our website</h2>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
				</div>
				<div class="da-slide">
					<h2>Clean & Flat Design</h2>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
				</div>
				<div class="da-slide">
					<h2>Clean & Flat Design</h2>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
				</div>
				<div class="da-slide">
					<h2>Welcome to our website</h2>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
				</div>			
				<nav class="da-arrows">
					<span class="da-arrows-prev"></span>
					<span class="da-arrows-next"></span>
				</nav>
			</div>
 			<!---//End-da-slider----->
 	</div>
</div>
</div>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="ç½ç«æ¨¡æ¿">ç½ç«æ¨¡æ¿</a></div>
<!-- start main -->
<div class="wrap">
	<div class="main">
		<div class="main_text">
			<h2>Lorem Ipsum is <span>simply dummy </span> text of the printing.</h2>
			<p class="para">"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
		</div>
		<!-- start grids_of_3 -->
		<div class="grids_of_3">
			<div class="grid1_of_3">
				<img src="<%=ctx%>/plugins/images/icon1.png" alt=""/>
				<h3><a href="#">Lorem Ipsum is <span> simply </span> </a></h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
			</div>
			<div class="grid1_of_3">
				<img src="<%=ctx%>/plugins/images/icon2.png" alt=""/>
				<h3><a href="#">Lorem Ipsum is <span> simply </span> </a></h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
			</div>
			<div class="grid1_of_3">
				<img src="<%=ctx%>/plugins/images/icon3.png" alt=""/>
				<h3><a href="#">Lorem Ipsum is <span> simply </span> </a></h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
			</div>
			<div class="clear"></div>
		</div>
		<!-- end grids_of_3 -->
	</div>
</div>
<!-- start main_bg -->
<div class="main_bg">
<div class="wrap">
	<div class="main content_top">
		<!-- start span_of_3 -->
		<div class="span_of_3">
			<div class="span1_of_3">
				<a href="details.html"><img src="<%=ctx%>/plugins/images/pic1.jpg" alt=""/></a>
				<div class="span1_of_3_text">
					<h3><a href="details.html">Lorem Ipsum is simply  text</a></h3>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
				</div>
			</div>
			<div class="span1_of_3">
				<a href="details.html"><img src="<%=ctx%>/plugins/images/pic2.jpg" alt=""/></a>
				<div class="span1_of_3_text">
					<h3><a href="details.html">Lorem Ipsum is simply  text</a></h3>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
				</div>
			</div>
			<div class="span1_of_3">
				<a href="details.html"><img src="<%=ctx%>/plugins/images/pic3.jpg" alt=""/></a>
				<div class="span1_of_3_text">
					<h3><a href="details.html">Lorem Ipsum is simply  text</a></h3>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<!--  -->
		<div class="span_of_3">
			<div class="span1_of_3">
				<a href="details.html"><img src="<%=ctx%>/plugins/images/pic4.jpg" alt=""/></a>
				<div class="span1_of_3_text">
					<h3><a href="details.html">Lorem Ipsum is simply  text</a></h3>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
				</div>
			</div>
			<div class="span1_of_3">
				<a href="details.html"><img src="<%=ctx%>/plugins/images/pic5.jpg" alt=""/></a>
				<div class="span1_of_3_text">
					<h3><a href="details.html">Lorem Ipsum is simply  text</a></h3>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
				</div>
			</div>
			<div class="span1_of_3">
				<a href="details.html"><img src="<%=ctx%>/plugins/images/pic6.jpg" alt=""/></a>
				<div class="span1_of_3_text">
					<h3><a href="details.html">Lorem Ipsum is simply  text</a></h3>
					<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<!-- end grids_of_3 -->
	</div>
</div>
</div>
<div class="wrap">
		<ul id="flexiselDemo3">
			<li><img src="<%=ctx%>/plugins/images/client1.jpg" /></li>
			<li><img src="<%=ctx%>/plugins/images/client6.jpg" /></li>
			<li><img src="<%=ctx%>/plugins/images/client2.jpg" /></li>
			<li><img src="<%=ctx%>/plugins/images/client5.jpg" /></li>
			<li><img src="<%=ctx%>/plugins/images/client4.jpg" /></li>
			<li><img src="<%=ctx%>/plugins/images/client3.jpg" /></li>
			<li><img src="<%=ctx%>/plugins/images/client4.jpg" /></li>
		</ul>
	<script type="text/javascript">
$(window).load(function() {
	$("#flexiselDemo1").flexisel();
	$("#flexiselDemo2").flexisel({
		enableResponsiveBreakpoints: true,
    	responsiveBreakpoints: { 
    		portrait: { 
    			changePoint:480,
    			visibleItems: 1
    		}, 
    		landscape: { 
    			changePoint:640,
    			visibleItems: 2
    		},
    		tablet: { 
    			changePoint:768,
    			visibleItems: 3
    		}
    	}
    });

	$("#flexiselDemo3").flexisel({
		visibleItems: 5,
		animationSpeed: 1000,
		autoPlay: true,
		autoPlaySpeed: 3000,    		
		pauseOnHover: true,
		enableResponsiveBreakpoints: true,
    	responsiveBreakpoints: { 
    		portrait: { 
    			changePoint:480,
    			visibleItems: 1
    		}, 
    		landscape: { 
    			changePoint:640,
    			visibleItems: 2
    		},
    		tablet: { 
    			changePoint:768,
    			visibleItems: 3
    		}
    	}
    });
    
});
</script>
<script type="text/javascript" src="<%=ctx%>/plugins/js/jquery.flexisel.js"></script>
</div>
</body>
</html>