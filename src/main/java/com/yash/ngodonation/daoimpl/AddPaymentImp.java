package com.yash.ngodonation.daoimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yash.ngodonation.dao.AddPayment;
import com.yash.ngodonation.domain.Donor;
import com.yash.ngodonation.utils.JDBCUtils;

public class AddPaymentImp implements AddPayment{
	JDBCUtils jdbcutils;
	
	public AddPaymentImp() {
		this.jdbcutils=new JDBCUtils();
	}

	@Override
	public boolean addPaymentDetail(Donor donor) {
		String query ="Insert into donors(name,amount) values(?,?)";
		
		PreparedStatement pst = jdbcutils.createPreparedStatement(query);
		
		try {
			System.out.print(donor.getUsername());
			pst.setString(1, donor.getUsername());
			pst.setInt(2,donor.getAmount());
			pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
		
	}

	
}
