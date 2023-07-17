package com.ceva.prospring6.two.annotated;

import com.ceva.prospring6.two.decoupled.HelloWorldMessageProvider;
import com.ceva.prospring6.two.decoupled.MessageProvider;
import com.ceva.prospring6.two.decoupled.MessageRenderer;
import com.ceva.prospring6.two.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public MessageProvider provider(){
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
