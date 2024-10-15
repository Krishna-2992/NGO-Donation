package com.yash.dao;

import java.sql.SQLException;
import java.util.List;
import com.yash.domain.Receipt;

public interface ReceiptDao {
	public void addReceipt(Receipt receipt) throws SQLException;
	public void deleteReceipt(int receiptId)throws SQLException;
	public List<Receipt> getAllReceipts()throws SQLException;
	public Receipt getReceiptById(int receiptId) throws SQLException;
}