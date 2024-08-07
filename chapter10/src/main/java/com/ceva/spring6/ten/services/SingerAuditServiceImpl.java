package com.ceva.spring6.ten.services;

import com.ceva.spring6.ten.entities.SingerAudit;
import com.ceva.spring6.ten.repos.SingerAuditRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {
    private final SingerAuditRepository singerAuditRepository;

    //@PersistenceContext
    //private EntityManager entityManager;

    public SingerAuditServiceImpl(SingerAuditRepository singerAuditRepository) {
        this.singerAuditRepository = singerAuditRepository;
    }

    @Transactional(readOnly=true)
    @Override
    public Stream<SingerAudit> findAll() {
        return StreamSupport.stream(singerAuditRepository.findAll().spliterator(), false);
    }

    @Transactional(readOnly=true)
    @Override
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).orElse(null);
    }

    @Override
    public SingerAudit save(SingerAudit singer) {
        return singerAuditRepository.saveAndFlush(singer);
    }

    @Override
    public void delete(Long id) {
        singerAuditRepository.deleteById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public SingerAudit findAuditByRevision(Long id, int revision) {
        //var auditReader = AuditReaderFactory.get(entityManager);
        //return auditReader.find(SingerAudit.class, id, revision);
        return singerAuditRepository.findAuditByIdAndRevision(id, revision).orElse(null);
    }
}
