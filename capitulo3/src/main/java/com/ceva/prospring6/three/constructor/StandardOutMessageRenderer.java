package com.ceva.prospring6.three.constructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// simple bean requiere una dependencia
@Component("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {
    // definimos la dependencia
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException(
                    "You must se the property messageProvider of the class:" +
                            StandardOutMessageRenderer.class.getName()
            );
        }
        System.out.println(messageProvider.getMessage());
    }

    @Autowired
    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        System.out.println("Inyectando dependencia usando setter");
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
