package com.ceva.prospring6.two.decoupled;

/*
 * Service provider interface (SPI)
 * Responsable de la recuperacion de mensaje
 */
public interface MessageProvider {
    String getMessage();
}
