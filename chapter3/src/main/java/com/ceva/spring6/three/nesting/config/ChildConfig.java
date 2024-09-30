package com.ceva.spring6.three.nesting.config;

import com.ceva.spring6.three.nesting.beans.Song;
import com.ceva.spring6.three.nesting.beans.TitleProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
@ComponentScan(basePackages = {"com.ceva.spring6.three.nesting.beans"})
public class ChildConfig implements ApplicationContextAware{
    // ApplicationContextAware y ApplicationContext permiten que desde un contexto secundario podamos acceder al contexto principal
    public ApplicationContext applicationContext;

    @Bean
    public TitleProvider childProvider(){
        return TitleProvider.instance("No such thing");
    }

    // 3 beans a los que se les injecta el titulo desde un bean TitleProvider
    /*
     * se le inyecta el valor provisto por el bean parentProvider declarado en el contexto principal
     * el valor que se injecta es Dear boy
     */
    @Bean
    public Song song1(@Value("#{parentProvider.title}")String title){
        return new Song(title);
    }

    /*
     * se le injecta el valor provisto por el bean childProvider declarado en el contexto principal
     * dado que tambien hay un bean llamado childProvider en el contexto secundario para acceder al contexto principal
     * se emplea una sintaxis algo especial
     */
    @Bean
    public Song song2(@Value("#{childConfig.applicationContext.parent.getBean(\"childProvider\").title}") String title){
        return new Song(title); // print Daughters
    }

    /*
     * se le injecta el valor provisto por el bean childProvider. Dado que en el contexto actual (secundario) hay un bean childProvider
     * el valor que se injecta es No such thing
     */
    @Bean
    public Song song3(@Value("#{childProvider.title}")String title){
        return new Song(title); // print No such thing
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
