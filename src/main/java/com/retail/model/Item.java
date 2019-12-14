package com.retail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.retail.annotation.IsDoubleEmpty;
import com.retail.annotation.IsEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	@IsEmpty
	private String name;
	@IsDoubleEmpty
	private double value;
	
	public Item(){
	}
	
	public Item(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
