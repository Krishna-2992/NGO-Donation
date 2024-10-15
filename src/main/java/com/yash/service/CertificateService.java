package com.yash.service;

import com.yash.model.Certificate;
import java.util.List;

public interface CertificateService {
    void generateCertificate(Certificate certificate);
    Certificate getCertificateById(int certificateId);
    List<Certificate> getAllCertificates();
}