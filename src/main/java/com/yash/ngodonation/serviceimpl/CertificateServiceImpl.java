package com.yash.ngodonation.serviceimpl;

import com.yash.ngodonation.dao.CertificateDAO;
import com.yash.ngodonation.daoimpl.CertificateDAOImpl;
import com.yash.ngodonation.domain.Certificate;
import com.yash.ngodonation.service.CertificateService;

import java.util.List;

public class CertificateServiceImpl implements CertificateService {
    private CertificateDAO certificateDAO = new CertificateDAOImpl();

    @Override
    public void generateCertificate(Certificate certificate) {
        certificateDAO.addCertificate(certificate);
    }

    @Override
    public Certificate getCertificateById(int certificateId) {
        return certificateDAO.getCertificateById(certificateId);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateDAO.getAllCertificates();
    }
}