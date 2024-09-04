package spring_start_here_ch02.SpringContextDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Por medio de la anotacion @Configuration lo bean que declaremos permitiran a Spring Context
 * ser consciente de las clases que debe administrar
 */
@Configuration
public class Config {
    /*
     * con la anotacion @Bean permitimos que en el contexto de Spring exista una instancia llamada parrot de la clase Parrot
     */
    @Bean
    public Parrot parrot(){
        var parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    /*
     * @Primary permite que el bean sea el bean default entre varias instancias de una clase.
     * En este caso tenemos dos instancias de la clase Parrot
     */
    @Primary
    @Bean
    public Parrot parrot1(){
        var parrot1 = new Parrot();
        parrot1.setName("Kiki");
        return parrot1;
    }

    // en el context podemos tener varios tipos de objetos
    @Bean
    public String sayHello(){
        return "Hi everyone";
    }

    @Bean
    public Integer ten(){
        return 10;
    }
}
