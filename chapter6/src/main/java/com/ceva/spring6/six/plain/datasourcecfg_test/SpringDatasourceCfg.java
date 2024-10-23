package com.ceva.spring6.six.plain.datasourcecfg_test;

import com.ceva.spring6.six.config.BasicDataSourceCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;


@Import(BasicDataSourceCfg.class)
@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.six.plain.datasourcecfg_test")
public class SpringDatasourceCfg {
    @Autowired
    DataSource dataSource;

    @Bean
    public SingerDao singerDao(){
        JdbcSingerDao dao = new JdbcSingerDao();
        // Creamos el bean SingerDao por medio de una instancia JdbcSingerDao
        dao.setDataSource(dataSource);
        return dao;
    }
}
