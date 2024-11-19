package com.ceva.spring6.six.plain.datasourcecfg_test;

import com.ceva.spring6.six.config.BasicDataSourceCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

// BasicDataSourceCfg crea el bean dataSource
@Import(BasicDataSourceCfg.class)
@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.six.plain.datasourcecfg_test")
public class SpringDatasourceCfg {
    // inyectamos el bean dataSource
    @Autowired
    DataSource dataSource;

    // creamos el bean SingerDao
    @Bean
    public SingerDao singerDao(){
        JdbcSingerDao dao = new JdbcSingerDao();
        // configuramos el dataSource
        dao.setDataSource(dataSource);
        return dao;
    }
}
