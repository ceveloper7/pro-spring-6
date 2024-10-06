package com.ceva.spring6.four.custompropertyeditor;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.four.custompropertyeditor")
public class CustomPropertyEditorCfg {
    @Bean
    CustomEditorConfigurer customEditorConfigurer(){
        var cust = new CustomEditorConfigurer();
        // injectamos el custom property editor NamePropertyEditor cuya clave de entrada es la clase FullName.class
        // lo que significa que la clase FullName es la clase que se debe utilizar para esta implementacion.
        cust.setCustomEditors(Map.of(FullName.class, NamePropertyEditor.class));
        return cust;
    }
}
