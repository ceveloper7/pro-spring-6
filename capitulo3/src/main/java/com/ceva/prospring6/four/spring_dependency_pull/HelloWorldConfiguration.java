package com.ceva.prospring6.four.spring_dependency_pull;

import com.ceva.prospring6.four.decoupled.HelloWorldMessageProvider;
import com.ceva.prospring6.four.decoupled.MessageProvider;
import com.ceva.prospring6.four.decoupled.MessageRender;
import com.ceva.prospring6.four.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public MessageProvider provider(){
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRender renderer(){
        MessageRender renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
