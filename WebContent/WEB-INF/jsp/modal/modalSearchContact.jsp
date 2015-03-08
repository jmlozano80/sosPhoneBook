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
 	System.out.println("The fucking arraylist is null");
 }
 else
 {
 	System.out.println("The fucking arraylist is NOT null");
 }
 
 %>


<div id="modalSearchContact" class="ui  modal">
	<i class="close icon"></i>
	<div class="header">Search a Contact</div>
	<div class="content">

		<div class="description">
			
			<div style="margin-left: center;margin-right:center;" class="inline field">
					<label  style="margin-left: 30%;margin-right: 3.5%">Search by Name</label> 
				
			
			
			<div class="ui floating dropdown labeled icon button">
    <i class="filter icon"></i>
    <span class="text">Contacts</span>
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
        <%= c.getContactName()%><%="  -------->   "%><%= c.getContactNumber()%>
      </div>
      <%}%>
    </div>
  </div>
  </div>
  <br>
  <br>
  
  <div style="margin-left: center;margin-right:center;" class="inline field">
					<label  style="margin-left: 30%;margin-right: 2%;">Search by Number</label> 
				
			
			
			<div class="ui floating dropdown labeled icon button">
    <i class="filter icon"></i>
    <span class="text">Contacts</span>
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
        <%= c.getContactNumber()%><%="  -------->   "%><%= c.getContactName()%>
      </div>
      <%}%>
    </div>
  </div>
  </div>
 </div>
	</div>
	<div class="actions">
		<div class="ui black button">Close</div>
		
	</div>
</div>