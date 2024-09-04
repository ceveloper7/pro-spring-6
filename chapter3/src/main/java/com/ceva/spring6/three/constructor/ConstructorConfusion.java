package com.ceva.spring6.three.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ConstructorConfusion {
    private String someValue;
    public ConstructorConfusion(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    /*
     * Aunque la clase posee mas de un constructor, al decorar este constructor con @Autowired se le dice a Spring que use este
     * constructor para crear una instancia de este bean, sin esta anotacion Spring no tiene forma que constructor utilizar.
     */
    @Autowired
    public ConstructorConfusion(@Value("90") int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }
    public String toString() {
        return someValue;
    }

    public static void main(String... args) {
        // creamos una instancia del contexto de aplicacion de spring
        var ctx = new AnnotationConfigApplicationContext();
        // registramos la definicion del bean
        ctx.register(ConstructorConfusion.class);
        // se recrean todos los beans deacuerdo a las definiciones registradas.
        ctx.refresh();

        var cc = ctx.getBean(ConstructorConfusion.class);
        System.out.println("Does this work? " + cc);
    }
}
