package com.ceva.spring6.four.env_propertysource;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.env_propertysource")
// permite agregar el contenido de application.properties al contexto de spring
@PropertySource("classpath:application.properties")
public class PropDemoConfig {
    @Autowired
    StandardEnvironment environment;

    @PostConstruct
    void configPriority() {
        ResourcePropertySource rps = (ResourcePropertySource) environment.getPropertySources().stream().filter(ps -> ps instanceof ResourcePropertySource).findAny().orElse(null);
        environment.getPropertySources().addFirst(rps);
    }

    @Bean
    AppProperty appProperty(){
        return new AppProperty();
    }
}
