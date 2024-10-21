package com.yash.ngodonation.dao;
import com.yash.ngodonation.domain.Donation;

import java.util.List;

public interface DonationDao {
    // Method to add a new donation
    void addDonation(Donation donation);

    // Method to retrieve all donations
    List<Donation> getAllDonations();

    // Method to retrieve a donation by ID
    Donation getDonationById(int donationId);


    // Method to delete a donation
    void deleteDonation(int donationId);
}