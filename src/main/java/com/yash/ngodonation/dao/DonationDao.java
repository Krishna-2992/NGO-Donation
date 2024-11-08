package com.yash.ngodonation.dao;
import com.yash.ngodonation.domain.Donation;

import java.util.List;

public interface DonationDao {

    void addDonation(Donation donation);


    List<Donation> getAllDonations();


    Donation getDonationById(int donationId);


    void deleteDonation(int donationId);
}