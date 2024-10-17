package com.yash.ngodonation.dao;

import java.util.List;

import com.yash.ngodonation.domain.Certificate;

public interface CertificateDAO {
    void addCertificate(Certificate certificate);

    Certificate getCertificateById(int certificateId);

    List<Certificate> getAllCertificates();
}