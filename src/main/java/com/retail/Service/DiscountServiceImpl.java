package com.retail.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.retail.model.BillingItems;
import com.retail.model.Groceries;
import com.retail.model.Item;
import com.retail.model.User;

@Service("discountService")
public class DiscountServiceImpl implements DiscountService {

	@Override
	public BillingItems processDiscount(BillingItems items, User user) {
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

		items.setItemsSum(checkApplyDiscount(totalItemSum, user));

		items.setGroceriesSum(totalGrocerySum);

		double total = totalGrocerySum + items.getItemsSum();

		// subtract %5 for every $100 discount from totalItemSum.
		if (total > 100) {
			int nthNum = (int) (total / 100);
			total -= 5 * nthNum;
			items.setTotal(total);
		}

		return items;
	}

	private double checkApplyDiscount(double totalItemSum, User user) {

		LocalDate dateBefore2years = LocalDate.now(ZoneId.of("Asia/Kolkata")).minusYears(-2);

		double discountedSumForEmployee = 0;
		double discountedSumForAffiliate = 0;
		double discountedSumBasedOnCustomerLoyalty = 0;

		if (user.getUserType().equalsIgnoreCase("employee")) {

			discountedSumForEmployee = totalItemSum - (totalItemSum * 0.3);
			return discountedSumForEmployee;

		} else if (user.getUserType().equalsIgnoreCase("affiliate")) {

			discountedSumForAffiliate = totalItemSum - (totalItemSum * 0.1);
			return discountedSumForAffiliate;

		}

		if (dateBefore2years.isAfter(user.getCreatedAt().toLocalDate())) {
			discountedSumBasedOnCustomerLoyalty = totalItemSum - (totalItemSum * 0.05);

			return discountedSumBasedOnCustomerLoyalty;
		}
		return totalItemSum;

	}

}
