package com.retail.service;

import com.retail.model.BillingItems;
import com.retail.model.BillingItemsResponse;
import com.retail.model.User;

public interface DiscountService {

	/**
	 * Method to apply discounts on non-Grocery items based on customer type
	 * Also processes $5 discount for every $100 on the total bill amount(other items + grocery)
	 * i.e. if total bill is $990 then customer gets $45 discount
	 * @param items
	 * @param user
	 * @return BillingItemsResponse
	 */
	public BillingItemsResponse processDiscount(BillingItems items, User user);
}
