package com.retail.controller;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.retail.application.RetailApplication;
import com.retail.model.BillingItems;
import com.retail.model.BillingItemsResponse;
import com.retail.model.Groceries;
import com.retail.model.Item;
import com.retail.model.User;
import com.retail.service.DiscountService;
import com.retail.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BillingController.class, secure = false)
@SpringBootTest(classes = RetailApplication.class)
public class BillingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DiscountService discountService;

	@MockBean
	private UserService userService;

	private BillingItems billingItems;
	private User user1, user2, user3;

	Optional<User> containerObj;

	private BillingItemsResponse billingResponse;

	private static final String requestJson = "{\r\n" + "    \"itemsList\": [\r\n" + "        {\r\n"
			+ "            \"name\": \"facewash\",\r\n" + "            \"value\": 30.0\r\n" + "        },\r\n"
			+ "        {\r\n" + "            \"name\": \"soap\",\r\n" + "            \"value\": 20.0\r\n"
			+ "        },\r\n" + "        {\r\n" + "            \"name\": \"shampoo\",\r\n"
			+ "            \"value\": 40.0\r\n" + "        },\r\n" + "         {\r\n"
			+ "            \"name\": \"handwash\",\r\n" + "            \"value\": 70.0\r\n" + "        },\r\n"
			+ "         {\r\n" + "            \"name\": \"insense stick\",\r\n" + "            \"value\": 10.0\r\n"
			+ "        }\r\n" + "    ],\r\n" + "    \"groceries\": {\r\n" + "        \"groceriesList\": [\r\n"
			+ "            {\r\n" + "                \"name\": \"Mango\",\r\n" + "                \"value\": 50.0\r\n"
			+ "            },\r\n" + "            {\r\n" + "                \"name\": \"Orange\",\r\n"
			+ "                \"value\": 40.0\r\n" + "            },\r\n" + "            {\r\n"
			+ "                \"name\": \"Banana\",\r\n" + "                \"value\": 10.0\r\n" + "            }\r\n"
			+ "        ]\r\n" + "    },\r\n" + "    \"itemsSum\": 0.0,\r\n" + "    \"groceriesSum\": 0.0\r\n" + "}";

	@Before
	public void before() {
		billingItems = new BillingItems();
		Groceries groceries = new Groceries();

		List<Item> groceriesList = new ArrayList<Item>();

		billingResponse = new BillingItemsResponse();

		Date date1 = Date.valueOf("2018-01-17");
		Date date2 = Date.valueOf("2018-06-20");

		user1 = new User("Shubham", "Mehta", "employee", date1, date2);
		date1 = Date.valueOf("2016-04-01");
		date2 = Date.valueOf("2018-05-22");
		user2 = new User("Debapriya", "Ghosh", "affiliate", date1, date2);
		date1 = Date.valueOf("2016-12-01");
		date2 = Date.valueOf("2019-05-11");
		user3 = new User("Devank", "Chawla", "customer", date1, date2);

		Item item1 = new Item("Mango", 50);
		Item item2 = new Item("Orange", 40);
		Item item3 = new Item("Banana", 10);

		List<Item> itemsList = new ArrayList<Item>();

		Item item5 = new Item("facewash", 30);
		Item item6 = new Item("soap", 20);
		Item item7 = new Item("shampoo", 40);
		Item item8 = new Item("handwash", 70);
		Item item9 = new Item("insense stick", 10);

		groceriesList.add(item1);
		groceriesList.add(item2);
		groceriesList.add(item3);

		groceries.setGroceriesList(groceriesList);

		billingItems.setGroceries(groceries);

		itemsList.add(item5);
		itemsList.add(item6);
		itemsList.add(item7);
		itemsList.add(item8);
		itemsList.add(item9);

		billingItems.setItemsList(itemsList);

		billingResponse.setBillingItems(billingItems);
	}

	@Test
	public void testApplyDiscountsAPI() throws Exception {
		Mockito.when(userService.getUser(Mockito.anyLong())).thenReturn(containerObj);
		Mockito.when(discountService.processDiscount(Mockito.anyObject(), Mockito.anyObject()))
				.thenReturn(billingResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/applyDiscount/1")
				.accept(MediaType.APPLICATION_JSON).content(requestJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(HttpStatus.OK, result.getResponse().getStatus());
		
	}
}
