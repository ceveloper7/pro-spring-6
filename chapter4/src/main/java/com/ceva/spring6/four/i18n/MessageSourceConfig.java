package com.ceva.spring6.four.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.i18n")
public class MessageSourceConfig {
    // definimos un bean ResourceBundleMessageSource
    @Bean
    public MessageSource messageSource(){
        var messageSource = new ResourceBundleMessageSource();
        // definimos la base de su conjunto de archivos
        messageSource.setBasenames("labels");
        return messageSource;
    }
}
