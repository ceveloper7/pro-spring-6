package com.ceva.spring6.six.repo;

import com.ceva.spring6.six.plain.records.Singer;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Set;

import static com.ceva.spring6.six.QueryConstants.FIND_BY_ID;
public class SelectSingerById extends MappingSqlQuery{
    public SelectSingerById(DataSource dataSource) {
        super(dataSource, FIND_BY_ID);
        super.declareParameter(new SqlParameter("singer_id",Types.INTEGER));
    }
    @Override
    protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Singer(rs.getLong("singer_id"),rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("birth_date").toLocalDate(),
                Set.of());
    }
}
