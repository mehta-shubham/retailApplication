package com.retail.Service;

import com.retail.model.BillingItems;
import com.retail.model.User;

public interface DiscountService {

	public BillingItems processDiscount(BillingItems items, User user);
}
