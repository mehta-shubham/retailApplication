package com.retail.model;

import java.util.List;

public class Groceries {

	private List<Item> groceriesList;
	
	public Groceries(){
	}
	public Groceries(List<Item> groceriesList) {
		this.groceriesList = groceriesList;
	}

	public List<Item> getGroceriesList() {
		return groceriesList;
	}

	

	public void setGroceriesList(List<Item> groceriesList) {
		this.groceriesList = groceriesList;
	}
}
