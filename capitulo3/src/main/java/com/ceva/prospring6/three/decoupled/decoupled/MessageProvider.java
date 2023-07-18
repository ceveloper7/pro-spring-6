package com.ceva.prospring6.three.decoupled.decoupled;

/*
 * Service provider interface (SPI)
 * Responsable de la recuperacion de mensaje
 */
public interface MessageProvider {
    String getMessage();
}
