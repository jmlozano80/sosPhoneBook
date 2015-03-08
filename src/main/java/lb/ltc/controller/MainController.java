package lb.ltc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This class is the controller when a user is forwarding to the main page
 * @author Jose
 *
 */

@Controller // defines that this class is a spring bean
public class MainController 
{
	/**
	 * This method checks if the user pass the authentication forward to main else to index(to login)
	 * @param request
	 * @param response
	 * @param session
	 * @return a String with the location where to forward
	 */
	@RequestMapping("/main")
	public String index(HttpServletRequest request,HttpServletResponse response, HttpSession session)
	{
		String location="main";
		//without email goes to the index page
		String email = (String) session.getAttribute("email");
		
		// if email==null the user did not authenticate and will be forwarded to the index page
		if(email == null)
		{
		 location="index";	
		}
		
		return location;
	
	}//end method index
	
}//end class
