package com.ceva.prospring6.four.contextualized_dependency_lookup;

/**
 * MessageRender implementa ManagedComponent, implementando ManagedComponent
 * indicamos al contenedor que deseamos obtener una dependencia.
 */
public class StandardOutMessageRenderer implements MessageRenderer{
    private MessageProvider messageProvider;
    public StandardOutMessageRenderer(){
        System.out.println(" --> StandardOutMessageRenderer: constructor called");
    }

    // busca su dependencia utilizando la implementacion provista para container
    @Override
    public void performLookup(Container container) {
        this.messageProvider = (MessageProvider) container.getDependency("provider");
    }
    @Override
    public String toString() {
        return messageProvider.toString();
    }

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRenderer.class.getName());
        }
       System.out.println(messageProvider.getMessage());
    }
}
