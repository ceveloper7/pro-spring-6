package com.ceva.spring6.seven.base.dao;

import com.ceva.spring6.seven.base.entities.Singer;
import com.ceva.spring6.seven.base.entities.Album;
import com.ceva.spring6.seven.base.entities.Instrument;

import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.Tuple;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.Types;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Transactional
@Repository("singerDao") // Declaramos la clase como Bean con la anotacion @Repository
public class SingerDaoImpl implements SingerDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(SingerDaoImpl.class);

    // Spring conecta la propiedad sessionFactory mediante el constructor
    private SessionFactory sessionFactory;

    public SingerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Singer s", Singer.class).list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        // usamos el NamedQuery
        return sessionFactory.getCurrentSession().createNamedQuery("Singer.findAllWithAlbum", Singer.class).list();
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        return sessionFactory.getCurrentSession().createNamedQuery("Singer.findById", Singer.class).setParameter("id", id).uniqueResult();
    }

    @Override
    public Singer save(Singer singer) {
        return null;
    }

    @Override
    public void delete(Singer singer) {

    }

    @Override
    public Singer findAllDetails(String firstName, String lastName) {
        return null;
    }

    @Override
    public Set<String> findAllNamesByProjection() {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameByIdUsingProc(Long id) {
        return null;
    }
}
