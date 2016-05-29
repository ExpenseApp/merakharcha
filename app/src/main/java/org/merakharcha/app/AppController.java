package org.merakharcha.app;


import org.merakharcha.app.api.IUserInterface;
import org.merakharcha.app.api.impl.UserInterfaceImpl;
import org.merakharcha.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class AppController {
	
	@Autowired
	IUserInterface userSupport;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public String showHomePage(@ModelAttribute("SpringWeb")User user, ModelMap model){
		System.out.println(user);
		model.addAttribute("userName", user.getUserName());
		return "UserRegistered";
	} 
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String login(@ModelAttribute("SpringWeb")User user, ModelMap model){
		System.out.println(user);
		if(userSupport.login(user)){
			model.addAttribute("userName", user.getUserName());
			return "welcome";
		}
		model.addAttribute("invalidLogin", user.getUserName());
		return "invalidLogin";
	} 
	

}
