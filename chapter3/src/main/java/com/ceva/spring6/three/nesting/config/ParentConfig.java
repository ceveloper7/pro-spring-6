package com.ceva.spring6.three.nesting.config;

import com.ceva.spring6.three.nesting.beans.TitleProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ceva.spring6.three.nesting.beans"})
public class ParentConfig {
    @Bean
    public TitleProvider parentProvider(){
        return TitleProvider.instance(null);
    }

    @Bean
    public TitleProvider childProvider(){
        return TitleProvider.instance("Daughters");
    }
}
