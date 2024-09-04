package com.ceva.spring6.three.annotated;

import com.ceva.spring6.three.decoupled.MRender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IC_DependencyPullSample {
    public static void main(String[] args) {
        // para las clases de configuracion se utiliza la implementacion AnnotationConfigApplicationContext
        // su equivalente con capacidad web es AnnotationConfigWebApplicationContext
        // ctx es una instancia de un contenedor Inversion del Control de Spring
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // extraemos la instancia de la clase (StandardOutMessageRender)
        // que implementa el bean MRender
        var renderizador = ctx.getBean("renderizador", MRender.class);
        renderizador.printMessage();
    }
}
