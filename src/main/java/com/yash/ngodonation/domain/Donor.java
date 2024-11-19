package com.yash.ngodonation.domain;

public class Donor {
	
	private String username;
	private int amount;
	
	public Donor(String username,int amount) {
		this.username=username;
		this.amount=amount;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAmount() {
		return amount;
	}
	
	public int setAmount() {
		return amount;
	}


}
