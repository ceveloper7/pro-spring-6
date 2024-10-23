package com.ceva.spring6.six.rowmapper;

import com.ceva.spring6.six.config.BasicDataSourceCfg;
import com.ceva.spring6.six.rowmapper.RowMapperDao;
import com.ceva.spring6.six.rowmapper.SingerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Import(BasicDataSourceCfg.class)
@Configuration
public class RowMapperCfg {
    @Autowired
    DataSource dataSource;

    @Bean
    public NamedParameterJdbcTemplate namedTemplate(){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public SingerDao singerDao(){
        var dao = new RowMapperDao();
        dao.setNamedTemplate(namedTemplate());
        return dao;
    }
}
