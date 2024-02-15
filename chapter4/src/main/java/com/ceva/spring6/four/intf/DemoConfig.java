package com.ceva.spring6.four.intf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.intf")
public class DemoConfig {
    @Bean
    public FileManager fileManager() {
        return new FileManager();
    }
}
