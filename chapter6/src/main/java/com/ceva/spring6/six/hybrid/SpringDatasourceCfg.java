package com.ceva.spring6.six.hybrid;

import com.ceva.spring6.six.config.BasicDataSourceCfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


import javax.sql.DataSource;

@Import(BasicDataSourceCfg.class)
@Configuration
public class SpringDatasourceCfg {
    @Autowired
    DataSource dataSource;

    @Bean
    public SingerDao singerDao(){
        JdbcSingerDao dao = new JdbcSingerDao();
        dao.setDataSource(dataSource);
        return dao;
    }
}
