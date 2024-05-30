package com.ceva.spring6.nine.services;

import com.ceva.spring6.nine.entities.Album;
import com.ceva.spring6.nine.entities.Singer;
import com.ceva.spring6.nine.ex.TitleTooLongException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public interface AllService {
    Optional<Singer> findByIdWithAlbums(Long id);
    Stream<Singer> findAllWithAlbums();

    void update(Singer singer);

    void saveSingerWithAlbums(Singer s, Set<Album> albums) throws TitleTooLongException;

    Long countSingers();
}
