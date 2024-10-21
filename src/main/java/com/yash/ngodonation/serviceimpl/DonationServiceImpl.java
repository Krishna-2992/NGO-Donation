package com.yash.ngodonation.serviceimpl;

import java.util.List;

import com.yash.ngodonation.dao.DonationDao;
import com.yash.ngodonation.domain.Donation;
import com.yash.ngodonation.service.DonationService;

public class DonationServiceImpl implements DonationService {
    private DonationDao donationDao;


    public DonationServiceImpl(DonationDao donationDAO) {
        this.donationDao = donationDAO;
    }

    @Override
    public void addDonation(Donation donation) {
        donationDao.addDonation(donation);
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationDao.getAllDonations();
    }

    @Override
    public Donation getDonationById(int donationId) {
        return donationDao.getDonationById(donationId);
    }


    @Override
    public void deleteDonation(int donationId) {
        donationDao.deleteDonation(donationId);
    }
}
