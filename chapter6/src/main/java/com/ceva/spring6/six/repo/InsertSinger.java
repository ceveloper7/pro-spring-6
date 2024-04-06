package com.ceva.spring6.six.repo;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;

import java.sql.Types;

import static com.ceva.spring6.six.QueryConstants.INSERT_SINGER;
public class InsertSinger extends SqlUpdate{
    public InsertSinger(DataSource dataSource) {
        super(dataSource, INSERT_SINGER);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birth_date", Types.DATE));
        // declaramos el nombre de la primary key de
        super.setGeneratedKeysColumnNames("singer_id");
        // indicamos al controlador JDBC que recupere la clave generada
        super.setReturnGeneratedKeys(true);
    }
}
