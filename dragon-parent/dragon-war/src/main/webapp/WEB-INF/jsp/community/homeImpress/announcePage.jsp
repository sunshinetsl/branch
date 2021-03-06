<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/meta.jsp" %>
<body>
<!-- 引用初始化JS -->
<script src="<%=ctx %>/plugins/core/homeImpressUpload.js"></script>
<script type="application/javascript">
	$(document).ready(function(){
		getCity();
		getDistrict();
		$('#province').change(function(){
			getCity();
		});
		$('#city').change(function(){
			getDistrict();
		});
	});

	function getCity(){
		$('#city').html('');
		var url = $('#rootPath').val()+'/homeImpress/getCity.do';
		$.ajax({
			url : url,
			type : 'post',
			cache : false,
			async : false,
			dataType : 'json',
			data : {
				province : $('#province').val()
			},
			success : function(data){
				var str = '';
				for(var i = 0; i < data.city.length; i++){
					str += '<option id='+data.city[i].id+' value='+data.city[i].city+'>'+data.city[i].city+'</option>';
				}
				getDistrict(data.city[0].city);
				$('#city').html(str);
			},
		});
	}

	function getDistrict(city){
		$('#district').html('');
		var temp_city = '';
		if($('#city').val() == null || $('#city').val() == ''){
			temp_city = city;
		}else{
			temp_city = $('#city').val();
		}
		var url = $('#rootPath').val()+'/homeImpress/getDistrict.do';
		$.ajax({
			url : url,
			type : 'post',
			cache : false,
			async : false,
			dataType : "json",
			data:{
				province:$('#province').val(),
				city:temp_city
			},
			dataType : "json",
			success : function(data) {
				var str = '';
				for(var i = 0; i < data.district.length; i++){
					str += '<option id='+data.district[i].id+' value='+data.district[i].id+'>'+data.district[i].district+'</option>';
				}
				$('#district').html(str);
			}
		});
	}
</script>
	<form id="impressForm" method="post" action="${ctx}/homeImpress/announce.html" enctype="multipart/form-data">
		<div>
			<select id="province">省
				<c:forEach items="${province}" var="p">
					<option id="${p.id}" value="${p.province}">${p.province}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<select id="city">市</select>
		</div>
		<div>
			<select id="district" name="areaId">区</select>
		</div>
		<div><input type="text" id="theme" name="theme" value="">主题</div>
		<div>介绍</div>
		<textarea rows="" cols="" id="content" name="content"></textarea>
		<div id="demo" class="demo"></div>
		<div><input type="submit" id="sub" value="提交"></div>
	</form>
</body>
</html>