package com.ceva.spring6.three.decoupled;

public class StandardOutMessageRender implements MRender{
    private MProvider messageProvider;

    public StandardOutMessageRender(){
        System.out.println("--> StandardOutMessageRender: constructor called");
    }
    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the messageprovider property up");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MProvider messageProvider) {
        System.out.println("--> StandardOutMessageRender: setting the provider");
        this.messageProvider = messageProvider;
    }

    @Override
    public MProvider getMessageProvider() {
        return this.messageProvider;
    }
}
