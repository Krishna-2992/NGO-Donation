
package com.yash.ngodonation.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ngodonation.daoimpl.DonationDaoImpl;
import com.yash.ngodonation.dao.DonationDao;
import com.yash.ngodonation.domain.Donation;

@WebServlet("/DonationController")
public class DonationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // Extract parameters from the request
        int userId = Integer.parseInt(req.getParameter("userId"));
        int donationId = Integer.parseInt(req.getParameter("donationId"));
        double donationAmount = Double.parseDouble(req.getParameter("donationAmount"));
        String donationDate = req.getParameter("donationDate");

        // Create a Donation object and set its properties
        Donation donation = new Donation();
        donation.setUserId(userId);
        donation.setDonationId(donationId);
        donation.setDonationAmount(donationAmount);
        //donation.setDonationDate(donationDate);


        try {
            // Create a DAO instance and add the donation
            DonationDao dao = new DonationDaoImpl();
            dao.addDonation(donation);
            // Redirect to a success page
            res.sendRedirect("donationSuccess.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            // Redirect to a failure page
            res.sendRedirect("donationFail.jsp");
        }
    }
}