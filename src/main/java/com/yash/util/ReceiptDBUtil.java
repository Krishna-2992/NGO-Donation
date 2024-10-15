package com.yash.util;

import java.sql.*;
public class ReceiptDBUtil {
	private static final String URL="jdbc:mysql://localhost:3306/yash";
	private static final String USER="root";
	private static final String PASSWORD="Password@2024"; // previous - Password@2024
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USER,PASSWORD);	
	}
}
