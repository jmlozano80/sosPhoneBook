<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

<head>
<link rel="shortcut icon" href="/test3/images/favicon.ico">
<link rel="stylesheet" href="/test3/semantic-ui/semantic.css">
<link rel="stylesheet" href="/test3/semantic-ui/semantic.min.css">
<link rel="stylesheet" href="/test3/semantic-ui/components/button.css">
<link rel="stylesheet" href="/test3/semantic-ui/components/flag.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SOS PhoneBook</title>
</head>
<body>


	<script src="/test3/js/jquery-2.1.1.min.js"></script>
	<script src="/test3/semantic-ui/semantic.js"></script>

	<tiles:insertAttribute name="body" />
	
	<img style="margin-top:5%;margin-left:32%;width:20%;height:20%%;"  src="/test3/images/sos-phonebook.jpg">

<img style="margin-top:5%;margin-left:32%;width:20%;height:20%%;" class="ui avatar image" src="/test3/images/sos-phonebook-black.png">
	
<img style="margin-top:5%;margin-left:32%;width:20%;height:20%%;" class="ui avatar image" src="/test3/images/sos-phonebook-greyRing.png">
	
	<div style="margin-top: 5%; margin-left: auto;
    margin-right: auto; width: 45%">
		<tiles:insertAttribute name="table" />
	</div>


	
		
	
	<!-- Insert the tiles( fragments which can be assembled into a complete pages at runtime)  -->
	<tiles:insertAttribute name="modalAddContact" />
	<tiles:insertAttribute name="modalDeleteContact" />
	<tiles:insertAttribute name="modalContactUs" />
	<tiles:insertAttribute name="modalAboutUs" />
	<tiles:insertAttribute name="modalCountryCodes" />
	<tiles:insertAttribute name="modalWebCall" />
	<tiles:insertAttribute name="modalSearchContact" />
	<tiles:insertAttribute name="modalLogout" />
	
	<script> 
	
	
	
	$('#searchContact').on('click', function(e) {
			alert('Search')
			$('#modalSearchContact').modal('show');
			

		});
	
	
	
	$('#webCall').on('click', function(e) {
			alert('WEBCALL')
			$('#modalWebCall').modal('show');
			

		});
		$('.ui.dropdown').dropdown();
		$('#addContact').on('click', function(e) {
			alert('addContact');
			$('#modalAddContact').modal('show');

		});
		
		
		$('#contactUs').on('click', function(e) {
			alert('contactUs');
			$('#modalContactUs').modal('show');

		});
		
		$('#countryCodes').on('click', function(e) {
			alert('countrycodes');
			$('#modalCountryCodes').modal('show');

		});	

/* $('#deleteContact').on('click', function(e) {
	alert('deleteContact');
	$('#modalDeleteContact').modal('show');
	
}); */
	</script>

 
</body>
</html>