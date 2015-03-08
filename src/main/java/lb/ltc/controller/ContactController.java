package lb.ltc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lb.ltc.entity.user.Contact;
import lb.ltc.service.ContactService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is the controller for processes: addContact or deleteContact
 * 
 * @author Jose
 *
 */
@Controller // defines that this class is a spring bean
public class ContactController {
	
	@Autowired // tells the application context to inject an instance of ContactService here
	private ContactService contactService;

	
/**
 * 
 * @param json from the modalAddContact.jsp containing the contactNumber and the contactName
 * @param request
 * @param response
 * @param session ( get the session attribute email)
 * @return 
 */
	@RequestMapping("/addContact")
	@ResponseBody //spring will try to convert its return value and write it to the http response automatically. 
	public String addContact(@RequestBody String json,HttpServletRequest request,HttpServletResponse response, HttpSession session) 
	{
				
		JSONObject obtainedJsonObj = new JSONObject(json);//JSON object passed as parameter
		JSONObject jsonObj = new JSONObject();
		
		//Getting the parameters from the session and the  JSON object
		final String email = (String) session.getAttribute("email");
		final String contactName=obtainedJsonObj.getString("contactName");
		final String phone = obtainedJsonObj.getString("phone");
		
		// This boolean will be true if the new contact was created
		boolean contactAdded=contactService.newContact(email, contactName, phone);
		
		//If the contact was added put into the JSON object "status""OK"
		if(contactAdded) jsonObj.put("status", "OK");
		
		//System.out.println("Contact Added: "+contactAdded+"/nThe returning JsonObject: "+jsonObj.toString());
		
		
		//Update the list of contacts when a new contact was created and set it as a session attribute
		List<Contact> listOfContacts = contactService.listOfContacts(email);
		request.getSession().setAttribute("listOfContacts", listOfContacts);
		
		//return a JSON object containing the status(added ok or not)
		return jsonObj.toString();
	
	}//end method addContact
	
	
/**
 * 	
 * @param json from the modalAddContact.jsp containing the contactNumber and the contactName
 * @param request
 * @param response
 * @param session
 * @return a JSON object as String with the status of the process(ok or not)
 */
	
	@RequestMapping("/deleteContact")
	@ResponseBody
	public String deleteContact(@RequestBody String json,HttpServletRequest request,HttpServletResponse response, HttpSession session) 
	{
				
		JSONObject obtainedJsonObj = new JSONObject(json);
		JSONObject jsonObj = new JSONObject();
			
		//Getting the parameters from the session and the  JSON object
		final String email = (String) session.getAttribute("email");
		final String contactNumber = obtainedJsonObj.getString("contactNumber");
		
		// This boolean will be true if the contact was deleted
		boolean contactDeleted=contactService.deletedContact(email, contactNumber);
		
		//If the contact was deleted put into the JSON object "status""OK"
		if(contactDeleted) jsonObj.put("status", "OK");
		
		//System.out.println("Contact Deleted: "+contactDeleted+"/nThe returning JsonObject: "+jsonObj.toString());
		
		//Update the list of contacts when a new contact was created and set it as a session attribute
		List<Contact> listOfContacts = contactService.listOfContacts(email);
		request.getSession().setAttribute("listOfContacts", listOfContacts);
		
		//return a JSON object containing the status(deleted ok or not)
		return jsonObj.toString();
	
	}//end method deleteContact
		
	
}//end class ContactController
