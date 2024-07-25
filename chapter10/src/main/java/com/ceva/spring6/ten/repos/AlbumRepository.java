package com.ceva.spring6.ten.repos;

import com.ceva.spring6.ten.entities.Album;
import com.ceva.spring6.ten.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AlbumRepository extends JpaRepository<Album, Long>{
    Iterable<Album> findBySinger(Singer singer);

    Iterable<Album> findWithReleaseDateGreaterThan(LocalDate rd);

    // definimos una consulta con un parametro con nombre
    @Query("select a from Album a where a.title like %:title%")
    Iterable<Album> findByTitle(@Param("title") String t);
}
