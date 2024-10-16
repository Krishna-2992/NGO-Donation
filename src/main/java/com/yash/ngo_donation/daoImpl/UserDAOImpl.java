package com.yash.ngo_donation.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.yash.ngo_donation.dao.UserDAO;
import com.yash.ngo_donation.pojo.User;
import com.yash.ngo_donation.util.DBConnection;


public class UserDAOImpl implements UserDAO{
	
	private Connection connection;

	public void saveUser(User user) {
		try {
			System.out.println("inside userDAO saveUser!!");
			connection = DBConnection.getConnection();
			
			// creating query
			String insertionQuery1 = "Insert into User values (?,?,?,?,?,?,?)";
			
			// prepared stmt
			PreparedStatement pstm = connection.prepareStatement(insertionQuery1);
			
			// setting the value
			pstm.setInt(1, user.getUserId());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getEmail());
			pstm.setString(5, user.getPhoneNumber());
			pstm.setString(6, user.getAddress());
			pstm.setString(7, user.getRole());
			
			pstm.executeUpdate();
			System.out.println("System updated!!");
			
			DBConnection.closeConnection(connection);
//			
		} catch(Exception e) {
			System.out.println("exception occured!!");
		}
	}
	
	public ArrayList<User> getAllUser() {
		System.out.println("inside userDAO getAllUsers"); 
		
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			connection = DBConnection.getConnection();
			
			// creating the query
			String q2 = "Select * from user"; 
			Statement st = connection.createStatement();
			ResultSet data = st.executeQuery(q2);
			
			while(data.next()) {
				int userId = data.getInt("userId");
				String name = data.getString("name");
				String email = data.getString("email");
				String password = data.getString("password");
				String phoneNumber = data.getString("phoneNumber");
				String address = data.getString("address"); 
				String role = data.getString("role");
				
				// create the user
				User user = new User(userId, name, password, email, phoneNumber, address, role);
				
				// append the user
				users.add(user);
			}
			System.out.println("Fetched and returning all users");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}