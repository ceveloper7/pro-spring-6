package com.ceva.spring6.nine.repos;

import com.ceva.spring6.nine.entities.Album;
import com.ceva.spring6.nine.entities.Singer;
import com.ceva.spring6.nine.ex.TitleTooLongException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Repository
public class AlbumRepoImpl implements AlbumRepo{
    @PersistenceContext
    private EntityManager em;

    // jpaProperties declarado en TransacctionCfg
    @Value("#{jpaProperties.get('hibernate.jdbc.batch_size')}")
    private int batchSize;

    @Override
    public Stream<Album> findBySinger(Singer singer) {
        return  em.createNamedQuery(Album.FIND_ALL, Album.class)
                .setParameter("singer", singer)
                .getResultList().stream();
    }

    // version de save() que hace escritura por lotes.
    @Override
    public Set<Album> save(Set<Album> albums) throws TitleTooLongException {
        final Set<Album> savedAlbums = new HashSet<>();
        int i = 0;
        for (Album a : albums) {
            if(50 < a.getTitle().length()) {
                throw  new TitleTooLongException("Title "+ a.getTitle() + "too long!");
            }
            savedAlbums.add(save(a));
            i++;
            if (i % batchSize == 0) {
                // Flush a batch of inserts and release memory.
                em.flush();
                em.clear();
            }
        }
        return savedAlbums;
    }

    @Override
    public Album save(Album album) throws TitleTooLongException {
        // si el titulo del album es superior a 50 caracteres lanzamos una excepcion.
        if (50 < album.getTitle().length()) {
            throw  new TitleTooLongException("Title "+ album.getTitle() + "too long!");
        }
        if (album.getId() == null) {
            em.persist(album);
            return album;
        } else {
            return em.merge(album);
        }
    }
}
