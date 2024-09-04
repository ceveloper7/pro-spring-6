package com.ceva.spring_start_here_ch02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.ceva.spring_start_here_ch02.beans.Person;

@Configuration
@ComponentScan(basePackages = {"com.ceva.spring_start_here_ch02.beans", "com.ceva.spring_start_here_ch02.services"}) // podemos indicar otros paquetes seguidos de una coma
public class Config {
    @Bean
    public Person person(){
        return new Person();
    }
}
