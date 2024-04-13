package com.ceva.spring6.eight.service;

import com.ceva.spring6.eight.view.SingerSummary;
import com.ceva.spring6.eight.view.SingerSummaryRecord;

import java.util.stream.Stream;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("singerSummaryService")
@Repository
@Transactional(readOnly = true)
public class SingerSummaryServiceImpl implements SingerSummaryService{
    @PersistenceContext
    private EntityManager em;
    @Override
    public Stream<SingerSummary> findAll() {
        // Asignamos el ResultSet a la clase SingerSummary para crear POJO
        return em.createQuery(ALL_SINGER_SUMMARY_JPQL_QUERY, SingerSummary.class).getResultList().stream();
    }

    @Override
    public Stream<SingerSummaryRecord> findAllAsRecord() {
        // old style
        /* return em.createQuery(ALL_SINGER_SUMMARY_RECORD_JPQL_QUERY).getResultList().stream().
                map(obj ->  {
                    Object[] values = (Object[]) obj;
                    return new SingerSummaryRecord((String) values[0],(String) values[1], (String) values[2]);
                });*/

        return em.createQuery(ALL_SINGER_SUMMARY_RECORD_JPQL_QUERY, Tuple.class).getResultList().stream().
                map(tuple ->
                        // creamos un registro llamado SingerSummaryRecord
                        new SingerSummaryRecord(
                                tuple.get(0, String.class),
                                tuple.get(1, String.class),
                                tuple.get(2, String.class))
                );
    }
}
