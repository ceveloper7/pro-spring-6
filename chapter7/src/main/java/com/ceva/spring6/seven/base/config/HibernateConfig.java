package com.ceva.spring6.seven.base.config;

import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Import(BasicDataSourceCfg.class) // importamos el bean dataSource desde el bean BasicDataSourceCfg
@Configuration
@ComponentScan(basePackages = {"com.ceva.spring6.seven.base"}) // indicamos a spring que scanee los componentes debajo del paquete base
@EnableTransactionManagement // permitimos transacciones
public class HibernateConfig {
    private static Logger LOGGER = LoggerFactory.getLogger(HibernateConfig.class);

    // importados el bean dataSource, hacemos un autowire
    @Autowired
    DataSource dataSource;

    /**
     * Detalles de la configuracion para Hibernate
     */
    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put(Environment.HBM2DDL_AUTO, "none");
        hibernateProp.put(Environment.FORMAT_SQL, false);
        hibernateProp.put(Environment.USE_SQL_COMMENTS, false);
        hibernateProp.put(Environment.SHOW_SQL, false);
        hibernateProp.put(Environment.MAX_FETCH_DEPTH, 3);
        hibernateProp.put(Environment.STATEMENT_BATCH_SIZE, 10);
        hibernateProp.put(Environment.STATEMENT_FETCH_SIZE, 50);
        return hibernateProp;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        // 1. Creamos una instancia del Session Factory
        var sessionFactory = new LocalSessionFactoryBean();
        // 2. Injectamos el dataSource
        sessionFactory.setDataSource(dataSource);
        // 3. Indicamos a Hibernate donde buscar los objetos del dominio
        sessionFactory.setPackagesToScan("com.ceva.spring6.seven.base.entities");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    /**
     * La fabrica de session de Hibernate requiere un administrador de Transacciones o HibernateTransaction Manager
     *
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        // creamos una instancia del Administrador de Transacciones
        // spring buscara el bean con el nombre transactionManager en el ApplicationContext
        var transactionManager =  new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
