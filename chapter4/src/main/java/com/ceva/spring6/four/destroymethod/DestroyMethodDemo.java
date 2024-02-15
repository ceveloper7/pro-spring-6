package com.ceva.spring6.four.destroymethod;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DestroyMethodDemo {
    public static void main(String... args) {
        // recuperamos del contexto un bean de tipo FileManager
        var ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        // invocamos el metodo destroy del bean
        ctx.close();
    }
}
