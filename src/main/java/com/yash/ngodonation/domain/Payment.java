package com.yash.ngodonation.domain;

public class Payment {

	int paymentId;
	String paymentMode;
	String paymentStatus;
	
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	

	public String getPaymentMode() {
		return paymentMode;
	}
	
	
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	
	
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
