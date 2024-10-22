package com.yash.ngodonation.daoimpl;


import com.yash.ngodonation.dao.UserDao;
import com.yash.ngodonation.domain.User;
import com.yash.ngodonation.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private Connection connection;

    public void saveUser(User user) {
        try {
            System.out.println("inside userDAO saveUser!!");
            connection = DBConnection.getConnection();

            // creating query
            String insertionQuery1 = "INSERT INTO User (name, email, password, phoneNumber, address) VALUES (?, ?, ?, ?, ?)";

            // prepared stmt
            PreparedStatement pstm = connection.prepareStatement(insertionQuery1);

            // setting the value
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getPhoneNumber());
            pstm.setString(5, user.getAddress());

            pstm.executeUpdate();
            System.out.println("System updated!!");

            DBConnection.closeConnection(connection);

        } catch(Exception e) {
            System.out.println("exception occured!! " + e);
        }
    }

    public List<User> getAllUsers() {
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
    public User getUser (String email, String password) {
        System.out.println("inside userDAO getUser ");

        User user = null;

        try {
            connection = DBConnection.getConnection();

            // Creating the query with placeholders
            String query = "SELECT * FROM User WHERE email = ? AND password = ?";
            PreparedStatement pstm = connection.prepareStatement(query);

            // Setting the values for the query
            pstm.setString(1, email);
            pstm.setString(2, password);

            // Executing the query
            ResultSet data = pstm.executeQuery();

            // If a user is found, create the user object
            if (data.next()) {
                int userId = data.getInt("userId");
                String name = data.getString("name");
                String phoneNumber = data.getString("phoneNumber");
                String address = data.getString("address");
                String role = data.getString("role");

                // Create the user object
                user = new User(userId, name, password, email, phoneNumber, address, role);
            } else {
                System.out.println("No user found with the provided email and password.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user; // Return the user object or null if not found
    }

}