package com.ceva.spring6.start_here.construct_wiring.config;

import com.ceva.spring6.start_here.construct_wiring.beans.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ceva.spring6.start_here.construct_wiring.beans", "com.ceva.spring6.start_here.construct_wiring.services"})
public class Config {
    @Bean
    public Parrot parrot(){
        return new Parrot("koko");
    }
}
