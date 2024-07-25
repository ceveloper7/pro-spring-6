package com.ceva.spring6.ten.services;

import com.ceva.spring6.ten.entities.SingerAudit;

import java.util.stream.Stream;

public interface SingerAuditService {
    Stream<SingerAudit> findAll();
    SingerAudit findById(Long id);
    SingerAudit save(SingerAudit singer);

    SingerAudit findAuditByRevision(Long id, int revision);

    void delete(Long id);
}
