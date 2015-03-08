<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<%@ page import="java.text.*,java.util.*,javax.servlet.http.HttpSession,java.util.List,lb.ltc.entity.user.Contact,javax.servlet.http.HttpServletRequest" %>

<%System.out.println("Before getting the session attribute");
	List<Contact> contacts= (List<Contact>) session.getAttribute("listOfContacts");
 System.out.println("After getting session attribute");
 System.out.println("Getting email as a session attribute: "+ session.getAttribute("email"));
 System.out.println("Getting listOfContacts as a session attribute: "+ session.getAttribute("listOfContacts").toString());
 
 if(contacts==null)
 {
 	System.out.println("The list is null");
 }
 else
 {
 	System.out.println("The list is NOT null");
 }
 
 %>

<div id="modalDeleteContact" class="ui small test modal">
    <i class="close icon"></i>
    <div class="header">
      Delete Contact
    </div>
    <div class="content">
      <p>Please, select the contact to delete </p>
      	<div id="item1"class="ui floating dropdown labeled icon button">
    <i class="filter icon"></i>
    
    <span id="contactName" class="text">Contacts</span>
    <div class="menu">
      <div class="ui icon search input">
        <i class="search icon"></i>
        <input name="search" placeholder="Search ..." type="text">
      </div>
      <div class="divider"></div>
      <div class="header">
        <i class="tags icon"></i>
        Contacts
      </div>
      <% for(Contact c:contacts) { %>
      <div class="item">
        <div class="ui red empty circular label"></div>
        <%= c.getContactName()%><%="-------->"%><%= c.getContactNumber()%>
      </div>
      <%}%>
    </div>
  </div>
    </div>
    <div class="actions">
      <div class="ui negative button">
        No
      </div>
      <div id="yesDeleteContact"class="ui positive right labeled icon button">
        Yes
        <i class="checkmark icon"></i>
      </div>
    </div>
  </div>

  <script> 
	
	/* 	$('.ui.dropdown').dropdown();
		$('#addContact').on('click', function(e) {
			alert('addContact');
			$('#modalAddContact').modal('show');

		}); */
		
		

//js to show the modalDeleteContact when the div id deleteContact from sidebar is pressed
$('#deleteContact').on('click', function(e) {
	
	$('#modalDeleteContact').modal('show');
	
});




/* JQuery to check if the fields are completed and if the phonenumber are numerical */
$('#yesDeleteContact').on('click', function(e) {
		
		var contactNameNoSplit = document.getElementsByTagName('span')[0].innerHTML;
		//alert(span_Text);
		var splitContactName = contactNameNoSplit.split("gt;");
		var contactNumber = splitContactName[1];
		
		
    if (contactNumber=="Contact"||contactNumber==null) {
  //Check if phone is numeric
  	alert("No contact was selected");
  	return;

}

 else{
  //Check if phone is numeric
  	alert("contactNumber: " +contactNumber);


/*  Post to delete a contact*/
										

									$
											.ajax({
													
												type : "POST",
												url : "deleteContact.html",
												data : JSON.stringify({
													"contactNumber" : contactNumber,
													
												}),
												contentType : "application/json; charset=UTF-8",
												success : function(data) {
													
													var parsedDataJSON = $
															.parseJSON(data);
																									
													if (parsedDataJSON.status == "OK") {	
														alert('Contact Deleted!');
													setTimeout(														
													function() {
																		window.location.href = 'main.html';
																	}, 20);

													} else
														alert('A contact with the same number was already created');
												},
												
											});
											
}								});

	</script>
