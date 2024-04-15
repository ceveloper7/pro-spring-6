package com.ceva.spring6.eight.service;

import com.ceva.spring6.eight.entities.Singer_;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.StringUtils;
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
        // antes de guardar verificamos si el objeto es una nueva instancia de entidad
        if (singer.getId() == null) {
            // no hay un id asignado
            LOGGER.info("Inserting new singer");
            // persistimos la entidad y se convierte en entidad administrada en el contexto
            em.persist(singer);
        } else {
            // el id existe,
            em.merge(singer);
            LOGGER.info("Updating existing singer");
        }
    }

    @Override
    public void delete(Singer singer) {
        var mergedContact = em.merge(singer);
        // eliminamos el registro con toda su informacion asociada incluido Album, Instrument
        // ya que se especifico cascade=CascadeType.ALL
        em.remove(mergedContact);

        LOGGER.info("Singer with id: " + singer.getId()  + " deleted successfully");
    }

    // Consulta nativa Simple y SQL ResultSet
    @SuppressWarnings({"unchecked"})
    @Override
    public Stream<Singer> findAllByNativeQuery() {
        //return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY).getResultList().stream();

        // JPA transforma el resultSet en instancias de la entidad Singer
        // la ejecucion del metodo produce el mismo resultado que el metodo FindAll()
        return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, "singerResult").getResultList().stream();
    }

    // ejecutando Stored function
    @Override
    public String findFirstNameById(Long id) {
        return em.createNamedQuery("Singer.getFirstNameById(?)")
                .setParameter(1, id).getSingleResult().toString();
    }

    // ejecutando Stored Procedure
    @Override
    public String findFirstNameByIdUsingProc(Long id) {
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("getFirstNameByIdProc");
        query.setParameter( "in_id", 1L );

        query.execute();
        return (String) query.getOutputParameterValue( "fn_res" );
    }

    @Override
    public Stream<Singer> findByCriteriaQuery(String firstName, String lastName){
        LOGGER.info("Finding singer for firstName: " + firstName + " and lastName: " + lastName);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Singer> criteriaQuery = cb.createQuery(Singer.class);
        Root<Singer> singerRoot = criteriaQuery.from(Singer.class);
        singerRoot.fetch(Singer_.albums, JoinType.LEFT);
        singerRoot.fetch(Singer_.instruments, JoinType.LEFT);
        criteriaQuery.select(singerRoot).distinct(true);

        Predicate criteria = cb.conjunction();
        if (StringUtils.isNotBlank(firstName)) {
            Predicate firstNamePredicate = cb.equal(singerRoot.get(Singer_.firstName), firstName);
            criteria = cb.and(criteria, firstNamePredicate);
        }
        if (StringUtils.isNotBlank(lastName)) {
            Predicate lastNamePredicate = cb.equal(singerRoot.get(Singer_.lastName), lastName);
            criteria = cb.and(criteria, lastNamePredicate);
        }
        criteriaQuery.where(criteria);
        return em.createQuery(criteriaQuery).getResultList().stream();
    }

}
