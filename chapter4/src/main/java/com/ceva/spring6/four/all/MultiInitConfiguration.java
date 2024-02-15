package com.ceva.spring6.four.all;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.all")
public class MultiInitConfiguration {
    @Bean
    Dependency dependency (){
        return new Dependency();
    }

    @Bean(initMethod = "initMe")
    MultiInit multiInitBean(){
        return new MultiInit();
    }
}
