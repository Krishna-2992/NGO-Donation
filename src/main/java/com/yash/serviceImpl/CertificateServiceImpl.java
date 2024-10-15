package com.yash.serviceImpl;

import com.yash.dao.CertificateDAO;
import com.yash.daoImpl.CertificateDAOImpl;
import com.yash.model.Certificate;
import com.yash.service.CertificateService;

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