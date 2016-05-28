package org.merakharcha.app;


import org.merakharcha.app.model.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class AppController {
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public String showHomePage(@ModelAttribute("SpringWeb")User user, ModelMap model){
		System.out.println(user);
		model.addAttribute("userName", user.getUserName());
		return "UserRegistered";
	} 
	

}
