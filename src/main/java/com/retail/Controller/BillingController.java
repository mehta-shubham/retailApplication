package com.retail.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.exception.UserNotFoundException;
import com.retail.model.BillingItems;
import com.retail.model.BillingItemsResponse;
import com.retail.model.User;
import com.retail.service.DiscountService;
import com.retail.service.UserService;

@RestController
public class BillingController {

	@Autowired
	private DiscountService discountService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/applyDiscount/{id}",method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BillingItemsResponse> applyDiscounts(@Valid @RequestBody BillingItems items,@PathVariable long id){
		
		try {
			User user = userService.getUser(id).get();
		
			BillingItemsResponse responseObject = discountService.processDiscount(items, user);
		
			return ResponseEntity.ok(responseObject);
		} catch(NoSuchElementException ex) {
			throw new UserNotFoundException("For Id: "+id);
		}
	}
}
