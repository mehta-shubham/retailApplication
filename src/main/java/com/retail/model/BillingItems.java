package com.retail.model;

import java.util.List;

public class BillingItems {

	private List<Item> itemsList;
	private Groceries groceries;

	private double itemsSum;
	private double groceriesSum;
	
	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public BillingItems() {
	}

	public BillingItems(List<Item> itemsList, Groceries groceries) {
		this.itemsList = itemsList;
		this.groceries = groceries;
	}

	public double getItemsSum() {
		return itemsSum;
	}

	public void setItemsSum(double itemsSum) {
		this.itemsSum = itemsSum;
	}

	public double getGroceriesSum() {
		return groceriesSum;
	}

	public void setGroceriesSum(double groceriesSum) {
		this.groceriesSum = groceriesSum;
	}

	public List<Item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}

	public Groceries getGroceries() {
		return groceries;
	}

	public void setGroceries(Groceries groceries) {
		this.groceries = groceries;
	}
}
