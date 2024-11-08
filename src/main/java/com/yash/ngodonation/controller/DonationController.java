package com.yash.ngodonation.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        try {
            int userId = Integer.parseInt(req.getParameter("userId"));
            int donationId = Integer.parseInt(req.getParameter("donationId"));
            double donationAmount = Double.parseDouble(req.getParameter("donationAmount"));
            String donationDateParam = req.getParameter("donationDate");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date donationDate = dateFormat.parse(donationDateParam);

            Donation donation = new Donation();
            donation.setUserId(userId);
            donation.setDonationId(donationId);
            donation.setDonationAmount(donationAmount);
            donation.setDonationDate(donationDate);


            DonationDao dao = new DonationDaoImpl();
            dao.addDonation(donation);
            // Redirect to a success page
            res.sendRedirect("Success.jsp");

        } catch (ParseException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Invalid date format. Please use 'yyyy-MM-dd'.");
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Invalid number format. Please check your input.");
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "An unexpected error occurred. Please try again.");
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }
}