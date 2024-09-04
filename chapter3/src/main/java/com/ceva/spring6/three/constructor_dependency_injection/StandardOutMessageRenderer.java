package com.ceva.spring6.three.constructor_dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("render")
public class StandardOutMessageRenderer implements CDIMessageRenderer{
    private CDIMessageProvider messageProvider;

    /*
     * aplicamos el Constructor Dependency Injection CDI
     * De esta manera nos aseguramos que el el bena render no se pueda crear sin sus dependencias.
     * Con Constructor Dependency Injection no es posible crear un StandardOutMessageRenderer sin proporcionar un CDIMessageProvider
     * Cuando la clase posee un unico constructor la anotacion @Autowired esta de mas.
     */
    @Autowired
    public StandardOutMessageRenderer(CDIMessageProvider messageProvider){
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        if(messageProvider ==  null){
            throw new RuntimeException("message provider property is not configured");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(CDIMessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public CDIMessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
