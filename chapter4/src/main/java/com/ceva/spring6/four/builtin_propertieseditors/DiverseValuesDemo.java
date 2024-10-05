package com.ceva.spring6.four.builtin_propertieseditors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class DiverseValuesDemo {
    public static void main(String... args) throws Exception {
        //System.out.println(System.getProperty("java.io.tmpdir"));
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        Path path = Files.createFile(Path.of(baseDir.getAbsolutePath(), "test1.txt"));
        Files.writeString(path, "Hello World!");
        path.toFile().deleteOnExit();

        var ctx = new AnnotationConfigApplicationContext(PropertiesEditorCfg.class);
        //ctx.register(ValuesHolder.class, DiverseValuesContainer.class);
        //ctx.refresh();

        ctx.close();
    }
}
