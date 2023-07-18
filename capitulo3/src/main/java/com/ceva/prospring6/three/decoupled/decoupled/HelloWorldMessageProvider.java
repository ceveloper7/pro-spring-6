package com.ceva.prospring6.three.decoupled.decoupled;

/*
 * Service provider interface implementation
 * Componente responsable de retornar el mensaje
 */
public class HelloWorldMessageProvider implements  MessageProvider{
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
