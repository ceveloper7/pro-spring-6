package com.ceva.spring6.four.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.aware")
public class AwareConfig {
    @Bean
    NamedSinger john_Mayer(){
        return new NamedSinger();
    }

    @Bean
    FileManager fileManager() {
        return new FileManager();
    }
    @Bean
    ShutdownHookBean shutdownHookBean() {
        return new ShutdownHookBean();
    }
}
