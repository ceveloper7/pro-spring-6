package com.ceva.spring6.four.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
public class ResourceDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(ResourceDemo.class);

    public static void main(String[] args) throws Exception{
        var ctx = new AnnotationConfigApplicationContext();

        File baseDir = new File(System.getProperty("user.home"));
        Path filePath = Files.createFile(Path.of(baseDir.getAbsolutePath(), "text.txt"));
        Files.writeString(filePath, "Hello World!");
        filePath.toFile().deleteOnExit();

//        Resource res1 = ctx.getResource("file://" + filePath);
//        displayInfo(res1);
//
        Resource res2 = ctx.getResource("classpath:test.txt");
        displayInfo(res2);

        Resource res3 = ctx.getResource("https://iuliana-cosmina.com");
        displayInfo(res3);
    }

    private static void displayInfo(Resource res) throws Exception{
        LOGGER.info("Resource class: {}" , res.getClass());
        LOGGER.info("Resource URL content: {}" ,  new BufferedReader(new InputStreamReader((InputStream) res.getURL().getContent())).lines().parallel().collect(Collectors.joining("\n")));
        LOGGER.info(" -------------");
    }
}
