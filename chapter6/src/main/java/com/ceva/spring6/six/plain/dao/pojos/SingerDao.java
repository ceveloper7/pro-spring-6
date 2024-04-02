package com.ceva.spring6.six.plain.dao.pojos;

import com.ceva.spring6.six.plain.dao.CoreDao;
import com.ceva.spring6.six.plain.pojos.Singer;

import java.util.Optional;
import java.util.Set;

/**
 * Interface que encapsula todos los metodos  de acceso de datos para la informacion de Singer
 * En lugar de DAO en spring se utiliza el termino Respository
 */
public interface SingerDao extends CoreDao {
    Set<Singer> findAll();

    Set<Singer> findByFirstName(String firstName);

    Optional<String> findNameById(Long id);

    Optional<String> findLastNameById(Long id);

    Optional<String> findFirstNameById(Long id);

    Singer insert(Singer singer);

    void update(Singer singer);

    void delete(Long singerId);

    Set<Singer> findAllWithAlbums();

    void insertWithAlbum(Singer singer);
}
