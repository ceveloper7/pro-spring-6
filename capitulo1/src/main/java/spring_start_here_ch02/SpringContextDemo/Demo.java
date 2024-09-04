package spring_start_here_ch02.SpringContextDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        // creamos una instancia de Spring-context
        var context = new AnnotationConfigApplicationContext(Config.class);

        /*
         * en la clase Config declaramos 2 bean de tipo Parrot pero parrot1 fue anotado como @Primary
         * por lo que el metodo getBean() va a recuperar dicho bean parrot1 cuya variable de instancia name es kiki
         * var parrot = context(Parrot.class):
         *
         * si quisiera un especifico bean como por ejemplo llamar al bean parrot seria:
         * var parrot = context.getBean("parrot", Parrot.class) cuya variable de instancia name es koko
         */
        var parrot = context.getBean("parrot", Parrot.class);
        System.out.println(parrot);

        // llamando otros tipos de beans
        String hi = context.getBean("sayHello", String.class);
        System.out.println(hi);

        Integer num = context.getBean("ten", Integer.class);
        System.out.println(num);
    }
}
