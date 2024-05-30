package com.ceva.spring6.nine;

import com.ceva.spring6.nine.config.TransactionCfg;
import com.ceva.spring6.nine.services.AllService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AllServiceDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllServiceDemo.class);

    @Autowired
    AllService service;

    void testFindAll(AllService service){
        var singers = service.findAllWithAlbums()
                .peek(singer -> {
                    LOGGER.info(singer.toString());
                    if(singer.getAlbums() != null){
                        singer.getAlbums().forEach(album -> {
                            LOGGER.info("\tAlbum" + album.toString());
                        });
                    }
                }).toList();
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(TransactionCfg.class);
        var service = ctx.getBean(AllService.class);

        AllServiceDemo serviceDemo = new AllServiceDemo();
        serviceDemo.testFindAll(service);
    }
}
