package com.ceva.spring6.six.plain.datasourcecfg_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.sql.SQLException;

import static com.ceva.spring6.six.QueryConstants.FIND_NAME;

/**
 * Clase de Implementacion concreta de la interface SingerDao
 */
public class JdbcSingerDao implements SingerDao, InitializingBean {
    private static Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao.class);
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String findNameById(Long id) {
        var result = "";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(FIND_NAME + id);
             var resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                return resultSet.getString("first_name") + " " + resultSet.getString("last_name");
            }

        } catch (SQLException ex) {
            LOGGER.error("Problem when executing SELECT!",ex);
        }
        return result;
    }

    /**
     * Nos aseguamos que se hayan configurado todas las propiedades requeridas en el bean
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on SingerDao");
        }
    }
}
