package com.ceva.prospring6.two.decoupled;

/*
 * Service provider interface implementation
 * Componente responsable de renderizar el mensaje
 */
public class StandardOutMessageRenderer implements MessageRenderer{
    private MessageProvider messageProvider;

    public StandardOutMessageRenderer(){
        System.out.println("--> StandardOutMessageRenderer: Constructor called");
    }

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

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        System.out.println("--> StandardOutMessageRenderer: setting the provider");
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
