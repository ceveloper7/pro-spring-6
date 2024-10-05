package com.ceva.spring6.four.jsr250PreDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Asi como en el caso de la creacion de un bean, podemos usar todos los mecanismos en la misma instancia del bean para su destruccion.
 *
 */
public class PreDestroyDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        //ctx.close();
        ctx.registerShutdownHook();
    }
}
