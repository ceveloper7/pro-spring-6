package com.ceva.spring6.four.destroymethod;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Las opciones que se tienen para trabajar con la callback de destruction son las mismas que se poseen para
 * trabajar con la calback de inicializacion. Son tres opciones.
 *
 * La callback de destruccion se utiliza a menudo junto con la callback de inicializacion. En muchos casos
 * se crea y configura un recurso en la callback de inicializacion y luego se libera el recurso en la callback de destruccion
 */
public class DestroyMethodDemo {
    public static void main(String... args) {
        // recuperamos del contexto un bean de tipo FileManager
        var ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        // invocamos el metodo destroy del bean
        ctx.close();
    }
}
