package com.ceva.prospring6.four.nesting;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ApplicationContextAware: Nos permite acceder al contexto actual para poder tener
 *                          acceso al contexto principal.
 */
public class ChildConfig implements ApplicationContextAware {
    // propiedad que nos permite acceder al contexo actual de la applicacion
    public ApplicationContext applicationContext;
    @Bean // overrides {@code childProvider} bean from parent context
    public TitleProvider childProvider(){
        return TitleProvider.instance("No Such Thing");
    }

    /**
     * declaramos 3 beans Song con titulos inyectados
     * song1 -> se le inyecta el valor del titulo proporcionado por el bean parentProvider dado que
     *          hay un unico bean llamado parentProvider en el contexto principal que hereda el
     *          contexto hijo, el valor inyectado es gravity.
     * song2 -> se le inyecta el valor del titulo proporcionado por el bean childProvider declarado
     *          en el contexto principal. Dado que tambien hay un bean llamado ChildProvider en el
     *          contexto secundario, para acceder al bean del contexto principal, hay que
     *          hacer algunas acrobacias.
     * song3 -> Inyecta el valor del titulo proporcionado por el bean llamado childProvider, dado
     *          que hay un bean llamdo childProvider en el contexto actual, el valor inyectado es
     *          No Such Thing.
     */
    @Bean
    public Song song1(@Value("#{parentProvider.title}") String title){
        return new Song(title);
    }

    // expresion SpEL que obtiene referencia del contexto principal, accedemos al childProvider
    // y obtenemos el valor del titulo que es Daughter
    @Bean
    public Song song2(@Value("#{childConfig.applicationContext.parent.getBean(\"childProvider\").title}") String title){
        return new Song(title);
    }

    @Bean
    public Song song3(@Value("#{childProvider.title}") String title){
        return new Song(title);
    }

    // metodo que nos permite acceder al contexto actual de la aplicacion
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
