package com.ceva.spring6.four.integration_testing_impl.provider;

import com.ceva.spring6.four.advancedconfig.MessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurableMessageProvider implements MessageProvider {
    private final String message;

    public ConfigurableMessageProvider(@Value("Text Sample")String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
