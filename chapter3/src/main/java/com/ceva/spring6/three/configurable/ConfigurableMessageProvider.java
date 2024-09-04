package com.ceva.spring6.three.configurable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * En este caso la dependencia no es un bean, sino una simple objeto String
 */
@Component
public class ConfigurableMessageProvider implements MessageProvider{
    private String message;

    /*
     * @Value permite definir a ser injectado en el cosntructor, de esta manera injectamos un valor que no es un bean en un Spring bean
     */
    public ConfigurableMessageProvider(@Value("Configurable message") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
