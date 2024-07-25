package com.ceva.spring6.ten.repos;

import com.ceva.spring6.ten.entities.SingerAudit;
import com.ceva.spring6.ten.repos.envers.CustomSingerAuditRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerAuditRepository extends JpaRepository<SingerAudit, Long>, CustomSingerAuditRepository {
}
