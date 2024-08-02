package com.ceva.spring6.eleven;

import com.ceva.spring6.eleven.domain.Blogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.URL;
import java.time.LocalDate;

// configuracion del archivo de prpopiedades.
@PropertySource("classpath:blogger.properties")
public class AppConfig {
    // declaramos 2 instancias bean Blogger a los cuales inyectamos valores.
    @Bean
    public Blogger awsBlogger(@Value("Alex") String firstName,
                              @Value("DeBrie") String lastName,
                              @Value("https://www.alexdebrie.com/") URL personalSite,
                              @Value("1980-01-02") LocalDate birthDate) throws Exception { // I really don't know when his birthday is ;)
        return new Blogger(firstName, lastName, birthDate, personalSite);
    }

    // los valores inyectados se leen del archivo de propiedades blogger.properties.
    @Bean
    public Blogger springBlogger(@Value("${springBlogger.firstName}") String firstName,
                                 @Value("${springBlogger.lastName}") String lastName,
                                 @Value("${springBlogger.personalSite}") URL personalSite,
                                 @Value("${springBlogger.birthDate}") LocalDate birthDate) throws Exception {
        return new Blogger(firstName, lastName, birthDate, personalSite);
    }
}
