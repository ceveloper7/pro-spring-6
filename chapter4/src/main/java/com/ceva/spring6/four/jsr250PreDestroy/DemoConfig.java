package com.ceva.spring6.four.jsr250PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.jsr250PreDestroy")
public class DemoConfig {
    @Bean
    FileManager fileManager() {
        return new FileManager();
    }
}
