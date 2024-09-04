package com.ceva.spring6.start_here.field_autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.start_here.field_autowiring")
public class Config {
    @Bean
    public Parrot parrot(){
        Parrot parrot = new Parrot("koko");
        return parrot;
    }
}
