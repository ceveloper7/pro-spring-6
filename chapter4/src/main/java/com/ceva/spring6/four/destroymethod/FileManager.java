package com.ceva.spring6.four.destroymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    private static Logger logger = LoggerFactory.getLogger(FileManager.class);
    private Path file;

    public FileManager() {
        logger.info("Creating bean of type {}", FileManager.class);
        try {
            file = Files.createFile(Path.of("sample"));
        } catch (IOException e) {
            logger.error("Could not create file");
        }
    }

    // eliminamos el archivo creado en el constructor. este metodo se llama antes que el bean fileManager se destruya
    private void destroyMethod() throws IOException {
        logger.info("Calling destroyMethod() on bean of type {}", FileManager.class);
        if (file != null) {
            // eliminamos el archivo creado en el constructor
            Files.deleteIfExists(file);
        }
    }
}
