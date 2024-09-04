package com.ceva.spring6.start_here.construct_wiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.start_here.construct_wiring")
public class Config {
    @Bean
    public Parrot parrot(){
        return new Parrot("koko");
    }

    @Bean
    public Person person(){
        Person p = new Person(parrot());
        p.setName("John");
        return p;
    }
}
