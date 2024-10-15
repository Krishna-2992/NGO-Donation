package com.yash.domain;

public class Receipt {
	
	 private int paymentId;
	    private int userId;
	    private String name;
	    private double donationAmount;
	    private String donationDate;
	    private String paymentMode;
	    

	    
//	    public Receipt() {
//	    	
//	    }
//
//
//		public int getReceiptId() {
//			return receiptId;
//		}


//		public void setReceiptId(int receiptId) {
//			this.receiptId = receiptId;
//		}
//

		public int getPaymentId() {
			return paymentId;
		}


		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public double getDonationAmount() {
			return donationAmount;
		}


		public void setDonationAmount(double donationAmount) {
			this.donationAmount = donationAmount;
		}


		public String getDonationDate() {
			return donationDate;
		}


		public void setDonationDate(String donationDate) {
			this.donationDate = donationDate;
		}


		public String getPaymentMode() {
			return paymentMode;
		}


		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}

	    
	    
}
