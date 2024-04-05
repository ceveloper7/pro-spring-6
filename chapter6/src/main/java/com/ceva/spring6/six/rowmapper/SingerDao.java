package com.ceva.spring6.six.rowmapper;

import com.ceva.spring6.six.plain.records.Singer;

import java.util.Set;

public interface SingerDao {
    Set<Singer> findAll();
    Set<Singer> findAllWithAlbums();
}
