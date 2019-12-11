package com.retail.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.Exception.UserNotFoundException;
import com.retail.Service.DiscountService;
import com.retail.Service.UserService;
import com.retail.model.BillingItems;
import com.retail.model.BillingItemsResponse;
import com.retail.model.Groceries;
import com.retail.model.Item;
import com.retail.model.User;

@RestController
public class BillingController {

	@Autowired
	private DiscountService discountService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/applyDiscount/{id}",method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BillingItemsResponse> applyDiscounts(@Valid @RequestBody BillingItems items,@PathVariable long id){
		
		try {
			items.getGroceries().getGroceriesList().forEach(i -> System.out.println(i.getName()));
			items.getItemsList().forEach(i -> System.out.println(i.getName()));
		
			User user = userService.getUser(id).get();
		
			BillingItemsResponse responseObject = discountService.processDiscount(items, user);
		
			return ResponseEntity.ok(responseObject);
		} catch(NoSuchElementException ex) {
			throw new UserNotFoundException("For Id: "+id);
		}
	}

	@RequestMapping(value = "/getList", method = RequestMethod.GET, produces = "application/json")
	public BillingItems getList() {
		Item item1 = new Item("facewash", 30);
		Item item2 = new Item("soap", 20);
		Item item3 = new Item("Mango", 10);
		Item item4 = new Item("Orange", 40);
		Item item5 = new Item("Banana", 10);

		List<Item> groceriesList = new ArrayList<Item>();
		groceriesList.add(item3);
		groceriesList.add(item4);
		groceriesList.add(item5);

		Groceries grocery = new Groceries(groceriesList);

		List<Item> itemsList = new ArrayList<Item>();

		itemsList.add(item1);
		itemsList.add(item2);

		BillingItems items = new BillingItems(itemsList, grocery);

		return items;

	}
}
