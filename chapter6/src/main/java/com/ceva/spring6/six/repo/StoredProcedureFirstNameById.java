package com.ceva.spring6.six.repo;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Heredamos la clase SqlFunction para llamar al procedimiento almacenado aunque
 * Spring posee la clase StoredProcedure para operar con esos objetos.
 */
public class StoredProcedureFirstNameById extends SqlFunction<String>{
    private static final String SQL_CALL = "CALL getFirstNameById(?)";

    public StoredProcedureFirstNameById(DataSource dataSource){
        super(dataSource, SQL_CALL);
        declareParameter(new SqlParameter(Types.INTEGER));
        compile();
    }
}
