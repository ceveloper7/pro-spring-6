package com.ceva.prospring6.four.inyectionbyconstructor;

import com.ceva.prospring6.four.decoupled.MessageProvider;
import com.ceva.prospring6.four.decoupled.StandardOutMessageRenderer;

/*
 * Constructor dependency injection
 * el contenedor de Inversion del Control inyecta las dependencias via el constructor de la clase.
 */
public class StandardOutMessageRenderIC implements MessageRendererIC {
    private final MessageProvider messageProvider;

    /*
     * constructor dependency injection. el objeto StandardOutMessageRenderIC no puede ser creado sin su dependencia
     */
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

    /*
     * setter dependency injection. el objeto StandardOutMessageRenderIC puede ser creado sin su dependencia.
     * La dependencia puede ser provista despues, llamando al metodo getter
     */
    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
