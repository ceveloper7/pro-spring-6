package com.ceva.spring6.six.plain;

import com.ceva.spring6.six.config.BasicDataSourceCfg;
import com.ceva.spring6.six.plain.datasourcecfg_test.SingerDao;
import com.ceva.spring6.six.plain.datasourcecfg_test.SpringDatasourceCfg;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ceva.spring6.six.config.SimpleDataSourceCfg;
public class DataSourceConfigTest {
    private static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfigTest.class);

    // Test la clase de configuracion SimpleDataSource
    private void testDataSource(DataSource dataSource) throws SQLException{
        // con el bean dataSource obtenido del contexto creamos una conexion.
        try (var connection = dataSource.getConnection();
             // Probamos la conexion
             var statement = connection.prepareStatement("SELECT 1 AS COLUMN1");
             var resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                int mockVal = resultSet.getInt("COLUMN1");
                assertEquals(1, mockVal);
            }
        } catch (Exception e) {
            LOGGER.debug("Something unexpected happened.", e);
        }
    }

    /*
     * Probamos la clase SimpleDataSourceConfig.class
     */
    @Test
    public void testSimpleDataSource() throws SQLException {
        var ctx = new AnnotationConfigApplicationContext(SimpleDataSourceCfg.class);
        // obtenemos el bean dataSource del contexto
        var dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        ctx.close();
    }

    @Test
    public void testBasicDataSource() throws SQLException {
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class);
        var dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        ctx.close();
    }

    // test de com.ceva.spring6.six.plain.datasourcecfg_test.SpringDatasourceCfg
    @Test
    public void testSpringJdbc() throws SQLException {
        var ctx = new AnnotationConfigApplicationContext(SpringDatasourceCfg.class);
        var dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        var singerDao = ctx.getBean("singerDao", SingerDao.class);
        assertEquals("John Butler", singerDao.findNameById(4L));
        ctx.close();
    }

    @Test
    public void testSpringJdbcHybrid()throws SQLException {
        var ctx = new AnnotationConfigApplicationContext(com.ceva.spring6.six.hybrid.SpringDatasourceCfg.class);
        var dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        var singerDao = ctx.getBean("singerDao", com.ceva.spring6.six.hybrid.SingerDao.class);
        assertEquals("John Butler", singerDao.findNameById(4L));
        ctx.close();
    }
}
