package com.ceva.spring6.three.nesting.beans;

/*
 * Este bean obtendran el nombre del titulo de los beans ApplicationContext principal y secundario.
 */
public class Song {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
