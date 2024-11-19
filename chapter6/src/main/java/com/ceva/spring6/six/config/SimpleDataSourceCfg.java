package com.ceva.spring6.six.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

/*
 * La diferencia entre un java.sql.Connection y una javax.sql.DataSource es que DataSource proporciona y administra conexiones a diferencia de
 * Connection que solo proporciona una conexion a la BD.
 * SimpleDriverDataSource no admite pool de conexiones a BD, lo que hace a esta clase no sea adecuada para
 * nada mas que prueba
 */

@Configuration
@PropertySource("classpath:db/jdbc.properties") // spring inyecta las propiedades del archivo en la clase de configuracion.
public class SimpleDataSourceCfg {
    private static Logger LOGGER = LoggerFactory.getLogger(SimpleDataSourceCfg.class);
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    @SuppressWarnings("unchecked")
    public DataSource dataSource() {
        try {
            var dataSource = new SimpleDriverDataSource();
            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
            dataSource.setDriverClass(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            LOGGER.error("Simple DataSource bean cannot be created!", e);
            return null;
        }
    }
}
