<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.*,java.util.*,javax.servlet.http.HttpSession,java.util.List,lb.ltc.entity.user.Contact,javax.servlet.http.HttpServletRequest" %>

<!-- This tile dynamically populate the table with the list of user's contact  -->
<%  //getting the session attribute list of contact
	List<Contact> contacts= (List<Contact>) session.getAttribute("listOfContacts");
 /* System.out.println("After getting session attribute");
 System.out.println("Getting email as a session attribute: "+ session.getAttribute("email"));
 System.out.println("Getting listOfContacts as a session attribute: "+ session.getAttribute("listOfContacts").toString());
 */ 
 //Testing is the list is empty
 if(contacts==null)
 {
 	System.out.println("The list is null");
 }
 else
 {
 	System.out.println("The list is NOT null");
 }
 
 %>	

<table class="ui unstackable table">
  <thead>
    <tr>
      <th>Name</th>
      <th class="right aligned">Phone Number</th>
    </tr>
  </thead>
  <tbody>
<%System.out.println("Before for each loop table.jsp");
	System.out.print("Contact is empty: ");System.out.println(contacts.isEmpty()); %>    
    <% for(Contact c:contacts) { %>
    
    <tr class="center aligned">
    
      <td><%= c.getContactName()%></td>
      <td class="right aligned"><%= c.getContactNumber()%></td>
    </tr>
    <%}%>
  </tbody>
</table>
