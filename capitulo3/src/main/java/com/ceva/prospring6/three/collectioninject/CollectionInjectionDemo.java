package com.ceva.prospring6.three.collectioninject;

import com.ceva.prospring6.three.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjectionDemo {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(CollectionConfig.class, CollectingBean.class);
        ctx.refresh();

        var collectingBean = ctx.getBean(CollectingBean.class);
        collectingBean.printCollections();
    }
}

@Component
class CollectingBean{
    @Autowired
    @Qualifier("list") // indica que se inyect unicamente el bean de tipo List<Song> llamado list
    List<Song> songListResource;

    @Autowired // inject todos los bean del tipo Song en el ApplicationContext
    List<Song> songList;

    @Autowired
    Set<Song> songSet;

    @Autowired
    @Qualifier("set")
    Set<Song> songSetResource;

    @Autowired
    Map<String, Song> songMap;

    @Autowired
    @Qualifier("map")
    Map<String, Song> songMapResource;

    @Autowired
    Properties props;

    public void printCollections(){
        System.out.println("-- list injected using @Autowired -- ");
        songList.forEach(s -> System.out.println(s.getTitle()));
//
//        System.out.println("-- list injected using @Resource / @Autowired @Qualifier(\"list\") / @Inject @Named(\"list\") -- ");
//        songListResource.forEach(s -> System.out.println(s.getTitle()));
//
//        System.out.println("-- set injected using @Autowired -- -- ");
//        songSet.forEach(s -> System.out.println(s.getTitle()));
//
//        System.out.println("-- set injected using @Resource / @Autowired @Qualifier(\"set\") / @Inject @Named(\"set\") -- ");
//        songSetResource.forEach(s -> System.out.println(s.getTitle()));
//
//        System.out.println("-- map injected using  @Autowired -- ");
//        songMap.forEach((k,v) -> System.out.println(k + ": " + v.getTitle()));
//
//        System.out.println("-- map injected using @Resource / @Autowired @Qualifier(\"map\") / @Inject @Named(\"map\")-- ");
//        songMapResource.forEach((k,v) -> System.out.println(k + ": " + v.getTitle()));
//
//        System.out.println("-- props injected with @Autowired -- ");
//        props.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}

@org.springframework.context.annotation.Configuration
class CollectionConfig{
    @Bean
    public List<Song> list(){
        return List.of(new Song("Not the end"), new Song("Rise up"));
    }

    @Bean
    public Set<Song> set(){
        return Set.of(new Song(("Ordinary day")), new Song("Birds fly"));
    }

    @Bean
    public Map<String, Song> map(){
        return Map.of("John Mayer", new Song("Gravity"), "Ben Barnes", new Song("11:11"));
    }

    @Bean
    public Properties props(){
        Properties props = new Properties();
        props.put("said.she", "Never Mine");
        props.put("said.he","Cold and jaded");
        return props;
    }

    // declaramos 2 beans de tipo Song
    @Bean
    public Song song1(){
        return new Song("Here's to hoping");
    }

    @Bean
    public Song song2(){
        return new Song("Wishing the best for you");
    }
}
