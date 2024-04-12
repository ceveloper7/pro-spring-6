package com.ceva.spring6.eight.service;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

import com.ceva.spring6.eight.entities.Singer;

/**
 * en una app multicapa las clases service dependen de las clases repository y los bean
 * services que normalmente estan anotados con @Transactional
 */

// identificamos la clase como un componente que ofrece business services a otra capa
// asigna al bean el nombre jpaSingerService.
@Service("jpaSingerService")
// indicamos que la clase contiene logica de acceso a datos e indica a spring que
// que traduzca las excepciones especificas.
@Repository
@Transactional // se utiliza para definir requisitos de transaccion.
public class SingerServiceImpl implements SingerService{
    private static final Logger LOGGER = LoggerFactory.getLogger(SingerServiceImpl.class);

    // anotacion que permite inyectar EntityManager. Si tenemos varias unidades de
    // persistencia en el contexto podemos agregar el atributo unitName a la anotacion
    // para indicar que unidad de persistencia queremos inyectar
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public Stream<Singer> findAll() {
        return em.createNamedQuery(Singer.FIND_ALL, Singer.class)
                .getResultList().stream();
    }

    @Transactional(readOnly=true)
    @Override
    public Stream<Singer> findAllWithAlbum() {
        return em.createNamedQuery(Singer.FIND_ALL_WITH_ALBUM, Singer.class)
                .getResultList().stream();
    }

    @Transactional(readOnly=true)
    @Override
    public Optional<Singer> findById(Long id) {
        TypedQuery<Singer> query = em.createNamedQuery(Singer.FIND_SINGER_BY_ID, Singer.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Singer singer) {
        if (singer.getId() == null) {
            LOGGER.info("Inserting new singer");
            em.persist(singer);
        } else {
            em.merge(singer);
            LOGGER.info("Updating existing singer");
        }
    }

    @Override
    public void delete(Singer singer) {
        var mergedContact = em.merge(singer);
        em.remove(mergedContact);

        LOGGER.info("Singer with id: " + singer.getId()  + " deleted successfully");
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public Stream<Singer> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, "singerResult").getResultList().stream();
    }

    @Override
    public String findFirstNameById(Long id) {
        return em.createNamedQuery("Singer.getFirstNameById(?)")
                .setParameter(1, id).getSingleResult().toString();
    }

    @Override
    public String findFirstNameByIdUsingProc(Long id) {
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("getFirstNameByIdProc");
        query.setParameter( "in_id", 1L );

        query.execute();
        return (String) query.getOutputParameterValue( "fn_res" );
    }
}