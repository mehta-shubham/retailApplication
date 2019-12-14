package com.retail.service;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.service.DiscountService;
import com.retail.service.DiscountServiceImpl;
import com.retail.model.BillingItems;
import com.retail.model.BillingItemsResponse;
import com.retail.model.Groceries;
import com.retail.model.Item;
import com.retail.model.User;

@RunWith(SpringRunner.class)
@TestPropertySource({ "classpath:application.properties" })
public class DiscountServiceTest {

	@TestConfiguration
	static class DiscountServiceImplTestContextConfiguration {

		@Bean
		public DiscountService employeeService() {
			return new DiscountServiceImpl();
		}
	}

	@Autowired
	private DiscountService discountService;

	/*
	 * @MockBean private UserDao userDao;
	 */

	private BillingItems billingItems;
	private User user1, user2, user3;

	@Before
	public void before() {
		billingItems = new BillingItems();
		Groceries groceries = new Groceries();

		List<Item> groceriesList = new ArrayList<Item>();

		Date date1 = Date.valueOf("2018-01-17");
		Date date2 = Date.valueOf("2018-06-20");

		user1 = new User("Shubham", "Mehta", "employee", date1, date2);
		date1 = Date.valueOf("2016-04-01");
		date2 = Date.valueOf("2018-05-22");
		user2 = new User("Debapriya", "Ghosh", "affiliate", date1, date2);
		date1 = Date.valueOf("2016-12-01");
		date2 = Date.valueOf("2019-05-11");
		user3 = new User("Devank", "Chawla", "customer", date1, date2);

		Item item1 = new Item("Mango", 40);
		Item item2 = new Item("Orange", 20);
		Item item3 = new Item("Tomato", 10);
		Item item4 = new Item("Onion", 70);

		List<Item> itemsList = new ArrayList<Item>();

		Item item5 = new Item("FaceWash", 20);
		Item item6 = new Item("Soap", 10);
		Item item7 = new Item("Shampoo", 30);

		groceriesList.add(item1);
		groceriesList.add(item2);
		groceriesList.add(item3);
		groceriesList.add(item4);

		groceries.setGroceriesList(groceriesList);

		billingItems.setGroceries(groceries);

		itemsList.add(item5);
		itemsList.add(item6);
		itemsList.add(item7);

		billingItems.setItemsList(itemsList);
	}

	@Test
	public void whenUserIsEmployee() {
		BillingItemsResponse response = discountService.processDiscount(billingItems, user1);
		double totalItemsPrice = 0, totalGroceryPrice = 0;
		for (Item i : billingItems.getItemsList()) {
			totalItemsPrice += i.getValue();
		}

		for (Item i : billingItems.getGroceries().getGroceriesList()) {
			totalGroceryPrice += i.getValue();
		}

		assertEquals(response.getTotalItemsPrice(), totalItemsPrice, 0);
		assertEquals(response.getDiscountedItemsPrice(), totalItemsPrice - totalItemsPrice * 0.3, 0);
		assertEquals(response.getTotalGroceryPrice(), totalGroceryPrice, 0);

	}

	@Test
	public void whenUserIsAffiliate() {
		BillingItemsResponse response = discountService.processDiscount(billingItems, user2);
		double totalItemsPrice = 0, totalGroceryPrice = 0;
		for (Item i : billingItems.getItemsList()) {
			totalItemsPrice += i.getValue();
		}

		for (Item i : billingItems.getGroceries().getGroceriesList()) {
			totalGroceryPrice += i.getValue();
		}

		assertEquals(response.getTotalItemsPrice(), totalItemsPrice, 0);
		assertEquals(response.getDiscountedItemsPrice(), totalItemsPrice - totalItemsPrice * 0.1, 0);
		assertEquals(response.getTotalGroceryPrice(), totalGroceryPrice, 0);
	}

	@Test
	public void whenUserIsOlderThan2Years() {
		BillingItemsResponse response = discountService.processDiscount(billingItems, user3);
		double totalItemsPrice = 0, totalGroceryPrice = 0;
		for (Item i : billingItems.getItemsList()) {
			totalItemsPrice += i.getValue();
		}

		for (Item i : billingItems.getGroceries().getGroceriesList()) {
			totalGroceryPrice += i.getValue();
		}

		assertEquals(response.getTotalItemsPrice(), totalItemsPrice, 0);
		assertEquals(response.getDiscountedItemsPrice(), totalItemsPrice - totalItemsPrice * 0.05, 0);
		assertEquals(response.getTotalGroceryPrice(), totalGroceryPrice, 0);
	}
}