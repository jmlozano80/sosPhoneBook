package lb.ltc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import lb.ltc.service.SendEmailService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * This class is the controller to send the user feedback from the modal modalContactUs.jsp by email
 * @author Jose
 *
 */

@Controller
public class SendFeedBackController 
{
	
	@Autowired
	SendEmailService sendEmailService;
	
	/**
	 * 
	 * @param json
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/sendFeedBack")
	@ResponseBody
	public String sendEmail(@RequestBody String json, HttpServletRequest request,HttpServletResponse response, HttpSession session) 
	{		
		JSONObject obtainedJsonObj = new JSONObject(json);
		JSONObject jsonObj = new JSONObject();
		
		//Getting the message to send from the JSON object passed as parameter to the method 
		final String message = obtainedJsonObj.getString("message");
		
		// This boolean will be true if the email was sent
		boolean correct=sendEmailService.sendEmail(message);
		
		//If email was sent, send back an JSON object showing the status ok 
		System.out.println("Correct = "+ correct);
		if(correct)
		{
			jsonObj.put("status", "OK");		
		}
		else
		{
			jsonObj.put("status", "BAD");
		}
		
		//return the JSON object as string with the status
		return jsonObj.toString();
	
	}//end method
	
}//end class
