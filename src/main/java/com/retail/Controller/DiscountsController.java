package com.retail.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.model.User;

@RestController
public class DiscountsController {

	@RequestMapping("/")
	public String heathCheck() {
		return "ok";
	}
	
	@RequestMapping("/printUser")
	public String printUser(@RequestBody User user) {
		return user.toString();
	}
}
