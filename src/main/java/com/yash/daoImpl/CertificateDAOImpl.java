package com.yash.daoImpl;

import com.yash.dao.CertificateDAO;
import com.yash.model.Certificate;
import com.yash.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CertificateDAOImpl implements CertificateDAO {

    @Override
    public void addCertificate(Certificate certificate) {
        try (Connection con = DBUtil.getConnection()) {
            String query = "INSERT INTO certificates(name, donorId, paymentMode, dateOfIssue) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, certificate.getName());
            ps.setString(2, certificate.getDonorId());
            ps.setString(3, certificate.getPaymentMode());
            ps.setString(4, certificate.getDateOfIssue());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Certificate getCertificateById(int certificateId) {
        Certificate certificate = null;
        try (Connection con = DBUtil.getConnection()) {
            String query = "SELECT * FROM certificates WHERE certificateId=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, certificateId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                certificate = new Certificate();
                certificate.setCertificateId(rs.getInt("certificateId"));
                certificate.setName(rs.getString("name"));
                certificate.setDonorId(rs.getString("donorId"));
                certificate.setPaymentMode(rs.getString("paymentMode"));
                certificate.setDateOfIssue(rs.getString("dateOfIssue"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificate;
    }

    @Override
    public List<Certificate> getAllCertificates() {
        List<Certificate> certificates = new ArrayList<>();
        try (Connection con = DBUtil.getConnection()) {
            String query = "SELECT * FROM certificates";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Certificate certificate = new Certificate();
                certificate.setCertificateId(rs.getInt("certificateId"));
                certificate.setName(rs.getString("name"));
                certificate.setDonorId(rs.getString("donorId"));
                certificate.setPaymentMode(rs.getString("paymentMode"));
                certificate.setDateOfIssue(rs.getString("dateOfIssue"));
                certificates.add(certificate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return certificates;
    }
}