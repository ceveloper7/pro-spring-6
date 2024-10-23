package com.ceva.spring6.six.rowmapper;

import com.ceva.spring6.six.plain.records.Album;
import com.ceva.spring6.six.plain.records.Singer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * metodo extractData obtenemos un ResultSet y la convertirmos en una lista de registros
 * que contienen los cantantes con sus respectivos albumes producidos.
 */
public class SingerWithAlbumsExtractor implements ResultSetExtractor<Set<Singer>> {
    @Override
    public Set<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Singer> map = new HashMap<>();
        Singer singer;
        while (rs.next()) {
            Long singer_id = rs.getLong("id");
            singer = map.get(singer_id);
            if (singer == null) {
                singer = new Singer(singer_id,
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        Set.of());
                map.put(singer_id, singer);
            }

            var albumId = rs.getLong("id");
            if (albumId > 0) {
                Album album = new Album(albumId,singer_id,rs.getString("title"),
                        rs.getDate("release_date").toLocalDate()
                );
                singer.albums().add(album);
            }
        }
        return new HashSet<>(map.values());
    }
}
