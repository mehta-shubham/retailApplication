package com.retail.model;

import java.util.List;

import javax.validation.Valid;

public class BillingItems {

	@Valid
	private List<Item> itemsList;
	@Valid
	private Groceries groceries;

	//private double total;

	/*
	 * public double getTotal() { return total; }
	 * 
	 * public void setTotal(double total) { this.total = total; }
	 */
	public BillingItems() {
	}

	public BillingItems(List<Item> itemsList, Groceries groceries) {
		this.itemsList = itemsList;
		this.groceries = groceries;
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
