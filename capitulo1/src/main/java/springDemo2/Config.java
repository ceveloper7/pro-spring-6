package springDemo2;

import java.io.OutputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration // indicamos q se trata de una clase de configuracion
@ComponentScan // indicamos que es este paquete estarn los componentes, beans para el context
public class Config {

    // informamos a spring que el objeto que retorna el metodo outputStream sera usado
    // como un bean en el contexto y asi la dependencia en el constructor de Report
    // estara resuelta.
    @Bean
    public OutputStream outputStream() {
        return System.out;
    }
}
