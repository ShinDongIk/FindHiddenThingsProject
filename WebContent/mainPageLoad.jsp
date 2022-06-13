<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로딩 중</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/icons.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/loadingoverlay.min.js"></script>
</head>
<body>
	<script>
		$.LoadingOverlay("show", {
			background       : "rgba(0, 0, 0, 0.5)",
			image            : "",
			maxSize          : 60,
			fontawesome      : "fa fa-spinner fa-pulse fa-fw",
			fontawesomeColor : "#FFFFFF",
		});

		window.onload = function() {
			location.href = "mainLoad.pr?category=디지털기기"
		}
	</script>
</body>
</html>