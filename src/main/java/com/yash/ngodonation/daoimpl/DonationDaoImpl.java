package com.yash.ngodonation.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.yash.ngodonation.dao.DonationDao;
import com.yash.ngodonation.domain.Donation;
import com.yash.ngodonation.util.DBConnection;

public class DonationDaoImpl implements DonationDao {
    private Connection connection;

    public DonationDaoImpl() {
        this.connection = DBConnection.getConnection(); // Initialize the connection
    }

    @Override
    public void addDonation(Donation donation) {
        try {
            String sql = "INSERT INTO donations (userId, donationAmount, donationDate) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, donation.getUserId());
            statement.setDouble(2, donation.getDonationAmount());
            statement.setDate(3, new java.sql.Date(donation.getDonationDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Donation> getAllDonations() {
        List<Donation> donations = new ArrayList<>();
        try {
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
            String sql = "SELECT * FROM donations WHERE donationId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, donationId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                donation = new Donation(); // Assign to the existing variable
                donation.setUserId(resultSet.getInt("userId"));
                donation.setDonationId(resultSet.getInt("donationId"));
                donation.setDonationAmount(resultSet.getDouble("donationAmount"));
                donation.setDonationDate(resultSet.getDate("donationDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donation;
    }



    @Override
    public void deleteDonation(int donationId) {
        try {
            String sql = "DELETE FROM donations WHERE donationId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, donationId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}