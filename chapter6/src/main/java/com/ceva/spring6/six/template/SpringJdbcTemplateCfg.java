package com.ceva.spring6.six.template;

import com.ceva.spring6.six.config.BasicDataSourceCfg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Import(BasicDataSourceCfg.class)
@Configuration
public class SpringJdbcTemplateCfg {
    @Autowired
    DataSource dataSource;

    // Inicializamos una unica instancia de JdbcTemplate y la inyectamos en todos los objetos DAO
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public SingerDao singerDao(){
        JdbcSingerDao dao = new JdbcSingerDao();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
