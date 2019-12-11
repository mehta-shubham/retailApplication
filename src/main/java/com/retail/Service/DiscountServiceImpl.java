package com.retail.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.retail.model.BillingItems;
import com.retail.model.BillingItemsResponse;
import com.retail.model.Groceries;
import com.retail.model.Item;
import com.retail.model.User;

@Service("discountService")
public class DiscountServiceImpl implements DiscountService {

	private static final String USER_TYPE_AFFILIATE = "affiliate";

	private static final String USER_TYPE_EMPLOYEE = "employee";

	private static final String ASIA_KOLKATA = "Asia/Kolkata";

	@Value("${discount.store.employee}")
	private double employeeDiscount;

	@Value("${discount.store.affiliate}")
	private double affiliateDiscount;

	@Value("${discount.store.loyal.customer}")
	private double loyalCustomerDiscount;

	@Override
	public BillingItemsResponse processDiscount(BillingItems items, User user) {

		BillingItemsResponse responseObject = new BillingItemsResponse();
		responseObject.setBillingItems(items);

		List<Item> itemsList = items.getItemsList();

		double totalItemSum = 0, totalGrocerySum = 0;
		for (int i = 0; i < itemsList.size(); i++) {
			totalItemSum += itemsList.get(i).getValue();
		}

		Groceries groceries = items.getGroceries();
		List<Item> groceriesList = groceries.getGroceriesList();

		for (int i = 0; i < groceriesList.size(); i++) {
			totalGrocerySum += groceriesList.get(i).getValue();
		}

		responseObject.setTotalItemsPrice(totalItemSum);
		responseObject.setDiscountedItemsPrice(checkApplyDiscount(totalItemSum, user));

		responseObject.setTotalGroceryPrice(totalGrocerySum);

		double total = totalGrocerySum + responseObject.getDiscountedItemsPrice();

		// subtract %5 for every $100 discount from totalItemSum.
		if (total > 100) {
			int nthNum = (int) (total / 100);
			total -= 5 * nthNum;
			responseObject.setNetPayableAmount(total);
		}

		return responseObject;
	}

	private double checkApplyDiscount(double totalItemSum, User user) {

		LocalDate dateBefore2years = LocalDate.now(ZoneId.of(ASIA_KOLKATA)).minusYears(-2);

		double discountedSumForEmployee = 0;
		double discountedSumForAffiliate = 0;
		double discountedSumBasedOnCustomerLoyalty = 0;

		if (user.getUserType().equalsIgnoreCase(USER_TYPE_EMPLOYEE)) {

			discountedSumForEmployee = totalItemSum - (totalItemSum * employeeDiscount / 100);
			return discountedSumForEmployee;

		} else if (user.getUserType().equalsIgnoreCase(USER_TYPE_AFFILIATE)) {

			discountedSumForAffiliate = totalItemSum - (totalItemSum * affiliateDiscount / 100);
			return discountedSumForAffiliate;

		}

		if (dateBefore2years.isAfter(user.getCreatedAt().toLocalDate())) {
			discountedSumBasedOnCustomerLoyalty = totalItemSum - (totalItemSum * loyalCustomerDiscount / 100);

			return discountedSumBasedOnCustomerLoyalty;
		}
		return totalItemSum;

	}

}
