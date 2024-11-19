package com.yash.ngodonation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ngodonation.dao.AddPayment;
import com.yash.ngodonation.daoimpl.AddPaymentImp;
import com.yash.ngodonation.domain.Donor;

@WebServlet("/insert")
public class Insert extends HttpServlet{

	public  void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		String name = req.getParameter("name");
		System.out.print(name);
		int amount=Integer.parseInt(req.getParameter("amount"));
		
		Donor donor = new Donor(name,amount);
		AddPayment iur = new AddPaymentImp();
		
		if(iur.addPaymentDetail(donor)) {
			PrintWriter out = res.getWriter();
			out.print("Payment Successfull");
		}
		
		
			
	}

}







