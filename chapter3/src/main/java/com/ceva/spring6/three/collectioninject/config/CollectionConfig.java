package com.ceva.spring6.three.collectioninject.config;

import com.ceva.spring6.three.nesting.beans.Song;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = "com.ceva.spring6.three.collectioninject.services")
public class CollectionConfig {
    @Bean
    public List<Song> list(){
        return List.of(
                new Song("Not the end"),
                new Song("Rise Up")
        );
    }

    @Bean
    public Set<Song> set() {
        return Set.of(
                new Song("Ordinary Day"),
                new Song("Birds Fly")
        );
    }

    @Bean
    public Map<String, Song> map () {
        return Map.of(
                "John Mayer", new Song("Gravity"),
                "Ben Barnes", new Song("11:11")
        );
    }

    @Bean
    Properties props(){
        Properties props = new Properties();
        props.put("said.she", "Never Mine");
        props.put("said.he", "Cold and jaded");
        return props;
    }

    @Bean
    public Song song1(){
        return new Song("Here's to hoping");
    }

    @Bean
    public Song song2(){
        return new Song("Wishing the best for you");
    }
}
