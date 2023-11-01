package com.ceva.prospring6.four.setterinyectiondependency;

import com.ceva.prospring6.four.decoupled.MessageProvider;
import com.ceva.prospring6.four.decoupled.StandardOutMessageRenderer;

public class StandardOutMessageRenderSID implements MessageRendererSID{
    private MessageProviderSID messageProviderSID;

    public StandardOutMessageRenderSID(MessageProviderSID messageProviderSID){
        System.out.println("---> StandardOutMessageRendererSID: Constructor Called");
        setMessageProviderSID(messageProviderSID);
    }

    public void setMessageProviderSID(MessageProviderSID messageProviderSID){
        this.messageProviderSID = messageProviderSID;
    }
    @Override
    public void render() {
        if(messageProviderSID == null){
            throw new RuntimeException("Es necesario configurar el MessageProvider" +
                    "de la clase " + StandardOutMessageRenderSID.class.getName());
        }
        System.out.println(messageProviderSID.getMessage());
    }

    @Override
    public MessageProviderSID getMessageProvider() {
        return this.messageProviderSID;
    }
}
