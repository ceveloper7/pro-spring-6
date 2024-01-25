package com.ceva.spring6.three.naming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.three.naming")
public class BeanNamingCfg {
    @Bean
    public SimpleBean  anotherSimpleBean(){
        return new SimpleBean();
    }
}
