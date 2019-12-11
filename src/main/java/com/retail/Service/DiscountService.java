package com.retail.Service;

import com.retail.model.BillingItems;
import com.retail.model.BillingItemsResponse;
import com.retail.model.User;

public interface DiscountService {

	public BillingItemsResponse processDiscount(BillingItems items, User user);
}
