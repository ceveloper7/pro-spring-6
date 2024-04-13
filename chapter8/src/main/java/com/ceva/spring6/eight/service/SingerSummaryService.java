package com.ceva.spring6.eight.service;

import com.ceva.spring6.eight.view.SingerSummary;
import com.ceva.spring6.eight.view.SingerSummaryRecord;

import java.util.stream.Stream;

public interface SingerSummaryService {
    // consulta JPQL. incluimos keyword new para construir la clase SingerSummary
    String ALL_SINGER_SUMMARY_JPQL_QUERY ="""
            select new com.ceva.spring6.eight.view.SingerSummary(
            s.firstName, s.lastName, a.title) from Singer s
            left join s.albums a
            where a.releaseDate=(select max(a2.releaseDate) from Album a2 where a2.singer.id = s.id)
            """;

    String ALL_SINGER_SUMMARY_RECORD_JPQL_QUERY ="""
            select s.firstName, s.lastName, a.title from Singer s
            left join s.albums a 
            where a.releaseDate=(select max(a2.releaseDate) from Album a2 where a2.singer.id = s.id)
            """;

    Stream<SingerSummary> findAll();
    Stream<SingerSummaryRecord> findAllAsRecord();
}
