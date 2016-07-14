<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
html, body, #map-canvas {
	width: 700px;
	height: 600px;
}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDKatYp0FgmjJy3djoAZj616misqMJxctc"></script>
<!-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script> -->
</head>
<body>
	<h2>Hello World!--GOOGLE MAPS Position</h2>
	<div id="valueLatitude"></div>
	<br>
	<div id="valueLongitude"></div>
	<br>
	<div id="map-canvas"></div>
	<script>
		//My Location
		var valLat = null;
		var valLng = null;
		var valTitle = 'Casa...22!!!';
		
		var map;
		var map_markerPosition,map_marker1,map_marker2;
		
		//-- CAR1
		var latCar1;
		var lngCar1;
		var titleCar1;
		var idCoordinateCar1="1";
		
		//-- CAR2
		var latCar2;
		var lngCar2;
		var titleCar2;
		var idCoordinateCar2="1";
		
		$(document).ready(
			function() {
				myFunctionCrom();
				valLat = -12.0285327;//position.coords["latitude"];
				valLng = -77.0924822;
				google.maps.event.addDomListener(window, 'load',initialize());
// 				if (navigator.geolocation) {
// 					navigator.geolocation.getCurrentPosition(function(
// 							position) {
// 						var locationMarker = null;
// 						if (locationMarker) {
// 							// return if there is a locationMarker bug
// 							return;
// 						}
// // 						valLat = position.coords["latitude"];
// // 						valLng = position.coords["longitude"];
// 						valLat = -12.0285327;//position.coords["latitude"];
// 						valLng = -77.0924822;//position.coords["longitude"];
// // 						alert("VALORES "+valLat+"***"+valLng);-12.107160, -77.038109
// 						$("valueLatitude").html(valLat);
// 						$("valueLongitude").html(valLng);
// 						// initialize google maps
// 						google.maps.event.addDomListener(window, 'load',initialize());
// // 						google.maps.event.addDomListener(window, 'load',addMarkerCar1());
// 					}, function(error) {
// 						console.log("Error: ", error);
// 					}, {
// 						enableHighAccuracy : true
// 					});
// 				}
		});
	
		function initialize() {
			map = new google.maps.Map(document.getElementById('map-canvas'), {
				zoom : 11,
				center : {
					lat : valLat,
					lng : valLng,
					alt : 0
				}
			});

// 			map_markerPosition = new google.maps.Marker({
// 				position : {
// 					lat : valLat,
// 					lng : valLng
// 				},
// 				map : map,
// 				title : "Posicion Actual"
// 			});
// 			map_markerPosition.setMap(map);
		}
		
		function myFunctionCrom() {
			setInterval(function() {
				ajaxMethodCar1();
// 				ajaxMethodCar2();
			}, 3000);
		}
		function ajaxMethodCar1() {
// 			var valueRequest= {"nameValue":idCoordinateCar1,"fileName":"carro1"}
			var valueRequest= {"fileName":"car1"}
			$.ajax({
				type : "POST",
				dataType : 'json',
				data : JSON.stringify(valueRequest),
				contentType: 'application/json',
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				url : "${pageContext.request.contextPath}/callgpslocation.htm",
				success : function(result) {
					if(titleCar1){
						map_marker1.setMap(null);					
					}
					latCar1=result.latValue;
					lngCar1=result.longValue;
					titleCar1 = result.title;
					google.maps.event.addDomListener(window, 'load',addMarkerCar1());
				},
				error : function(data, status, er) {
					alert("error: " + data + " status: " + status
							+ " er:" + er);
				}
			});
		}

		function ajaxMethodCar2() {
			var valueRequest= {"nameValue":idCoordinateCar1,"fileName":"carro2"}
			$.ajax({
				type : "POST",
				dataType : 'json',
				data : JSON.stringify(valueRequest),
				contentType: 'application/json',
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				url : "${pageContext.request.contextPath}/callgpslocation.htm",
				success : function(result) {
					latCar2=result.latValue;
					lngCar2=result.longValue;
// 					if(idCoordinateCar2!=1){
// 						map_marker2.setMap(null);					
// 					}
					idCoordinateCar2=result.lastId;
					titleCar2 = result.title;
					google.maps.event.addDomListener(window, 'load',addMarkerCar2());
				},
				error : function(data, status, er) {
					alert("error: " + data + " status: " + status
							+ " er:" + er);
				}
			});
		}
		
		function addMarkerCar1() {
			var image = '${pageContext.request.contextPath}/resources/img/car1.png';
			map_marker1 = new google.maps.Marker({
				position : {
					lat : parseFloat(latCar1),
					lng : parseFloat(lngCar1)
				},
				map : map,
				title : titleCar1,
				icon: image,
				draggable: true
			});
			map_marker1.setMap(map);
		}
		
		function addMarkerCar2() {
			var image = '${pageContext.request.contextPath}/resources/img/car2.png';
			map_marker2 = new google.maps.Marker({
				position : {
					lat : parseFloat(latCar2),
					lng : parseFloat(lngCar2)
				},
				map : map,
				title : titleCar2,
				draggable: true,
				icon: image
			});
			map_marker2.setMap(map);
		}
	</script>
</body>
</html>