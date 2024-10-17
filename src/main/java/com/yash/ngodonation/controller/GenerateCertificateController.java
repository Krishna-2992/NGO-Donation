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

@WebServlet("/generateCertificate")
public class GenerateCertificateController extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private CertificateService certificateService = new CertificateServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String donorId = request.getParameter("donorId");
        String paymentMode = request.getParameter("paymentMode");
        String dateOfIssue = request.getParameter("dateOfIssue");

        Certificate certificate = new Certificate();
        certificate.setName(name);
        certificate.setDonorId(donorId);
        certificate.setPaymentMode(paymentMode);
        certificate.setDateOfIssue(dateOfIssue);

        certificateService.generateCertificate(certificate);

        response.sendRedirect("Certificate.jsp");
    }
}