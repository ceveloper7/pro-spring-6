package com.ceva.prospring6.four.inyectionbyconstructor;

import com.ceva.prospring6.four.decoupled.MessageProvider;
import com.ceva.prospring6.four.decoupled.StandardOutMessageRenderer;

public class StandardOutMessageRenderIC implements MessageRendererIC {
    private final MessageProvider messageProvider;

    public StandardOutMessageRenderIC(MessageProvider messageProvider){
        System.out.println("---> StandardOutMessageRenderer: Constructor Called");
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("Es necesario configurar el MessageProvider" +
                    "de la clase " + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
