package com.ceva.spring6.nine.config;

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
 * Usamos JPA con Hibernate como capa de persistencia para la logica de acceso a datos. Esta configuracion es similar al capitulo 7
 * Cons esta clas de configuracion cualquier metodo que interactue con la capa de datos puede usar la anotacion @Transactional y el contenedor
 * Spring IoC abrira una transaccion antes de la ejecucion del metodo y la cerrar inmediatamente despues.
 */

@Import(BasicDataSourceCfg.class)
@Configuration
@EnableTransactionManagement // habilitamos la capacidad de transacciones basadas en anotaciones
@ComponentScan(basePackages = {"com.ceva.spring6.nine.repos", "com.ceva.spring6.nine.services"})
public class TransactionCfg {
    @Autowired
    DataSource dataSource;

    @Bean
    public PlatformTransactionManager transactionManager() {
        // usamos JPA para administrar las transacciones
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        var factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setPackagesToScan("com.ceva.spring6.nine.entities");
        factory.setDataSource(dataSource);
        factory.setJpaProperties(jpaProperties());
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        return factory;
    }

    @Bean
    public Properties jpaProperties() {
        Properties jpaProps = new Properties();
        jpaProps.put(Environment.HBM2DDL_AUTO, "none");
        jpaProps.put(Environment.FORMAT_SQL, false);
        jpaProps.put(Environment.STATEMENT_BATCH_SIZE, 30);
        jpaProps.put(Environment.USE_SQL_COMMENTS, false);
        jpaProps.put(Environment.SHOW_SQL, false);
        return jpaProps;
    }
}
