package com.ceva.spring6.start_here.field_autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;

    /*
     * Field injection no es la mejor opcion porque:
     * No podemos hacer de este atributo de instancia final
     */
    @Autowired
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}
