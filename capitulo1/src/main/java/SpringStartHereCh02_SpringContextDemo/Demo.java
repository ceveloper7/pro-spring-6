package SpringStartHereCh02_SpringContextDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        // creamos una instancia de Spring-context
        var context = new AnnotationConfigApplicationContext(Config.class);
        var parrot = context.getBean("parrot", Parrot.class);

        System.out.println(parrot);
    }
}
