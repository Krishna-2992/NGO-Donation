package com.yash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.DaoImpl.ReceiptDaoImpl;
import com.yash.dao.ReceiptDao;
import com.yash.domain.Receipt;

@WebServlet("/ReceiptController")
public class ReceiptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int paymentId = Integer.parseInt(req.getParameter("paymentId"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		String donorName = req.getParameter("name");
		double donationAmount = Double.parseDouble(req.getParameter("donationAmount"));
		String donationDate = req.getParameter("donationDate");
		String paymentMode = req.getParameter("paymentMode");
		
		Receipt receipt = new Receipt();
		receipt.setPaymentId(paymentId);
		receipt.setUserId(userId);
		receipt.setName(donorName);
		receipt.setDonationAmount(donationAmount);
		receipt.setDonationDate(donationDate);
		receipt.setPaymentMode(paymentMode);
		
		try {
			ReceiptDao dao	= new ReceiptDaoImpl();
			dao.addReceipt(receipt);
			res.sendRedirect("receipt.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
			res.sendRedirect("fail.jsp");
		}
		
		
		
	}

}

