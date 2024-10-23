package com.ceva.spring6.six.rowmapper;

import com.ceva.spring6.six.plain.records.Album;
import com.ceva.spring6.six.plain.records.Singer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.ceva.spring6.six.QueryConstants.ALL_SELECT;
import static com.ceva.spring6.six.QueryConstants.ALL_JOIN_SELECT;

/**
 * La clase SingerMapper podria ser declarada como una clase interna static asi
 * podemos compartir RowMapper<Singer> entre multiples metodos de busqueda en la clase DAO
 *
 * Descripcion del funcionamiento de los metodos de busqueda:
 * 1. La clase RowMapperCfg se encarga de la configuracion para la conexion a una base de datos Mysql
 * 2.La clase de configuracion crea los beans dataSource, singerDao
 * 3. el bean singerDao provee la implementacion que es la clase RowMapperDao
 * 4. la clase que hace la prueba esa en test/com.ceva.spring6.six.rowmapper.JdbcRowMapperConfigTest
 */
public class RowMapperDao implements SingerDao{
    private NamedParameterJdbcTemplate namedTemplate;
    public void setNamedTemplate(NamedParameterJdbcTemplate namedTemplate) {

        this.namedTemplate = namedTemplate;
    }

    /**
     * se podria optar por incluir una clase static interna:
     * static class SingerMapper implements RowMapper<Singer> pero optamos aqui
     * por el implementar findAll() con lambda
     */
//    @Override
//    public Set<Singer> findAll() {
//        return new HashSet<>(namedTemplate.query(ALL_SELECT, (rs, rowNum) ->
//                new Singer(rs.getLong("id"),
//                        rs.getString("first_name"),
//                        rs.getString("last_name"),
//                        rs.getDate("birth_date").toLocalDate(),
//                        Set.of())
//        ));
//    }

    // en este caso la clase mapper no fue declarada como clase interna static pero llamamos a la clase SingerMapper
    @Override
    public Set<Singer> findAll() {
        return new HashSet<>(namedTemplate.query("SELECT * FROM singer", new SingerMapper()));
    }

    @Override
    public Set<Singer> findAllWithAlbums() {
        return namedTemplate.query(ALL_JOIN_SELECT, rs -> {
            Map<Long, Singer> map = new HashMap<>();
            Singer singer;
            while (rs.next()) {
                Long id = rs.getLong("id");
                singer = map.get(id);
                if (singer == null) {
                    singer = new Singer(id,rs.getString("first_name"),rs.getString("last_name"),
                            rs.getDate("birth_date").toLocalDate(),
                            new HashSet<>());
                    map.put(id, singer);
                }

                var albumId = rs.getLong("id");
                if (albumId > 0) {
                    Album album = new Album(albumId,id,rs.getString("title"),
                            rs.getDate("release_date").toLocalDate());
                    singer.albums().add(album);
                }
            }
            return new HashSet<>(map.values());
        });
    }

    // Obtenemos una lista de Singer con sus respectivos Album.
    // Aunque la clase SingerWithAlbumsExtractor no es realmente necesaria porque se podria pasar una expresion lambda.
    @Override
    public Set<Singer> findAllWithAlbumsUsingResultSetExtractor() {
        var sqlQuery = "SELECT s.id, s.first_name, s.last_name, s.birth_date, " +
                "a.id AS album_id, a.title, a.release_date " +
                "FROM singer s " +
                "RIGHT JOIN album a on s.id = a.singer_id";
        return new HashSet<>(namedTemplate.query(sqlQuery, new SingerWithAlbumsExtractor()));
    }

//    @Override
//    public Set<Singer> findAllWithAlbums(){
//        return new HashSet<>(namedTemplate.query(ALL_JOIN_SELECT, new SingerWithAlbumsExtractor()));
//    }

//    static class SingerWithAlbumsExtractor implements ResultSetExtractor<Set<Singer>>{
//        @Override
//        public Set<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
//            Map<Long, Singer> map = new HashMap<>();
//
//            Singer singer;
//            while (rs.next()) {
//                Long id = rs.getLong("singer_id");
//                singer = map.get(id);
//                if (singer == null) {
//                    singer = new Singer(id,
//                            rs.getString("first_name"),
//                            rs.getString("last_name"),
//                            rs.getDate("birth_date").toLocalDate(),
//                            Set.of());
//                    map.put(id, singer);
//                }
//
//
//                var albumId = rs.getLong("album_id");
//                if (albumId > 0) {
//                    Album album = new Album(albumId,id,rs.getString("title"),
//                            rs.getDate("release_date").toLocalDate()
//                    );
//                    singer.albums().add(album);
//                }
//            }
//            return new HashSet<>(map.values());
//        }
//    }
}
