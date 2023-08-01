package com.ceva.prospring6.three.decoupled;

/*
 * Service provider interface (SPI)
 * Cualquier implementacion de MessageRender esta desacoplado
 * de la recuperacion de mensajes
 */
public interface MessageRenderer extends ManagedComponent{
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
