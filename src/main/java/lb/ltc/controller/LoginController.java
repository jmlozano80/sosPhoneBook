package lb.ltc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lb.ltc.entity.user.Contact;
import lb.ltc.service.ContactService;
import lb.ltc.service.LoginService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is the controller for login authentication
 * @author Jose
 *
 */

@Controller// defines that this class is a spring bean
public class LoginController
{
	@Autowired // tells the application context to inject an instance of loginService here
	LoginService loginService;
	
	@Autowired // tells the application context to inject an instance of ContactService here
	private ContactService contactService;
	
	/**
	 * 
	 * @param json
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody //spring will try to convert its return value and write it to the http response automatically
	public String login(@RequestBody String json, HttpServletRequest request,HttpServletResponse response, HttpSession session) 
	{
		System.out.println("INSIDE LOGIN CONTROLLER");
		JSONObject obtainedJsonObj = new JSONObject(json);//JSON object passed as parameter
		JSONObject jsonObj = new JSONObject();
		
		//Getting the parameters from the session and the  JSON object
		final String email = obtainedJsonObj.getString("email");
		final String password = obtainedJsonObj.getString("password"); 
		
		// This boolean will be true if the user was authenticated
		boolean correct=loginService.authenticateUser(email, password);
		
		//If credentials are OK send back an JSon object showing the status ok and sets email and lisOfContacts as session attributes
		if(correct)
		{
			jsonObj.put("status", "OK");
			session.setAttribute("email", email);
	
			//Get the list of contacts and set it as a session attribute	
			List<Contact> listOfContacts = contactService.listOfContacts(email);
			request.getSession().setAttribute("listOfContacts", listOfContacts);
		
		}
		
		//return a JSON object containing the status(authenticated ok or not)
		return jsonObj.toString();
	
	}//end method login
	
	
}//end class loginController
