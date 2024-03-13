package com.ceva.spring6.four.integration_testing_impl;

import com.ceva.spring6.four.advancedconfig.MessageProvider;
import com.ceva.spring6.four.advancedconfig.MessageRenderer;
import com.ceva.spring6.four.advancedconfig.StandardOutMessageRenderer;
import com.ceva.spring6.four.integration_testing_impl.provider.ConfigurableMessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.integration_testing_impl")
public class AllConfig {

    @Profile("dev")
    @Bean
    MessageProvider messageProvider(){
        return new ConfigurableMessageProvider("Text Sample");
    }

    @Bean
    MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return  messageRenderer;
    }
}
