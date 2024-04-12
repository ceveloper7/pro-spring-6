package com.ceva.spring6.eight.config;

import org.hibernate.cfg.Environment;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * La clase JpaConfig contiene la declaracion de una serie de Bean para soportar
 * la configuracion de LocalContainerEntityManagerFactoryBean con Hibernate
 */
@Import(BasicDataSourceCfg.class)
@Configuration
@EnableTransactionManagement // permite la declaraciones de transacciones por anotacion.
@ComponentScan(basePackages = "com.ceva.spring6.eight.service")// scan los componente del paquete
public class JpaConfig {
    // inyectamos el bean dataSource que proviene de BasicDataSourceCfg
    @Autowired
    DataSource dataSource;

    @Bean
    public PlatformTransactionManager transactionManager() {
        // obtenemos una instancia del administrador de transacciones par acceso a datos
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        // creamos una instancia de EntityManagerFactory
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    // como usamos Hibernate como proveedor, creamos una instancia de HibernateJpaVendorAdapter
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    // detalles de la configuracion para el proveedor de persistencia Hibernate
    @Bean
    public Properties jpaProperties() {
        Properties jpaProps = new Properties();
        jpaProps.put(Environment.HBM2DDL_AUTO, "none");
        jpaProps.put(Environment.FORMAT_SQL, false);
        jpaProps.put(Environment.USE_SQL_COMMENTS, false);
        jpaProps.put(Environment.SHOW_SQL, false);
        return jpaProps;
    }

    // LocalContainerEntityManagerFactoryBean es la parte mas importante de esta configuracion
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        var factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        // escaneamos las clases del dominio.
        factory.setPackagesToScan("com.ceva.spring6.eight.entities");
        factory.setDataSource(dataSource);
        factory.setJpaProperties(jpaProperties());
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        return factory;
    }
}
