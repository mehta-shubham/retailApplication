package com.retail.Controller;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.Service.UserService;
import com.retail.model.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAll/{id}" , method = RequestMethod.GET)
	public String getAllUsers(@PathVariable Long id){
		
		User user = userService.getUser(id).get();
		
		StringBuilder sb = new StringBuilder("");
		sb.append(user.getFirstName());
		sb.append(" \n");
		sb.append(user.getCreatedAt().toLocalDate());
		
		return sb.toString();
	}
}
