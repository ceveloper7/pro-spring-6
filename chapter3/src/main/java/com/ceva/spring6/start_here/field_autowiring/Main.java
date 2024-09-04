package com.ceva.spring6.start_here.field_autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person p = context.getBean(Person.class);
        Parrot p1 = context.getBean(Parrot.class);

        System.out.println(p.getParrot());
        System.out.println(p.getParrot() == p1); // true porque se comparan las direcciones de memoria a la que hace referencia las variables.
    }
}
