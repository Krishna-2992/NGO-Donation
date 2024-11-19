package com.yash.ngodonation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	
	static final String URL = "jdbc:mysql://localhost:3306/Donor";
	static final String USER ="root";
	static final String PASSWORD="Password@2024";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	Connection con = null;
	
    Connection getCon(){
        try {
            if (con==null){
                con = DriverManager.getConnection(URL,USER,PASSWORD);
            }
            if (con.isClosed()){
                con = DriverManager.getConnection(URL,USER,PASSWORD);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }

        return con;
    }

    public PreparedStatement createPreparedStatement(String query){
        try {
            return getCon().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }
    }
    
    public void closePreparedStatement(PreparedStatement ps){
        try {
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet createResultSet(String query){
        try {
            return getCon().createStatement().executeQuery(query);
//            return createPreparedStatement(query).getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(){
        try{
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
