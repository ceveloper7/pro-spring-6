package com.ceva.spring6.six.rowmapper;

import com.ceva.spring6.six.plain.records.Singer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * metodo mapRow() transforma los valores de un registro especifico de un ResultSet
 * en el objeto de dominio que deseemos, en este caso objeto Singer
 */
public class SingerMapper implements RowMapper<Singer> {
    @Override
    public  Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Singer(rs.getLong("singer_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("birth_date").toLocalDate(),
                Set.of());
    }
}
