package com.ceva.spring6.four.initmethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.initmethod")
public class SingerConfiguration {

    // le indicamos a Spring que llame al metodo init del bean Singer
    @Bean(initMethod = "init")
    Singer singerOne(){
        Singer singer = new Singer();
        singer.setName("John Mayer");
        singer.setAge(43);
        return singer;
    }

    @Bean(initMethod = "init")
    Singer singerTwo(){
        Singer singer = new Singer();
        singer.setAge(42);
        return singer;
    }

    @Bean(initMethod = "init")
    Singer singerThree(){
        Singer singer = new Singer();
        singer.setName("John Butler");
        singer.setAge(52);
        return singer;
    }
}
