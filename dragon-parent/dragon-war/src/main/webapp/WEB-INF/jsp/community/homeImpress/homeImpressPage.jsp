<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/meta.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$('#homeUp').click(function(){
		window.location.href = $('#rootPath').val()+'/homeImpress/announcePage.html';
	});
});
</script>
<div>
	<div style="float: right;"><input type="button" id="homeUp" value="发布我的家乡"/></div>
</div>
<!-- start main -->
<div class="wrap">
<div class="main">
		<!-- start span_of_3 -->
		<div class="span_of_3">
			<div class="span1_of_3">
				<a href="details.html"><img src="${ctx}/plugins/images/pic1.jpg" alt=""></a>
				<div class="span1_of_3_text">
					<h3><a href="details.html">Lorem Ipsum is simply  text</a></h3>
					<p>Lorem Ipsum is simply sit amet consectetur dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.</p>
				</div>
				<div class="ser_btn">
					<a class="button  ser_btn1" href="details.html">read more</a>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<!-- end grids_of_3 -->
	</div>
</div>
