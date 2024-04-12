package com.ceva.spring6.eight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;


@Configuration
public class JndiDataSourceCfg {
    @Bean
    public DataSource dataSource() {
        var dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("persistence/prospring6PersistenceUnit");
    }

   /* @Bean
    public JndiObjectFactoryBean jndiFactory() throws NamingException {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setJndiName("persistence/prospring6PersistenceUnit");
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        jndiObjectFactoryBean.afterPropertiesSet();
        return jndiObjectFactoryBean;
    }*/

   /* @Bean
    public DataSource jndiFactory() throws NamingException {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setJndiName("persistence/prospring6PersistenceUnit");
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        jndiObjectFactoryBean.afterPropertiesSet();
        return (DataSource) jndiObjectFactoryBean.getObject();
    }*/
}
