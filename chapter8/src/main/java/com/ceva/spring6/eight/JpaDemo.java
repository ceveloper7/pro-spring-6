package com.ceva.spring6.eight;

import com.ceva.spring6.eight.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ceva.spring6.eight.config.JpaConfig;
import com.ceva.spring6.eight.service.SingerService;

import java.util.Optional;

public class JpaDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(JpaDemo.class);
    public static void main(String[] args) {
        try(var ctx = new AnnotationConfigApplicationContext(JpaConfig.class)){
            var singerService = ctx.getBean(SingerService.class);

            LOGGER.info(" ---- Listing singers:");
            singerService.findAll().forEach(s -> LOGGER.info(s.toString()));

            LOGGER.info(" ---- Listing singers with album and instruments:");
            var singerWithAlbums = singerService.findAllWithAlbum();
            singerWithAlbums
                    .forEach(singer -> {
                        LOGGER.info(singer.toString());
                        if(singer.getAlbums() != null){
                            singer.getAlbums().forEach(album -> LOGGER.info("\t" + album.toString()));
                        }
                    });

            LOGGER.info(" ---- Get Singer by Id:");
            Optional<Singer> singer = singerService.findById(1L);
            if (singer.isPresent()){
                Singer jonhMayer = singer.get();
                LOGGER.info(jonhMayer.toString());
                if(jonhMayer.getAlbums() != null){
                    jonhMayer.getAlbums().forEach(album -> LOGGER.info("\t" + album.toString()));
                }
            }
        }
    }
}
