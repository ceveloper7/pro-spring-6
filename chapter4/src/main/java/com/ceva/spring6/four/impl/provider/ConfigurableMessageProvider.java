package com.ceva.spring6.four.impl.provider;

import com.ceva.spring6.four.advancedconfig.MessageProvider;

import com.ceva.spring6.four.impl.model.MProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConfigurableMessageProvider implements MProvider {
    private final String message;

    public ConfigurableMessageProvider(@Value("Text Sample") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
