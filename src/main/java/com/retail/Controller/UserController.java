package com.retail.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.Service.UserService;
import com.retail.model.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAll" , method = RequestMethod.GET)
	public String getAllUsers(){
		
		Iterable<User> users = userService.getAllUsers();
		
		StringBuilder sb = new StringBuilder("");
		users.forEach(user -> sb.append(user.getFirstName()+" "));
		
		return sb.toString();
	}
}
