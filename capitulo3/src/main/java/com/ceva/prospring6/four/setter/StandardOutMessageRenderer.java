package com.ceva.prospring6.four.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// bean complejo que requiere una dependencia
@Component("renderer")
public class StandardOutMessageRenderer implements MessageRenderer{
    private MessageProvider messageProvider;
    @Autowired // contenedor IoC de spring busca un bean de este tipo
    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        System.out.println("Inyectando dependencia usando setter");
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class: " +
                    StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }
}
