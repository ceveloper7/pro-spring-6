package com.ceva.spring6.three.autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.three.autowiring")
public class AutowiringCfg {
    @Bean
    Foo anotherFoo(){
        return new Foo();
    }
}
