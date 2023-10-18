package com.ceva.prospring6.four.decoupled;

/**
 * Cualquier implementacion del MessageRender esta desacoplado del que obtiene el mensaje
 */
public interface MessageRender {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
