package com.ceva.spring6.six.repo;

import com.ceva.spring6.six.plain.records.Singer;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import static com.ceva.spring6.six.QueryConstants.ALL_SELECT;

/**
 * La clase abstracta MappingSqlQuery permite modelar operaciones de consulta
 */
public class SelectAllSingers extends MappingSqlQuery<Singer> {

    public SelectAllSingers(DataSource dataSource) {
        super(dataSource, ALL_SELECT);
    }

    // metodo mapRow() permite asignar cada registro del ResultSet al objeto de dominio.
    @Override
    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Singer(rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("birth_date").toLocalDate(),
                Set.of());
    }
}
