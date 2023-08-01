package com.ceva.prospring6.three.constructor;


import com.ceva.prospring6.three.constructor.MessageProvider;

/*
 * Service provider interface (SPI)
 * Cualquier implementacion de MessageRender esta desacoplado
 * de la recuperacion de mensajes
 */
public interface MessageRenderer{
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
