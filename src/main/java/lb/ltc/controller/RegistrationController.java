package lb.ltc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lb.ltc.service.RegistrationService;
import lb.ltc.validator.EmailValidator;
import lb.ltc.validator.PasswordValidator;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is the controller for processes: registration and validateRegistration
 * @author Jose
 *
 */

@Controller // defines that this class is a spring bean
public class RegistrationController
{
	
	private String success = "";
	private String failReason;
	
	@Autowired // tells the application context to inject an instance of RegistrationService here
	private RegistrationService registrationService;

	/**
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	@RequestMapping("/userRegistration")
	public void registration(HttpServletRequest request,HttpServletResponse response, HttpSession session)
	{
		//System.out.println("Index Controller: registration() method");
		
		
		JSONObject jsonObj = new JSONObject();
		
		//Getting the parameters from the registration request
		final String email = request.getParameter("email");
		final String password = request.getParameter("password");
		
		//Added  to test if we can set email as session parameter
		session.setAttribute("email",email);
		
		
		
		/*Registration validation*/
		EmailValidator emailValidator = new EmailValidator();
		boolean emailValidated = emailValidator.validate(email);
		PasswordValidator passwordValidator = new PasswordValidator();
		boolean passwordValidated = passwordValidator.validate(password);
		System.out.println(email + " validated = " + emailValidated);
		
		if (emailValidated && passwordValidated) 
		{
			postValidationRegistration(email, password, session);
			
		}
		else if (!emailValidated) 
		{
			success = "fail";
			failReason = "emailRegex";
			/*jsonObj.put("success", "fail");
			jsonObj.put("failReason", "emailRegex");*/
		}
		else if (!passwordValidated) 
		{
			/*jsonObj.put("success", "fail");
			jsonObj.put("failReason", "passwordRegex");*/
			success = "fail";
			failReason = "passwordRegex";
		}
		
		
		response.setContentType("text/html");
		try 
		{
			//Writting in a JSON object that the registration was ok
			PrintWriter out = response.getWriter();
			jsonObj.put("success", success);
			
			request.setAttribute("forwardedFrom", "registration");
			
			if (failReason != null) jsonObj.put("failReason", failReason);
			out.print(jsonObj);
			out.close();
		}
		catch (IOException e)
		{
			System.out.println("PrintWriter exception... " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
	} // end method registration
	
	
	/**
	 * This method validates the registration
	 * @param email
	 * @param password
	 * @param session
	 */
	private void postValidationRegistration(final String email, final String password, HttpSession session) 
	{
		boolean emailExists = registrationService.emailExists(email);
		if (!emailExists) 
		{
			// Create a new user return true if the user was created
			boolean userCreated = registrationService.newUser(email, password);
			if (userCreated) 
			{
				//System.out.println("NEW USER CREATED!!!!!!");
				session.setAttribute("email", email);
				success = "success";
				
			} 
			else 
			{
				//System.out.println("USER WASNT CREATED :((((((((");
				/*jsonObj.put("success", "fail");
				jsonObj.put("failReason", "emailTaken");*/
				success = "fail";
				failReason = "dbError";
			}
		} 
		else 
		{ // Email exists
			/*jsonObj.put("success", "fail");
			jsonObj.put("failReason", "emailTaken");*/
			success = "fail";
			failReason = "emailExists";
		}
		
	}//end method
	
}//end class
