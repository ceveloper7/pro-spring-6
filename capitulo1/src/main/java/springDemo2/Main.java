package springDemo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. Creamos un context mediante una implementacion de contextos que obtiene su
 *    configuracion de una clase anotada con @Configuration
 * 2. Dentro del contexto viviran los @Bean y @Component que se han creado
 * 3. La llamar al bean report le pedimos a spring que retone la clase Report con
 *    todas sus dependencias
 */
public class Main {
    public static void main(String[] args) {
        // definimos el contexto donde viviran los beans del programa
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        for (String s : context.getBeanDefinitionNames())
            System.out.println("bean: " + s);
        Report report = context.getBean("report", Report.class);
        report.make();
    }
}
