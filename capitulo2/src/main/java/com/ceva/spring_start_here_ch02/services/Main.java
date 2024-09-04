package com.ceva.spring_start_here_ch02.services;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ceva.spring_start_here_ch02.beans.Person;
import com.ceva.spring_start_here_ch02.config.Config;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);
        var person1 = context.getBean(Person.class);

        System.out.println(person1);
    }
}
