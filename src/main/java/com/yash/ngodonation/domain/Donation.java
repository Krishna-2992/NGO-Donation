package com.yash.ngodonation.domain;

import java.util.Date;

public class Donation {
    private int userId;
    private int donationId;
    private double donationAmount;
    private Date donationDate;


    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Date getDonationDate(Date donationDate) {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }
}