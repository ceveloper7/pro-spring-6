package com.ceva.spring6.ten;

import com.ceva.spring6.ten.config.DataJpaCfg;
import com.ceva.spring6.ten.services.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class AlbumServiceDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumServiceDemo.class);

    @Autowired
    AlbumService albumService;

    private void testFindWithReleaseDateGreaterThan(AlbumService service){
        var albumns = service
                .findWithReleaseDateGreaterThan(LocalDate.of(2010,1,1))
                .peek(album -> {
                    LOGGER.info(album.toString());
                }).toList();
    }

    private void testFindByTitle(AlbumService service){
        var albums = service
                .findByTitle("The")
                .peek(album -> {
                    LOGGER.info(album.toString());
                }).toList();
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(DataJpaCfg.class);
        var service = ctx.getBean(AlbumService.class);
        AlbumServiceDemo serviceDemo = new AlbumServiceDemo();

        serviceDemo.testFindByTitle(service);
        //serviceDemo.testFindWithReleaseDateGreaterThan(service);
    }
}
