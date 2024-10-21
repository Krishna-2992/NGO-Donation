package com.yash.ngodonation.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.yash.ngodonation.dao.DonationDao;
import com.yash.ngodonation.domain.Donation;

public class DonationDaoImpl implements DonationDao {
    private Connection connection;

    @Override
    public void addDonation(Donation donation) {
        try {
            // SQL query to insert a new donation
            String sql = "INSERT INTO donations (userId, donationAmount, donationDate) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, donation.getUserId());
            statement.setDouble(2, donation.getDonationAmount());
            statement.setDate(3, new java.sql.Date(donation.getDonationDate(null).getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Donation> getAllDonations() {
        List<Donation> donations = new ArrayList<>();
        try {
            // SQL query to retrieve all donations
            String sql = "SELECT * FROM donations";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Donation donation = new Donation();
                donation.setUserId(resultSet.getInt("userId"));
                donation.setDonationId(resultSet.getInt("donationId"));
                donation.setDonationAmount(resultSet.getDouble("donationAmount"));
                donation.setDonationDate(resultSet.getDate("donationDate"));
                donations.add(donation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donations;
    }

    @Override
    public Donation getDonationById(int donationId) {
        Donation donation = null;
        try {
            // SQL query to retrieve a donation by ID
            String sql = "SELECT * FROM donations WHERE donationId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, donationId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Donation d= new Donation();
                d.setUserId(resultSet.getInt("userId"));
                d.setDonationId(resultSet.getInt("donationId"));
                d.setDonationAmount(resultSet.getDouble("donationAmount"));
                d.setDonationDate(resultSet.getDate("donationDate"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donation;
    }



    @Override
    public void deleteDonation(int donationId) {
        try {
            // SQL query to delete a donation
            String sql = "DELETE FROM donations WHERE donationId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, donationId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}