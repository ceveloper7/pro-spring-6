package com.ceva.spring6.seven.base;

import com.ceva.spring6.seven.base.config.HibernateConfig;
import com.ceva.spring6.seven.base.dao.SingerDao;

import com.ceva.spring6.seven.base.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class HibernateDemoV1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateDemoV1.class);

    private static void listingAllSingers(SingerDao singerDao){
        LOGGER.info(" ---- Listing singers:");
        singerDao.findAll().forEach(s -> LOGGER.info(s.toString()));
    }

    private static void getSingerById(SingerDao singerDao){
        LOGGER.info(" ---- Ge Singer by Id:");
        var s = singerDao.findById(1L);
        LOGGER.info(s.toString());
        if(s.getAlbums() != null){
            s.getAlbums().forEach(a -> LOGGER.info("\t" + a.toString()));
        }

        if(s.getInstruments() != null){
            s.getInstruments().forEach(i -> LOGGER.info("\tInstrument: " + i.getInstrumentId()));
        }
        //LOGGER.info(singer.toString());
    }

    private static void listSingerWithAlbum(SingerDao singerDao){
        List<Singer> singers = singerDao.findAllWithAlbum();
        LOGGER.info(" ---- Listing singers with instruments:");
        singers.forEach(s -> {
            LOGGER.info(s.toString());
            if(s.getAlbums() != null){
                s.getAlbums().forEach(a -> LOGGER.info("\t" + a.toString()));
            }

            if(s.getInstruments() != null){
                s.getInstruments().forEach(i -> LOGGER.info("\tInstrument: " + i.getInstrumentId()));
            }
        });
    }

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
        var singerDao = ctx.getBean(SingerDao.class);

        //listingAllSingers(singerDao);
        //getSingerById(singerDao);
        listSingerWithAlbum(singerDao);

        // this works, but you have to recreate your container to run the other demo class ;)
        //singerDao.delete(singer);


        ctx.close();
    }
}
