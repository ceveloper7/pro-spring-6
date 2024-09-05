package com.ceva.spring6.start_here.construct_wiring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * La injeccion de dependencia en elconstructor solo funciona cuando la clase es anotada con @Component
 */
@Component
public class Person {
    private String name;

    private final Parrot parrot;

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", his/her parrot is=" + parrot .getName()+
                '}';
    }
}
