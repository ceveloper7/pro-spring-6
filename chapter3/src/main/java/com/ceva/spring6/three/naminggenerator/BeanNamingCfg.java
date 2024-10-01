package com.ceva.spring6.three.naminggenerator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(nameGenerator = SimpleBeanNameGenerator.class)
class BeanNamingCfg {
    @Bean
    public SimpleBean anotherSimpleBean(){
        return new SimpleBean();
    }
}