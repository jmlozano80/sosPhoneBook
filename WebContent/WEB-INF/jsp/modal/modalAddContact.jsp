<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<div id="modalAddContact" class="ui  modal">
	<i class="close icon"></i>
	<div class="header">  Add Contact<i style="margin-left: 2% " class="user add icon"></i>
	</div>	<div class="content">

		<div class="description">
			<div class="ui form">
				<div style="margin-left: auto;margin-right: auto" class="inline field">

					<label style="margin-left: 30%;margin-right: auto">Contact Name</label> <input id="contactName" 
						type="text" placeholder="Contact Name" required>
				</div>
				
				<div style="margin-left: center;margin-right:center;" class="inline field">
					<label style="margin-left: 30%;margin-right: auto">Phone Number</label> <input id="contactNumber" 
						type="text" placeholder="Phone number" required>
				</div>

			</div>
		</div>
	</div>
	<div class="actions">
		<div class="ui black button">Cancel</div>
		<div id="submitAddContact"
			class="ui positive right labeled icon button">
			Add Contact <i class="checkmark icon"></i>
		</div>
	</div>
</div>
<!-- <script>






	$('#submitAddContact').on('click', function(e) {
		var contactName =$("#contactName").val();	
		var phone = $("#contactNumber").val();
    if (phone !== "" && !$.isNumeric(phone)) {
  //Check if phone is numeric
  	alert("the number must contains only digits");

}
 if (phone==""||contactName=="") {
  //Check if phone is numeric
  	alert("Remember to complete all the fields");

}
		$
								.post(
										"addContact.html",
										{contactName:document.getElementById('contactName').value,contactNumber:document.getElementById('contactNumber').value,submit:true},
										function(text) {

											var parsedJSON = $.parseJSON(text);
											/* var obj = JSON.parse(text); */

											var success = parsedJSON.success;

											if (success == "fail") {
												var failReason = parsedJSON.failReason;
												alert(failReason);
												if (failReason == "emailRegex") {
												
												} else if (failReason == "passwordRegex") {

												} else if (failReason == "emailExists") {
													
												}
											} else { // Success
												alert('Contact Added');
												/* var user = document
														.getElementById("user").value; */
												// Hide the modal
												/* $("#modalAddContact").modal('hide');
												setTimeout(
														function() {
															window.location.href = 'main.html';
														}, 20); */
											}
										});
	});

</script> -->


<script>


/*script to close the modal only when the close button is pressed (NO Working) */
$('.modal')
  .modal({
    selector: { 
      close: 'icon.close'
    } 
  })
;



/* JQuery to check if the fields are completed and if the phonenumber are numerical */
$('#submitAddContact').on('click', function(e) {
		var contactName =$("#contactName").val();	
		var phone = $("#contactNumber").val();
    if (phone !== "" && !$.isNumeric(phone)) {
  //Check if phone is numeric
  	alert("the number must contains only digits");

}
 if (phone==""||contactName=="") {
  //Check if phone is numeric
  	alert("Remember to complete all the fields");

}








/*  Post to add a new contact*/



										

									$
											.ajax({
													
												type : "POST",
												url : "addContact.html",
												data : JSON.stringify({
													"contactName" : contactName,
													"phone" : phone
												}),
												contentType : "application/json; charset=UTF-8",
												success : function(data) {
													
													var parsedDataJSON = $
															.parseJSON(data);
																									
													if (parsedDataJSON.status == "OK") {	
														alert('Contact Created!');
													setTimeout(														
													function() {
																		window.location.href = 'main.html';
																	}, 20);

													} else
														alert('A contact with the same number was already created');
												},
												error : function() {
													alert('Error occured!');
												}
											});
											
								});
</script>