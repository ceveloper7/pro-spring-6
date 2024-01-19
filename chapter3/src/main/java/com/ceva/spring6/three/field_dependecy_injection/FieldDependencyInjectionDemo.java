package com.ceva.spring6.three.field_dependecy_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FieldDependencyInjectionDemo {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(Kit.class, Part.class);
        ctx.refresh();

        Kit kit = ctx.getBean(Kit.class);
        kit.showKit();
    }
}
