package com.ceva.spring6.ten;

import com.ceva.spring6.ten.config.DataJpaCfg;
import com.ceva.spring6.ten.services.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingerServiceDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(SingerServiceDemo.class);
    @Autowired
    SingerService singerService;

    private void testFindAllSingers(SingerService service){
        var singers = service.findAll()
                .peek(singer ->{
                    LOGGER.info(singer.toString());
                }).toList();
    }

    private void testFindByFirstName(SingerService service){
        var singers = service.findByFirstName("ALexander")
                .peek(singer -> {
                    LOGGER.info(singer.toString());
                }).toList();
    }

    private void testFIndByFirstNameAndLastName(SingerService service){
        var singers = service.findByFirstNameAndLastName("Ben", "Barnes")
                .peek(singer -> {
                    LOGGER.info(singer.toString());
                }).toList();
    }

    private void testUpdateFirstNameByQuery(SingerService service){
        var nina = service.updateFirstName("John Alexander", 1L);
        LOGGER.info(nina.toString());
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(DataJpaCfg.class);
        var service = ctx.getBean(SingerService.class);

        SingerServiceDemo serviceDemo = new SingerServiceDemo();

        serviceDemo.testUpdateFirstNameByQuery(service);
        //serviceDemo.testFIndByFirstNameAndLastName(service);
        //serviceDemo.testFindByFirstName(service);
        //serviceDemo.testFindAllSingers(service);
    }

}
