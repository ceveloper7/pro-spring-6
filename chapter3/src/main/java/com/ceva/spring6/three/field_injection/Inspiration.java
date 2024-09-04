package com.ceva.spring6.three.field_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * Este bean sera inyectado en la variable de instancia llamada inspiration del bean Singer
 * EL field injection es un metodo de inyeccion de dependencia no recomendado.
 *
 */
@Component
public class Inspiration {
    private String lyric = "I can keep the door cracked open, to let light through";

    public Inspiration(@Value("For all my running, I can understand") String lyric) {
        this.lyric = lyric;
    }
    public String getLyric() {
        return lyric;
    }
    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
}
