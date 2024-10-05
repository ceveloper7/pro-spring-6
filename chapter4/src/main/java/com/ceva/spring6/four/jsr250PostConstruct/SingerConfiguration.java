package com.ceva.spring6.four.jsr250PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.jsr250PostConstruct")
public class SingerConfiguration {
    @Bean
    Singer singerOne(){
        Singer singer = new Singer();
        singer.setName("John Mayer");
        singer.setAge(43);
        return singer;
    }

    @Bean
    Singer singerTwo(){
        Singer singer = new Singer();
        singer.setAge(42);
        return singer;
    }

    @Bean
    Singer singerThree(){
        Singer singer = new Singer();
        singer.setName("John Butler");
        singer.setAge(32);
        return singer;
    }

//    @Bean
//    FileManager fileManager() {
//        return new FileManager();
//    }
}
