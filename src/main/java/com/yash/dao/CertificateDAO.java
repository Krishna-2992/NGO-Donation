package com.yash.dao;

import com.yash.model.Certificate;
import java.util.List;

public interface CertificateDAO {
    void addCertificate(Certificate certificate);
    Certificate getCertificateById(int certificateId);
    List<Certificate> getAllCertificates();
}