package com.ceva.spring_start_here_ch02.services;

import com.ceva.spring_start_here_ch02.beans.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ceva.spring_start_here_ch02.beans.Person;
import com.ceva.spring_start_here_ch02.config.Config;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        var person1 = context.getBean(Person.class);
        var parrot1 = context.getBean(Parrot.class);

        System.out.println(person1);
        System.out.println(parrot1);
        System.out.println("Person's pet is a " + person1.getParrot());

    }
}
