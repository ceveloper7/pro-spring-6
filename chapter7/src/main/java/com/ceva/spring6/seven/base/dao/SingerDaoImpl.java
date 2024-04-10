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

    /**
     * Escribir consultas HQL complejas suele ser muy dificil por no decir imposible en
     * Hibernate. Hibernat permite escribir consultas nativas SQL usando el metodo
     * createNativeQuery().
     * ALL_SELECT utiliza parametros con nombres.
     */
    private static final String ALL_SELECT = """
            select distinct s.FIRST_NAME, s.LAST_NAME, a.TITLE, a.RELEASE_DATE, i.INSTRUMENT_ID
            from SINGER s
            inner join ALBUM a on s.singer_id = a.SINGER_ID
            inner join SINGER_INSTRUMENT si on s.singer_id = si.SINGER_ID
            inner join INSTRUMENT i on si.INSTRUMENT_ID = i.INSTRUMENT_ID
            where s.FIRST_NAME = :firstName and s.LAST_NAME= :lastName
            """;

    @Transactional
    @Override
    public Singer findAllDetails(String firstName, String lastName) {
        List<Tuple> results = sessionFactory.getCurrentSession()
                .createNativeQuery(ALL_SELECT, Tuple.class)
                // proporcionamos los valores para los parametros
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .list();

        var singer = new Singer();

        for (Tuple item : results) {
            if (singer.getFirstName() == null && singer.getLastName() == null) {
                singer.setFirstName((String) item.get("FIRST_NAME"));
                singer.setLastName((String) item.get("LAST_NAME"));
            }
            var album = new Album();
            album.setTitle((String) item.get("TITLE"));
            album.setReleaseDate(((Date) item.get("RELEASE_DATE")).toLocalDate());
            singer.addAlbum(album);

            var instrument = new Instrument();
            instrument.setInstrumentId((String) item.get("INSTRUMENT_ID"));
            singer.getInstruments().add(instrument);
        }

        return singer;
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

    @Transactional
    @Override
    public Singer save(Singer singer) {
        var session = sessionFactory.getCurrentSession();
        if (singer.getId() == null) {
            session.persist(singer);
        } else {
            session.merge(singer);
        }
        LOGGER.info("Singer saved with id: " + singer.getId());
        return singer;
    }

    /**
     * Este metodo va a eliminar un singer con su informacion relacionada como
     * album e instrumentos
     */
    @Transactional
    @Override
    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().remove(singer);
        LOGGER.info("Singer deleted with id: " + singer.getId());
    }

    /**
     * al consultar tabla no siempre es necesario recuperar un registro completo.
     * la operacion de consultar solo un subconjunto de columnas se llama proyeccion
     */
    @Transactional(readOnly = true)
    @Override
    public Set<String> findAllNamesByProjection() {
        List<Tuple> projResult = sessionFactory.getCurrentSession()
                .createQuery("select s.firstName as fn, s.lastName as ln from Singer s", Tuple.class)
                .getResultList();

        return projResult.stream().map(tuple -> tuple.get("fn", String.class) + " " + tuple.get("ln", String.class))
                .collect(Collectors.toSet());
    }

    // Llamando a la funcion getFirstNameById
    @Transactional
    @Override
    public String findFirstNameById(Long id) {
        final AtomicReference<String> firstNameResult = new AtomicReference<>();
        sessionFactory.getCurrentSession().doWork(connection -> {
            try (CallableStatement function = connection.prepareCall(
                    "{ ? = call getFirstNameById(?) }")) {
                function.registerOutParameter(1, Types.VARCHAR);
                function.setLong(2, id);
                function.execute();
                firstNameResult.set(function.getString(1));
            }
        });
        return firstNameResult.get();
    }

    @Transactional(readOnly = true)
    @Override
    public String findFirstNameByIdUsingProc(Long id) {
        ProcedureCall procedureCall =
                sessionFactory.getCurrentSession()
                        .createNamedStoredProcedureQuery("getFirstNameById");
        procedureCall.setParameter("in_id", id);
        procedureCall.setParameter("fn_res", "");
        procedureCall.execute();
        return  procedureCall.getOutputParameterValue("fn_res").toString();
    }
}
