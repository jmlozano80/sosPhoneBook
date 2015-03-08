<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<%@ page import="java.text.*,java.util.*,javax.servlet.http.HttpSession,java.util.List,lb.ltc.entity.user.Contact,javax.servlet.http.HttpServletRequest" %>

<!-- <meta http-equiv="Refresh" content="5;url=logout.html"> -->
<%-- <% response.setHeader("Refresh", "5;url=index.html"); %> --%>
<div id="modalLogout" class="ui small test modal">
    <i class="close icon"></i>
    <div class="header">
      See you soon
    </div>
    <div class="content">
      <p>Thank you for using our web. </p>
    </div>
    <div class="actions">     
    </div>
  </div>

  <script> 

//js to show the modalLogut when the div id logout from sidebar is pressed
$('#logout').on('click', function(e) {
	
	$('#modalLogout').modal('show');
	
	//Redirect to logout after 3s
	var delay = 3000; //Your delay in milliseconds

setTimeout(function(){ window.location = 'logout.html'; }, delay);
	
});

  
 </script>
