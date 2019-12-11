package com.retail.Controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.Exception.UserCreationException;
import com.retail.Exception.UserNotFoundException;
import com.retail.Service.UserService;
import com.retail.model.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getAll/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getAllUsers(@PathVariable Long id) {

		try {
			User user = userService.getUser(id).get();

			return ResponseEntity.ok(user);
		} catch (NoSuchElementException ex) {
			throw new UserNotFoundException("For Id: " + id);
		}
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.PUT)
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		try {
			User response = userService.addUser(user);

			return ResponseEntity.accepted().body("UserId is: " + response.getId());
		} catch (Exception ex) {
			throw new UserCreationException();
		}
	}
}
