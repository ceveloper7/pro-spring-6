package com.ceva.spring6.six.plain;

import com.ceva.spring6.six.plain.dao.pojos.PlainSingerDao;
import com.ceva.spring6.six.plain.dao.pojos.SingerDao;
import com.ceva.spring6.six.plain.pojos.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class PlainJdbcDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlainJdbcDemo.class);

    private static final SingerDao singerDao = new PlainSingerDao();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            LOGGER.error("Problem loading DB Driver!", ex);
        }
    }
    public static void main(String... args) {
        LOGGER.info("Listing initial singer data:");

        listAllSingers();

        LOGGER.info("-------------");
        LOGGER.info("Insert a new singer");
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(LocalDate.of(1991,2, 17));
        singerDao.insert(singer);
        LOGGER.info("The singer has ID now: {}", singer.getId());
        LOGGER.info("-------------");

        LOGGER.info("Listing singer data after new singer created:");
        listAllSingers();

        LOGGER.info("-------------");
        LOGGER.info("Deleting the previous created singer");
        singerDao.delete(singer.getId());
        LOGGER.info("Listing singer data after new singer deleted:");

        LOGGER.info("---------------");
        LOGGER.info("Print Singers first and last names");
        //allSingerNames();
        listAllSingers();
    }

    private static void listAllSingers() {
        var singers = singerDao.findAll();
        singers.forEach(System.out::println);
    }

    private static void allSingerNames(){
        var singers = singerDao.findAll();
        List<String> singerNames = singers.stream()
                .map(singer -> singer.getFirstName() + " " + singer.getLastName())
                .collect(toList());
        System.out.println(singerNames.toString());
    }
}
