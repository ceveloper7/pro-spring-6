package com.ceva.spring6.four.profile.kindergarten;

import com.ceva.spring6.four.profile.FoodProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.profile")
@Profile("kindergarten")
public class KindergartenConfig {
    @Bean
    FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
