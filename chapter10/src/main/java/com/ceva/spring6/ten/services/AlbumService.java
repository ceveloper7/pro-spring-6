package com.ceva.spring6.ten.services;

import com.ceva.spring6.ten.entities.Album;
import com.ceva.spring6.ten.entities.Singer;

import java.time.LocalDate;
import java.util.stream.Stream;

public interface AlbumService {
    Stream<Album> findBySinger(Singer singer);

    Stream<Album> findWithReleaseDateGreaterThan(LocalDate rd);

    Stream<Album> findByTitle(String title);

}
