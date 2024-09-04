package com.ceva.spring_start_here_ch02.config;

import com.ceva.spring_start_here_ch02.beans.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.ceva.spring_start_here_ch02.beans.Person;

@Configuration
@ComponentScan(basePackages = {"com.ceva.spring_start_here_ch02.beans", "com.ceva.spring_start_here_ch02.services"}) // podemos indicar otros paquetes seguidos de una coma
public class Config {


    @Bean
    public Parrot parrot(){
        return new Parrot("Koko");
    }

    /*
     * 1 forma de wiring, desde el bean person creado llamao al bean parrot para ser asignado a person
     */
//    @Bean
//    public Person person(){
//        Person p = new Person("Emanuel");
//        p.setParrot(parrot());
//        return p;
//    }

    /*
     * 2da forma. dependency injection. Spring toma el bean parrot del contexto y lo injecta la refrencia en el parametro del bean person
     */
    @Bean
    public Person person(Parrot parrot){
        Person p = new Person("Emmanuel");
        p.setParrot(parrot);
        return p;
    }

}
