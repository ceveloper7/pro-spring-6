package com.ceva.spring6.four.custompropertyeditor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Person {
    private FullName name;

    @Value("John Mayer")
    public void setName(FullName name) {
        this.name = name;
    }

    public FullName getName() {
        return name;
    }
}



