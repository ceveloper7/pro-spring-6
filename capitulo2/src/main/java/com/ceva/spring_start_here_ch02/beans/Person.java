package com.ceva.spring_start_here_ch02.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/*
 * @Component le dice a spring que cree una sola instancia de esta clase en el spring context
 */
@Component
public class Person {
    private String name;

    // inicializamos el bean Person con un nombre por defecto
    @PostConstruct
    void init(){
        this.name = "John Doe";
    }

    public Person(){}
    public Person(String name) {
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
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
