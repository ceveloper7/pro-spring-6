package com.ceva.spring6.ten.repos.envers;

import com.ceva.spring6.ten.entities.SingerAudit;

import java.util.Optional;

public interface CustomSingerAuditRepository {
    Optional<SingerAudit> findAuditByIdAndRevision(Long id, int revision);
}
