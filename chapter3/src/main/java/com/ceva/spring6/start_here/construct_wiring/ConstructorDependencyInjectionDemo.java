package com.ceva.spring6.start_here.construct_wiring;

import com.ceva.spring6.start_here.construct_wiring.beans.Person;
import com.ceva.spring6.start_here.construct_wiring.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConstructorDependencyInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        var person = context.getBean(Person.class);
        person.setName("Carlos V.");

        System.out.println(person);
    }
}
