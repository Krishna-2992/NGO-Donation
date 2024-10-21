package com.yash.ngodonation.service;

import java.util.List;

import com.yash.ngodonation.domain.Donation;

public interface DonationService {
    // Method to add a new donation
    void addDonation(Donation donation);
    List<Donation> getAllDonations();
    Donation getDonationById(int donationId);
    void deleteDonation(int donationId);
}