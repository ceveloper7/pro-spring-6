package com.ceva.spring6.eight;

import com.ceva.spring6.eight.entities.Album;
import com.ceva.spring6.eight.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ceva.spring6.eight.config.JpaConfig;
import com.ceva.spring6.eight.service.SingerService;

import java.time.LocalDate;
import java.util.Optional;

public class JpaDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(JpaDemo.class);
    public static void main(String[] args) {
        try(var ctx = new AnnotationConfigApplicationContext(JpaConfig.class)){
            var singerService = ctx.getBean(SingerService.class);

            LOGGER.info(" ---- Listing singers:");
            singerService.findAllByNativeQuery().forEach(s -> LOGGER.info(s.toString()));

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
            Optional<Singer> singer = singerService.findById(4L);
            if (singer.isPresent()){
                Singer jonhMayer = singer.get();
                LOGGER.info(jonhMayer.toString());
                if(jonhMayer.getAlbums() != null){
                    jonhMayer.getAlbums().forEach(album -> LOGGER.info("\t" + album.toString()));
                }
            }

            LOGGER.info(" ---- Finding Singer by Criteria Query");
            var singerQuery = singerService.findByCriteriaQuery("John", "Mayer")
                    .peek(s -> {
                        LOGGER.info(s.toString());
                        if(s.getAlbums() != null){
                            s.getAlbums().forEach(a -> LOGGER.info("\tAlbum:" + a.toString()));
                        }
                        if(s.getInstruments() != null){
                            s.getInstruments().forEach(i -> LOGGER.info("\t" + i.getInstrumentId()));
                        }
                    }).toList();
/*
            LOGGER.info(" ---- Inserting new Singer and Album");
            var cantante = new Singer();
            cantante.setFirstName("John Wiston");
            cantante.setLastName("Lennon");
            cantante.setBirthDate(LocalDate.of(1940, 8, 16));

            var album = new Album();
            album.setTitle("Album 1");
            album.setReleaseDate(LocalDate.of(1961, 7, 18));
            cantante.addAlbum(album);

            album = new Album();
            album.setTitle("Album 2");
            album.setReleaseDate(LocalDate.of(1962, 3, 20));
            cantante.addAlbum(album);
            singerService.save(cantante);

            var cantantes = singerService.findAllWithAlbum().peek(
                    c -> {
                        LOGGER.info(c.toString());
                        if (c.getAlbums() != null) {
                            c.getAlbums().forEach(a -> LOGGER.info("\tAlbum:" + a.toString()));
                        }
                        if (c.getInstruments() != null) {
                            c.getInstruments().forEach(i -> LOGGER.info("\tInstrument: " + i.getInstrumentId()));
                        }
                    }
            ).toList();
*/
/*
            LOGGER.info(" ---- Updating Singer Information");
            var singerUpdate = singerService.findById(4L).orElse(null);
            // recuperamos un album especifico
            var albumUpdate = singerUpdate.getAlbums().stream()
                    .filter(a -> a.getTitle().equals("Album 1")).findFirst().orElse(null);

            singerUpdate.setFirstName("Eunice Kathleen");
            singerUpdate.setLastName("Waymon");
            singerUpdate.removeAlbum(albumUpdate);
            int singerVersion = singerUpdate.getVersion();

            singerService.save(singerUpdate);

            var nina = singerService.findById(4L).orElse(null);
            LOGGER.info(nina.toString());
 */
 /*
            LOGGER.info(" ---- Delete Singer Information - ID 4L");
            var singerDel = singerService.findById(4L).orElse(null);
            singerService.delete(singerDel);
  */
        }
    }
}
