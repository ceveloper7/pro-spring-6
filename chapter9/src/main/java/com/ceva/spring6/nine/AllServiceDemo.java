package com.ceva.spring6.nine;

import com.ceva.spring6.nine.config.ProgrammaticTransactionCfg;
import com.ceva.spring6.nine.config.TransactionCfg;
import com.ceva.spring6.nine.entities.Album;
import com.ceva.spring6.nine.ex.TitleTooLongException;
import com.ceva.spring6.nine.programmatic.ProgrammaticService;
import com.ceva.spring6.nine.services.AllService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;


public class AllServiceDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllServiceDemo.class);

    @Autowired
    AllService service;

    @Autowired
    ProgrammaticService programmaticService;

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

    private void testCount(ProgrammaticService programmaticService){
        var count = programmaticService.countSingers();
        System.out.println("Singers: " + count);
    }

    private void testRollbackRuntimeUpdate(AllService service) throws TitleTooLongException {
        var singer = service.findByIdWithAlbums(1L).orElse(null);
        singer.setFirstName("Eunice Kathleen");
        singer.setLastName("Waymon");

        var album = new Album();
        album.setTitle("Little Girl Blue");
        album.setReleaseDate(LocalDate.of(1959, 2, 20));
        album.setSinger(singer);

        var albums = Set.of(album);

        service.saveSingerWithAlbums(singer, albums);
    }

    private void testRollbackCheckedUpdate(AllService service) throws TitleTooLongException {
        var singer = service.findByIdWithAlbums(1L).orElse(null);
        singer.setFirstName("Eunice Kathleen");
        singer.setLastName("Waymon");

        var album = new Album();
        album.setTitle("""
                Sit there and count your fingers
                What can you do?
                Old girl you're through
                Sit there, count your little fingers
                unhappy little girl blue""");
        album.setReleaseDate(LocalDate.of(1959, 2, 20));
        album.setSinger(singer);
        var albums = Set.of(album);

        service.saveSingerWithAlbums(singer, albums);
    }


    public static void main(String[] args)throws TitleTooLongException {
        var ctx = new AnnotationConfigApplicationContext(TransactionCfg.class);
        var service = ctx.getBean(AllService.class);

        var ctx1 = new AnnotationConfigApplicationContext(ProgrammaticTransactionCfg.class);
        var programmaticService = ctx1.getBean(ProgrammaticService.class);

        AllServiceDemo serviceDemo = new AllServiceDemo();

//        serviceDemo.testFindAll(service);
//        serviceDemo.testUpdate(service);
//        serviceDemo.testCount(service);

//        serviceDemo.testRollbackRuntimeUpdate(service);
//        serviceDemo.testRollbackCheckedUpdate(service);

        serviceDemo.testCount(programmaticService);
    }
}
