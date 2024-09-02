package SpringStartHereCh02_SpringContextDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
