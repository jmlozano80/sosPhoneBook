<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="modal" id="modalRecoverPassword" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="false">&times;</button>
				<h3 class="modal-title" id="myModalLabel">Recover Password</h3>
			</div>

			<div class="modal-body row">
				<div class="col-md-7">
					<form id="recoverPasswordForm" accept-charset="UTF-8"
						data-remote="true" method="post" name="modal-form"
						class="form-horizontal">

						<!-- form stuff goes here -->
						<div id="emailError" class="form-group">
							<div class="col-xs-8">
								<font color="#C11B17">
									<p id="emailErrorP">&nbsp;</p>
								</font>
							</div>
							<div class="col-xs-8">
								<input type="email" class="form-control" name="email" id="email"
									value="" placeholder="Email" /> <span id="emailErrorSpan"></span>
							</div>
						</div>

						<div id="passwordError" class="form-group">

							<!-- <div class="col-xs-8">
								<input type="password" class="form-control" id="password"
									name="password" value="" placeholder="Password" /> <span
									id="passwordErrorSpan"></span>
							</div> -->
						</div>




						<!-- <div class="form-group has-error has-feedback">
						<input type="text" class="form-control" id="inputError2">
						<span class="glyphicon glyphicon-remove form-control-feedback"></span>
					</div> -->
					</form>
				</div>

				<div class="col-md-5">
					<p>&nbsp;</p>
					<font id="passwordPolicyFont" size="1%"><p>
							You will receive an email <br>
							with the instruction about how to<br>
							 recover your password
						</p></font>
				</div>



			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					Close</button>
				<button id="recoverPasswordBtn" type="submit"
					class="btn btn-primary" id="save">Proceed</button>

				

			</div>

			<script>
				$('#recoverPasswordBtn').on('click', function(e) {
					// We don't want this to act as a link so cancel the link action
					e.preventDefault();

					// Find form and submit it
					$('#recoverPasswordForm').submit();
				});

				// Since we want both pressing 'Enter' and clicking the button to work
				// We'll subscribe to the submit event, which is triggered by both

				$('#recoverPasswordForm')
						.on(
								'submit',
								function() {
									//Serialize the form and post it to the server

									$
											.post(
													"userRegistration",
													$(this).serialize(),
													function(text) {

														var parsedJSON = $
																.parseJSON(text);
														/* var obj = JSON.parse(text); */

														var success = parsedJSON.success;

														if (success == "fail") {
															var failReason = parsedJSON.failReason;
															alert(failReason);
															if (failReason == "emailRegex") {
																document
																		.getElementById("emailError").className = "form-group has-error has-feedback";
																document
																		.getElementById("emailErrorSpan").className = "glyphicon glyphicon-remove form-control-feedback";

																/* Set the password field as not validated yet */
																document
																		.getElementById("passwordError").className = "form-group";
																document
																		.getElementById("passwordErrorSpan").className = "";
																$(
																		"p#emailErrorP")
																		.text(
																				'Wrong email format.');
															}  					
														} else { // Success
															alert('Email Sent');
															/* var user = document
																	.getElementById("user").value; */
															// Hide the modal
															$("#modalRecoverPassword")
																	.modal(
																			'hide');
															setTimeout(
																	function() {
																		window.location.href = 'main.html';
																	}, 20);
														}
													});

									// Stop the normal form submission
									return false;
								});
			</script>

			