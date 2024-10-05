package com.ceva.spring6.four.intf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * El callback de destruccion es un mecanismo ideal para garantizar que sus aplicaciones se apaguen correctamente y no dejen recursos
 * abiertos o en un estado incosistente pero se debe elegir la modalidad de destruccion. las cuales son:
 * @Bean(destroyMethod="")
 * DisposableBean
 * @PreDestroy
 */
public class DisposableBeanDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        ctx.close();
    }
}
