package com.ceva.spring6.nine.repos;

import com.ceva.spring6.nine.entities.Album;
import com.ceva.spring6.nine.entities.Singer;
import com.ceva.spring6.nine.ex.TitleTooLongException;

import java.util.Set;
import java.util.stream.Stream;

public interface AlbumRepo {
    Stream<Album> findBySinger(Singer singer);

    Set<Album> save(Set<Album> albums) throws TitleTooLongException;

    Album save(Album album) throws TitleTooLongException;
}
