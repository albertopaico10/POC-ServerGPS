<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
#map {
	width: 700px;
	height: 600px;
	background-color: #CCC;
}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<h2>Hello World!--GOOGLE MAPS</h2>
	<br>
	<div id="map"></div>
	<script>
		var valLat = null;
		var valLng = null;
		var valTitle = null;
		
		$(document).ready(function(){
// 			ajaxMethod();
		});
		
// 		var valLat = '';
// 		var valLng = '';
// 		var valTitle = '';
		var valLat = -12.028324;
		var valLng = -77.092464;
		var valTitle = 'Casa...22!!!';
// 		var myLatlng = null;
		function ajaxMethod() {
			alert("HOLAAAA");
			$.ajax({
				type:"POST",
				dataType: 'json', 
				data: "{\"nameValue\":\"1\"}",
// 				contentType: 'application/json',
// 			    mimeType: 'application/json',
			    headers: {
		            Accept: "application/json; charset=utf-8",
		            "Content-Type": "application/json; charset=utf-8"
		        },
		        url : "${pageContext.request.contextPath}/callgpslocation.htm",
			    success: function(result) {
// 			    	myLatlng=new google.maps.LatLng(parseFloat(result.latValu),parseFloat(result.longValue));
// 					valLat=parseFloat(result.latValu);
// 					valLng=parseFloat(result.longValue);
					valTitle=result.title;
					alert("CORRECTO");
			    },
			    error:function(data,status,er) { 
			        alert("error: "+data+" status: "+status+" er:"+er);
			    }
			});
		}

		function initMap() {
			ajaxMethod();
			var myLatlng = {
				lat : valLat,
				lng : valLng
			};

			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 16,
				center : myLatlng
			});

			var marker = new google.maps.Marker({
				position : myLatlng,
				map : map,
				title : valTitle
			});
		}
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?callback=initMap"
		async defer></script>
</body>
</html>