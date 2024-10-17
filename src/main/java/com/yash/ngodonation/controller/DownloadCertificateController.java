package com.yash.ngodonation.controller;

import com.yash.ngodonation.domain.Certificate;
import com.yash.ngodonation.service.CertificateService;
import com.yash.ngodonation.serviceimpl.CertificateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/downloadCertificate")
public class DownloadCertificateController extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private CertificateService certificateService = new CertificateServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String certificateIdStr = request.getParameter("certificateId");
        int certificateId = Integer.parseInt(certificateIdStr);

        // Fetch certificate from the database
        Certificate certificate = certificateService.getCertificateById(certificateId);

        if (certificate != null) {
            // Set response headers for downloading the certificate as a text file
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition", "attachment;filename=certificate_" + certificateId + ".txt");

            // Writing the certificate details into the response output
            PrintWriter out = response.getWriter();
            out.println("Certificate ID: " + certificate.getCertificateId());
            out.println("Name: " + certificate.getName());
            out.println("Donor ID: " + certificate.getDonorId());
            out.println("Payment Mode: " + certificate.getPaymentMode());
            out.println("Date of Issue: " + certificate.getDateOfIssue());
        } else {
            // errror msg will get displayed if certificte not found
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>Certificate not found for ID: " + certificateId + "</h2>");
        }
    }
}
