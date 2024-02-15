package com.ceva.spring6.four.destroymethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.destroymethod")
public class DemoConfig {
    @Bean(destroyMethod = "destroyMethod")
    FileManager fileManager() {
        return new FileManager();
    }
}
