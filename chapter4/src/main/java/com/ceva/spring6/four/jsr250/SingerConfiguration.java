package com.ceva.spring6.four.jsr250;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four")
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
