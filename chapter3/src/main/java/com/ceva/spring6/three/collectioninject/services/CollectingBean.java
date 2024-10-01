package com.ceva.spring6.three.collectioninject.services;

import com.ceva.spring6.three.nesting.beans.Song;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static java.lang.System.out;


@Component
public class CollectingBean {

    /*
     * @Qualifier("list") indica a Spring que debe inyectar el bean list que es de tipo collection a la propiedad songListResources. Usamos
     * la anotacion @Qualifier de Spring no la que provee Jakarta. Por lo tanto anotar a la variable de instancia songListResource con @Qualifier("list")
     * permite que ocurra el comportamiento esperado, donde Spring inject el collection bean de tipo List<Song> pero hay otras formas de hacerlo:
     * @Inject @Named("list") esta anotacion se encuentra en Jakarta y equivale a Autowired de Spring, @Named es equivalente a @Qualifier de SPring.
     * @Resource(name="list") esta anotacion tambien se encuentra en Jakarta, esta forma es la mas utilizada.
     * @Value("#{collectionConfig.list}") Esta opcion nos permite agregar la menor cantidad de dependencias y es la forma recomendada de injectar
     * colecciones a la aplicacion.
     */
    @Autowired
    @Qualifier("list")
    // @Resource(name = "list")
    //@Value("#{collectionConfig.list}")
    //@Inject
    //@Named("list")
    List<Song> songListResource;

    /*
     * Injecta los dos bean song1 y song2. Se esperaria que se injecte el bean list() pero porque paso esto?
     * @Autowired siempre trata a los array, collections y maps como conjunto de beans con el tipo de bean de destino derivado
     * del tipo de valor de coleccion declarado, en este caso tipo List<Song>
     * Spring intentara injectar todos los bean de tipo Song dentro del ApplicationContext actual.
     */
    @Autowired // @Inject
    List<Song> songList;

    // injecta los bean song1 y song2
    @Autowired
    Set<Song> songSet;

    // injecta los item del bean set
    @Autowired @Qualifier("set")
    //@Resource(name = "set")
    Set<Song> songSetResource;

    // injecta los beans song1 y song2
    @Autowired
    Map<String, Song> songMap;

    // injecta los items del bean map
    @Autowired @Qualifier("map")
    //@Resource(name = "map")
    Map<String, Song> songMapResource;

    @Autowired
    Properties props;

    public void printCollections(){
        out.println("-- list injected using @Autowired -- ");
        songList.forEach(s -> out.println(s.getTitle()));

        out.println("-- list injected using @Resource / @Autowired @Qualifier(\"list\") / @Inject @Named(\"list\") -- ");
        songListResource.forEach(s -> out.println(s.getTitle()));

        out.println("-- set injected using @Autowired -- -- ");
        songSet.forEach(s -> out.println(s.getTitle()));

        out.println("-- set injected using @Resource / @Autowired @Qualifier(\"set\") / @Inject @Named(\"set\") -- ");
        songSetResource.forEach(s -> out.println(s.getTitle()));

        out.println("-- map injected using  @Autowired -- ");
        songMap.forEach((k,v) -> out.println(k + ": " + v.getTitle()));

        out.println("-- map injected using @Resource / @Autowired @Qualifier(\"map\") / @Inject @Named(\"map\")-- ");
        songMapResource.forEach((k,v) -> out.println(k + ": " + v.getTitle()));

        out.println("-- props injected with @Autowired -- ");
        props.forEach((k,v) -> out.println(k + ": " + v));
    }
}
