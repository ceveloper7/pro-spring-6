package com.ceva.spring6.six.repo;

import com.ceva.spring6.six.plain.records.Singer;
import com.ceva.spring6.six.plain.records.Album;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.ceva.spring6.six.QueryConstants.FIND_SINGER_ALBUM;

/**
 * La anotacion @Repository se utiliza en bean que manejan operaciones de BD
 * Tambien @Repository le indica a Spring que realice excepciones SQL especificas
 * de la BD
 */
@Repository("singerRepo")
public class SingerJdbcRepo implements SingerRepo{

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerJdbcRepo.class);
    private DataSource dataSource;
    private SelectAllSingers selectAllSingers;
    private SelectSingerByFirstName selectSingerByFirstName;
    private SelectSingerById selectSingerById;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllSingers = new SelectAllSingers(dataSource);
        this.selectSingerByFirstName = new SelectSingerByFirstName(dataSource);
        this.selectSingerById = new SelectSingerById(dataSource);
    }
    public DataSource getDataSource() {
        return dataSource;
    }
    @Override
    public List<Singer> findAll() {
        return selectAllSingers.execute();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return selectSingerByFirstName.executeByNamedParam(Map.of("first_name", firstName));
    }

    @Override
    public String findNameById(Long id) {
        return selectSingerById.executeByNamedParam(Map.of("singer_id", id)).toString();
    }

    @Override
    public Optional<String> findLastNameById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<String> findFirstNameById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        return null;
    }

    @Override
    public void insert(Singer singer) {

    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }
}
