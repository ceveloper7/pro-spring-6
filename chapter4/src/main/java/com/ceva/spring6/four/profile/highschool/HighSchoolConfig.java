package com.ceva.spring6.four.profile.highschool;

import com.ceva.spring6.four.profile.FoodProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// @Profile indicamos a spring que este bean debera ser instanciado unicamente solo cuando el
// perfil highschool esta activo
@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.profile")
@Profile("highschool")
public class HighSchoolConfig {
    @Bean
    FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
