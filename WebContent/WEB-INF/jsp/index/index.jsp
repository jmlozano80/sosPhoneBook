<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->

<link rel="shortcut icon" href="/test3/images/favicon.ico">
 <link rel="stylesheet" href="/test3/css/bootstrap.min.css">
 <link rel="stylesheet" href="/test3/semantic-ui/semantic.css">
<link rel="stylesheet" href="/test3/semantic-ui/semantic.css">
<link rel="stylesheet" href="/test3/semantic-ui/semantic.min.css">
<link rel="stylesheet" href="/test3/semantic-ui/components/button.css">


<!-- Optional theme -->
<link rel="stylesheet" href="/test3/css/bootstrap-theme.min.css">
<!-- Text Animation stylesheet -->
<!-- <link rel="stylesheet" href="/test3/css/animationText.css">
 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>

</head>
<body>
	<!-- Latest compiled and minified JavaScript -->

	<script src="/test3/js/jquery-2.1.1.min.js"></script>
	
	<script src="/test3/semantic-ui/semantic.js"></script>
	<script
		src="/test3/js/bootstrap.js"></script>
	
	<!-- Insert the tiles( fragments which can be assembled into a complete pages at runtime)  -->

	<tiles:insertAttribute name="modalRegistration"></tiles:insertAttribute>
	
	<%-- <tiles:insertAttribute name="modalRecoverPassword" /> --%>
	
	<tiles:insertAttribute name="header" />

	 <tiles:insertAttribute name="body" />  

	<!-- End insertion tiles  -->
	
	
	<br>
	<br>
	
</body>
</html>