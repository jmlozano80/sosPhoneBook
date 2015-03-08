package lb.ltc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LogoutController
{
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		System.out.println("INSIDE LOGOUT CONTROLLER");
		session.invalidate();
		
		return "index";
	}
	
}
