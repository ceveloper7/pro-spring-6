package com.ceva.prospring6.four.decoupled;

public class StandardOutMessageRenderer implements MessageRender{
    private MessageProvider messageProvider;
    public StandardOutMessageRenderer(){
        System.out.println("---> StandardOutMessageRenderer: Constructor Called");
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
    public void setMessageProvider(MessageProvider provider) {
        System.out.println("---> StandardOutMessageRenderer: setting the provider");
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
