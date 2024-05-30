package com.ceva.spring6.nine.repos;

import com.ceva.spring6.nine.entities.Singer;

import java.util.Optional;
import java.util.stream.Stream;

public interface SingerRepo {
    Stream<Singer> findAll();

    Optional<Singer> findById(Long id);

    Optional<Singer> findByFirstNameAndLastName(String fn, String ln);

    Long countAllSingers();

    Singer save(Singer singer);
}
