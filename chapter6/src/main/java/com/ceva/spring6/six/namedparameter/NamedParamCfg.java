package com.ceva.spring6.six.namedparameter;

import com.ceva.spring6.six.config.BasicDataSourceCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Import(BasicDataSourceCfg.class)
@Configuration
public class NamedParamCfg {
    @Autowired
    DataSource dataSource;

    // bean de tipo NamedParameterJdbcTemplate que nos permite asignarle un nombre a cada parametro.
    @Bean
    public NamedParameterJdbcTemplate namedTemplate(){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public SingerDao singerDao(){
        var dao = new NamedTemplateDao();
        // inyectamos el bean en el DAO
        dao.setNamedTemplate(namedTemplate());
        return dao;
    }
}
