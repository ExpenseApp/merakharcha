package org.merakharcha.app;


import java.util.List;

import org.merakharcha.app.api.IUserInterface;
import org.merakharcha.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Autowired
	IUserInterface userSupport;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public String showHomePage(@ModelAttribute("SpringWeb")User user, ModelMap model){
		System.out.println(user);
		int userId = userSupport.register(user);
		model.addAttribute("userId", userId);
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
	
	@RequestMapping(method=RequestMethod.GET, value="/users", headers="Accept=application/json")
	public ResponseEntity<List<User>> getUsers(){		
		return new ResponseEntity<List<User>>(userSupport.fetchAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users/{userId}", headers="Accept=application/json")
	public ResponseEntity<User> getUser(@PathVariable int userId){
		User user = userSupport.fetchUserByUserId(userId);
		if(user!=null){
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/users/{userName}", headers="Accept=application/json")
	public ResponseEntity<User> getUser(@PathVariable String userName){
		User user = userSupport.fetchUserByName(userName);
		if(user!=null){
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
	}
	

}
