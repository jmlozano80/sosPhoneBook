<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<div id="modalCountryCodes" class="ui  modal">
	<i class="close icon"></i>
	<div class="header">Country Phone Code</div>
	<div class="content">

		<div class="description">
			<div class="ui form">
				
				<tiles:insertAttribute name="flags" />
				

			</div>
		</div>
	</div>
	<div class="actions">
		<div class="ui black button">Close</div>
		
	</div>
</div>