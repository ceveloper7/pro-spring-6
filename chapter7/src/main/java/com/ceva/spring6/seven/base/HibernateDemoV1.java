package com.ceva.spring6.seven.base;

import com.ceva.spring6.seven.base.config.HibernateConfig;
import com.ceva.spring6.seven.base.dao.SingerDao;

import com.ceva.spring6.seven.base.entities.Album;
import com.ceva.spring6.seven.base.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    private static void testInsertSinger(SingerDao singerDao){
        var singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(LocalDate.of(1940, 8, 16));

        var album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(LocalDate.of(1961, 7, 18));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(LocalDate.of(1962, 3, 20));
        singer.addAlbum(album);
        singerDao.save(singer);
    }

    private static void testUpdate(SingerDao singerDao){
        // get singer with id 1
        Singer singer = singerDao.findById(1L);
        // get specific album
        Album album = singer.getAlbums()
                .stream()
                .filter(a -> a.getTitle().equals("Battle Studies")).findFirst().orElse(null);

        // chage singer first_name
        singer.setFirstName("John Wiston");
        // remove specific album
        singer.removeAlbum(album);

        // update singer
        var john = singerDao.save(singer);
        int version = singer.getVersion();
        System.out.println("Version: " + john.getVersion());
        singerDao.findById(2L);

    }

    private static void testDelete(SingerDao singerDao){
        Singer singer = singerDao.findById(10L);
        singerDao.delete(singer);
    }

    private static void testNativeQuery(SingerDao singerDao){
        Singer s = singerDao.findAllDetails("John Wiston", "Mayer");
        LOGGER.info(s.toString());
        if(s.getAlbums() != null){
            s.getAlbums().forEach(a -> LOGGER.info("\t" + a.toString()));
        }

        if(s.getInstruments() != null){
            s.getInstruments().forEach(i -> LOGGER.info("\tInstrument: " + i.getInstrumentId()));
        }

    }

    private static void testFindAllNameByProjection(SingerDao singerDao){
        Set<String> names = singerDao.findAllNamesByProjection();
        names.forEach(n -> LOGGER.info(n));
    }

    private static void testFindFirstNameByIdUsingFunction(SingerDao singerDao){
        var name = singerDao.findFirstNameById(1L);
        LOGGER.info(name);
    }

    private static void testFindFirstNameByIdUsingProc(SingerDao singerDao){
        var firstName = singerDao.findFirstNameByIdUsingProc(1L);
        LOGGER.info(firstName);
    }

    private static void testFindFirstNameByIdUsingProcV2(SingerDao singerDao){
        var firstName = singerDao.findFirstNameByIdUsingProcV2(1L);
        LOGGER.info(firstName);
    }

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
        var singerDao = ctx.getBean(SingerDao.class);

        //listingAllSingers(singerDao);
        //getSingerById(singerDao);
        //testInsertSinger(singerDao);
        //testUpdate(singerDao);

        //testDelete(singerDao);
        //listSingerWithAlbum(singerDao);

        //testNativeQuery(singerDao);
        //testFindAllNameByProjection(singerDao);
        //testFindFirstNameByIdUsingFunction(singerDao);
        //testFindFirstNameByIdUsingProc(singerDao);
        testFindFirstNameByIdUsingProcV2(singerDao);


        // this works, but you have to recreate your container to run the other demo class ;)
        //singerDao.delete(singer);


        ctx.close();
    }
}
