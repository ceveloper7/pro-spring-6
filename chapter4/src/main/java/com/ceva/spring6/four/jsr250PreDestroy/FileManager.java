package com.ceva.spring6.four.jsr250PreDestroy;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    private static Logger LOGGER = LoggerFactory.getLogger(FileManager.class);
    private Path file;

    public FileManager() {
        LOGGER.info("Creating bean of type {}", FileManager.class);
        try {
            file = Files.createFile(Path.of("sample"));
        } catch (IOException e) {
            LOGGER.error("Could not create file");
        }
    }

    @PreDestroy
    private void preDestroy() throws IOException {
        LOGGER.info("Calling preDestroy() on bean of type {}",FileManager.class);
        if (file != null) {
            Files.deleteIfExists(file);
        }
    }
}
