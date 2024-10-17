package com.yash.ngodonation.service;

import java.util.List;

import com.yash.ngodonation.domain.Certificate;

public interface CertificateService {
    void generateCertificate(Certificate certificate);
    Certificate getCertificateById(int certificateId);
    List<Certificate> getAllCertificates();
}