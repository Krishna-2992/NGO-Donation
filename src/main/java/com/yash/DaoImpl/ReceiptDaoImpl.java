package com.yash.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yash.dao.ReceiptDao;
import com.yash.domain.Receipt;
import com.yash.util.ReceiptDBUtil;

public class ReceiptDaoImpl implements ReceiptDao {

	@Override
	public void addReceipt(Receipt receipt) {
		String query = "INSERT INTO receipts(paymentId, userId, name, donationAmount, donationDate, paymentMode) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conn =ReceiptDBUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, receipt.getPaymentId());
			preparedStatement.setInt(2, receipt.getUserId());
			preparedStatement.setString(3, receipt.getName());
			preparedStatement.setDouble(4, receipt.getDonationAmount());
			preparedStatement.setString(5, receipt.getDonationDate());
			preparedStatement.setString(6, receipt.getPaymentMode());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void deleteReceipt(int receiptId) throws SQLException {
		String query = "DELETE FROM receipts WHERE receiptId=?";
		Connection con = ReceiptDBUtil.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, receiptId);
		preparedStatement.executeUpdate();
	}
	
	@Override
	public List<Receipt> getAllReceipts() throws SQLException {
		List<Receipt> receipts = new ArrayList<>();
		String query = "SELECT * FROM receipts";
		Connection con = ReceiptDBUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery(query);
		while (resultSet.next()) {
			Receipt receipt = new Receipt();
			//receipt.setReceiptId(resultSet.getInt("receiptId"));
			receipt.setPaymentId(resultSet.getInt("paymentId"));
			receipt.setUserId(resultSet.getInt("userId"));
			receipt.setName(resultSet.getString("name"));
			receipt.setDonationAmount(resultSet.getDouble("donationAmount"));
			receipt.setDonationDate(resultSet.getString("donationDate"));
			receipt.setPaymentMode(resultSet.getString("paymentMode"));
			receipts.add(receipt);
		}
		return receipts;
	}
	
	@Override
	public Receipt getReceiptById(int receiptId) throws SQLException {
		Receipt receipt = null;
		String query = "SELECT * FROM receipts WHERE receiptId=?";
		Connection con = ReceiptDBUtil.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, receiptId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			receipt = new Receipt();
			//receipt.setReceiptId(resultSet.getInt("receiptId"));
			receipt.setPaymentId(resultSet.getInt("paymentId"));
			receipt.setUserId(resultSet.getInt("userId"));
			receipt.setName(resultSet.getString("name"));
			receipt.setDonationAmount(resultSet.getDouble("donationAmount"));
			receipt.setDonationDate(resultSet.getString("donationDate"));
			receipt.setPaymentMode(resultSet.getString("paymentMode"));
		}
		return receipt;
	}
}
