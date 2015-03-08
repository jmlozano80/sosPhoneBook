package lb.ltc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is only in use when the app starts
 * @author Jose
 *
 */

@Controller // defines that this class is a spring bean
public class IndexController 
{
	/**
	 * This method will be call when the app starts
	 * @return the index page
	 */
	@RequestMapping("/index")
	public String index() 
	{
		System.out.println("INSIDE INDEX CONTROLLER");
		return "index";
		
	}//end method index

}//end class