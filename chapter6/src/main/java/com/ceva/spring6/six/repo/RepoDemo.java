package com.ceva.spring6.six.repo;

import com.ceva.spring6.six.config.BasicDataSourceCfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class RepoDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepoDemo.class);
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class, SingerJdbcRepo.class);
        var singerRepo = ctx.getBean("singerRepo", SingerRepo.class);

        LOGGER.info("--------------------------");
        var singers = singerRepo.findAll();
        singers.forEach(singer -> LOGGER.info(singer.toString()));

        LOGGER.info("--------------------------");
        var singerByFirstName = singerRepo.findByFirstName("John");
        singerByFirstName.forEach(singer -> LOGGER.info(singer.toString()));

        LOGGER.info("--------------------------");
//        var singerNameById = singerRepo.findNameById(1L);
//        LOGGER.info(singerNameById);

        // llamamos al procedimiento almacenado
        LOGGER.info("--------------------------");
//        var firstName = singerRepo.findFirstNameById(1L).orElse(null);
//        LOGGER.info("Retrieved {} ", firstName); // expect 'Ben'
        ctx.close();
    }
}
