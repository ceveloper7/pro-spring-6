package com.ceva.spring6.six.repo;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

import static com.ceva.spring6.six.QueryConstants.INSERT_SINGER_ALBUM;

/**
 * BatchSqlUpdate pone el cola las operaciones de insercion y las envia a la BD por lotes
 * Cada vez que la cantidad de registros sea igual al tamano del lote,
 * Spring ejecutara una operacion de insercion masiva en la BD para los registros pendientes
 */
public class InsertSingerAlbum extends BatchSqlUpdate{
    private static final int BATCH_SIZE = 10;

    public InsertSingerAlbum(DataSource dataSource) {
        super(dataSource, INSERT_SINGER_ALBUM);
        declareParameter(new SqlParameter("singer_id", Types.INTEGER));
        declareParameter(new SqlParameter("title", Types.VARCHAR));
        declareParameter(new SqlParameter("release_date", Types.DATE));
        // establecemos el tamano del lote
        setBatchSize(BATCH_SIZE);
    }
}
