package com.retail.model;

public class BillingItemsResponse {

	private BillingItems billingItems;
	private double totalItemsPrice;
	private double discountedItemsPrice;
	private double totalGroceryPrice;
	private double netPayableAmount;

	public BillingItems getBillingItems() {
		return billingItems;
	}

	public void setBillingItems(BillingItems billingItems) {
		this.billingItems = billingItems;
	}

	public double getTotalItemsPrice() {
		return totalItemsPrice;
	}

	public void setTotalItemsPrice(double totalItemsPrice) {
		this.totalItemsPrice = totalItemsPrice;
	}

	public double getDiscountedItemsPrice() {
		return discountedItemsPrice;
	}

	public void setDiscountedItemsPrice(double discountedItemsPrice) {
		this.discountedItemsPrice = discountedItemsPrice;
	}

	public double getTotalGroceryPrice() {
		return totalGroceryPrice;
	}

	public void setTotalGroceryPrice(double totalGroceryPrice) {
		this.totalGroceryPrice = totalGroceryPrice;
	}

	public double getNetPayableAmount() {
		return netPayableAmount;
	}

	public void setNetPayableAmount(double netPayableAmount) {
		this.netPayableAmount = netPayableAmount;
	}
}
