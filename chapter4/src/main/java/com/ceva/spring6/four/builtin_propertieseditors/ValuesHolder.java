package com.ceva.spring6.four.builtin_propertieseditors;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Component
class ValuesHolder {

    List<String> stringList;
    InputStream inputStream;

    public ValuesHolder() {
        this.stringList = List.of("Mayer", "Psihoza", "Mazikeen");
        try {
            this.inputStream = new FileInputStream(
                    System.getProperty("java.io.tmpdir")
                            + System.getProperty("file.separator")
                            + "test.txt"
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // we are not interested in the exception that much
        }
    }

    public List<String> getStringList() {
        return stringList;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}