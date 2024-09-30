package com.ceva.spring6.three.collectioninject.services;

import com.ceva.spring6.three.nesting.beans.Song;
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
    @Autowired
    @Qualifier("list")
    //@Resource(name = "list")
    //@Value("#{collectionConfig.list}")
    //@Inject @Named("list")
    List<Song> songListResource;

    @Autowired // @Inject
    List<Song> songList;

    @Autowired
    Set<Song> songSet;

    @Autowired @Qualifier("set")
    //@Resource(name = "set")
    Set<Song> songSetResource;

    @Autowired
    Map<String, Song> songMap;

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
