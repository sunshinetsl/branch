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
			<c:forEach items="${result.resultList}" var="list">
				<div class="span1_of_3">
					<c:forEach items="${list.images}" var="images" begin="0" end="0">
						<a href="${ctx}/"><img src="${rootFilePath}${images.smallImageAddress}" alt=""></a>
					</c:forEach>
					<div class="span1_of_3_text">
						<h3><a href="details.html">${list.theme}</a></h3>
						<p>${list.content}</p>
					</div>
					<div class="ser_btn">
						<a class="button  ser_btn1" href="details.html">更 多</a>
					</div>
				</div>
			</c:forEach>
			<div class="clear"></div>
		</div>
		<!-- end grids_of_3 -->
	</div>
</div>