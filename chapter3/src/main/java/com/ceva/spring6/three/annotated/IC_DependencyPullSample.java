package com.ceva.spring6.three.annotated;

import com.ceva.spring6.three.decoupled.MRender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IC_DependencyPullSample {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // extraemos la instancia de la clase (StandardOutMessageRender)
        // que implementa el bean MRender
        MRender mrender = ctx.getBean("renderer", MRender.class);
        mrender.render();
    }
}
