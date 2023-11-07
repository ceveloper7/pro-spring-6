package com.ceva.prospring6.four.setter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceva.prospring6.four.setter")
public class HellowWorldConfiguration {
    @Bean
    public MessageProvider messageProvider(){
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer(){
        MessageRenderer r = new StandardOutMessageRenderer();
        r.setMessageProvider(messageProvider());
        return r;
    }
}
