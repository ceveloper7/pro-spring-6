package com.ceva.spring6.six.repo;

import com.ceva.spring6.six.plain.records.Singer;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import static com.ceva.spring6.six.QueryConstants.FIND_BY_FIRST_NAME;

public class SelectSingerByFirstName extends MappingSqlQuery<Singer>{
    public SelectSingerByFirstName(DataSource dataSource) {
        super(dataSource, FIND_BY_FIRST_NAME);
        // especificamos first_name param
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
    }

    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Singer(rs.getLong("id"),rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("birth_date").toLocalDate(),
                new HashSet<>()
                //Set.of()
        );
    }
}
