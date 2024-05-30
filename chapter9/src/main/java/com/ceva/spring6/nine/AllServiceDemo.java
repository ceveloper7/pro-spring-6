package com.ceva.spring6.nine;

import com.ceva.spring6.nine.config.TransactionCfg;
import com.ceva.spring6.nine.services.AllService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Collectors;


public class AllServiceDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllServiceDemo.class);

    @Autowired
    AllService service;

    private void testFindAll(AllService service){
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

    private void testUpdate(AllService service){
        // recuperamos un singer
        var singer = service.findByIdWithAlbums(1L).orElse(null);
        // recuperamos albums del cantante
        var album = singer.getAlbums().stream()
                .filter(a -> a.getTitle().equals("Battle Studies"))
                .findFirst().orElse(null);
        singer.setFirstName("John ALexander");
        singer.setLastName("MAyer");
        int version = singer.getVersion();

        service.update(singer);
    }

    private void testCount(AllService service){
        var singers = service.findAllWithAlbums().collect(Collectors.toSet());
        var count = service.countSingers();

        if(count == singers.size()){
            LOGGER.info("son iguales");
        }else{
            LOGGER.info("no son iguales");
        }
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(TransactionCfg.class);
        var service = ctx.getBean(AllService.class);

        AllServiceDemo serviceDemo = new AllServiceDemo();
        serviceDemo.testFindAll(service);
        serviceDemo.testUpdate(service);
        serviceDemo.testCount(service);
    }
}
