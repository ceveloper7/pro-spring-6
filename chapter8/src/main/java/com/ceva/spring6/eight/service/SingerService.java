package com.ceva.spring6.eight.service;

import java.util.Optional;
import java.util.stream.Stream;

import com.ceva.spring6.eight.entities.Singer;
public interface SingerService {
    String ALL_SINGER_NATIVE_QUERY =
            "select ID, FIRST_NAME, LAST_NAME, BIRTH_DATE, VERSION from SINGER";

    Stream<Singer> findAll();
    Stream<Singer> findAllWithAlbum();
    Optional<Singer> findById(Long id);

    // save permite insertar como actualizar.
    void save(Singer singer);
    void delete(Singer singer);

    Stream<Singer> findAllByNativeQuery();

    String findFirstNameById(Long id);

    String findFirstNameByIdUsingProc(Long id);
}
