package com.ceva.spring6.four.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * el metodo shaDigest() muestra la configuracion para una clase MessageDigestFactoryBean
 * con un algoritmo SHA1
 * el metodo defaultDigest() muestra la configuracion para una clase MessageDigestFactoryBean
 * con el algoritmo predeterminado que es MD5
 */
@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.factory")
public class MessageDigestConfig {
    @Bean
    public MessageDigestFactoryBean shaDigest(){
        MessageDigestFactoryBean shaDigest =  new MessageDigestFactoryBean();
        shaDigest.setAlgorithmName("SHA1");
        return shaDigest;
    }

    /**
     * Para defaultDigest no se especifica la propiedad setAlgorithmName por lo que
     * se utilizara el algoritmo predeterminado MD5
     */
    @Bean
    public MessageDigestFactoryBean defaultDigest(){
        return  new MessageDigestFactoryBean();
    }

    /**
     * Configuramos la clase MessageDigester utilizando las dos clases
     * MessageDigestFactoryBean
     */
    @Bean
    public MessageDigester digester() throws Exception {
        MessageDigester messageDigester = new MessageDigester();
        // llamamos al bean shaDigest
        messageDigester.setDigest1(shaDigest().getObject());
        messageDigester.setDigest2(defaultDigest().getObject());
        return messageDigester;
    }
}
