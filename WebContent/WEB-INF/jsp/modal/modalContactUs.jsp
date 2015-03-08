<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
  <!DOCTYPE html>  
    <div id="modalContactUs"class="ui fullscreen modal">
    <i class="close icon"></i>
    <div class="header">
      Thanks for contact us<i style="margin-left: 2% " class="write icon"></i>
    </div>
    <div class="content">
      <div  class="ui form">
        <h4 class="ui dividing header">Give us your feedback</h4>
        <div class="field">
          <label>Feedback</label>
          <textarea id="txtArea"></textarea>
        </div>
        <div class="field">
          <div class="ui checkbox">
            <input id="checkbox" type="checkbox" checked="checked" name="contact-me">
            <label>It's okay to contact me.</label>
          </div>
        </div>
      </div>
    </div>
    <div class="actions">
      <div class="ui button">Cancel</div>
      <div id="sendBtn"class="ui green button">Send</div>
    </div>
  </div>
   <script>
   
/*    $('#checkbox').on('click', function(e) {
		 {
 					if (checked == 0) {
							$( "#checkbox" ).prop( "checked", true );
						} 
  	
						$( "#checkbox" ).prop( "checked", true );
					}
 
   
 					});   */
   
   
 
// Uncheck #x

/* JQuery to check if the fields are completed and if the phonenumber are numerical */
$('#sendBtn').on('click', function(e) {
		var message =$("#txtArea").val();	
		//alert("btn message"+message);
    if (message == "" ) {
  //Check if phone is numeric
  	alert("The txt Area is empty,please write something");
	
}
 
else{
/*  Post to send the email a new contact*/
			
										

									$
											.ajax({
													
												type : "POST",
												url : "sendFeedBack.html",
												data : JSON.stringify({
													"message" : message,
													
												}),
												contentType : "application/json; charset=UTF-8",
												success : function(data) {
													
													var parsedDataJSON = $
															.parseJSON(data);
																									
													if (parsedDataJSON.status == "OK") {	
														alert('Message Sent !');
													setTimeout(														
													function() {
																		window.location.href = 'main.html';
																	}, 20);

													} else
														alert('Your Message was sent');
												},
												error : function() {
													alert('Error occured!');
												}
											});
								}											
								});


   </script>