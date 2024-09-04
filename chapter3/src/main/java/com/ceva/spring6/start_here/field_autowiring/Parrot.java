package com.ceva.spring6.start_here.field_autowiring;

import org.springframework.stereotype.Component;


/*
 *  En este caso no utilizamos la anotacion @Component pero declaramos a Parrot como @Bean en la clase Config.
 */
public class Parrot {
    private String name;

    public Parrot(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
