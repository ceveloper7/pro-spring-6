package com.ceva.spring6.four.destroymethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.destroymethod")
public class DemoConfig {
    /*
     * Spring solo realiza la destruccion de beans singleton, los beans con otros ambitos que no sean singleton no tienen su ciclo de vida
     * completamente administrado por spring.
     * Antes de que se destruya el bean singleton fileManager se ejecutara el metodo destroyMethod. Spring no llamara a este metodo para aquellos
     * beans cuyo alcance sea prototype
     */
    @Bean(destroyMethod = "destroyMethod")
    FileManager fileManager() {
        return new FileManager();
    }
}
