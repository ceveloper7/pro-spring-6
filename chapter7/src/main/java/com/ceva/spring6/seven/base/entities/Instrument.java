package com.ceva.spring6.seven.base.entities;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Cada Instrumento esta asociado con CERO O MUCHOS Singer.
 * Si Singer tiene una relacion de cero a muchos con instrument e Instrument
 * tiene una relacion de cero a muchos con Singer estamos hablando de un mapeo
 * de muchos a muchos.
 * Una asignacion de muchos a muchos requiere una tercera tabla de union, en este
 * caso es la tabala SINGER_INSTRUMENT.
 */
@Entity
@Table(name = "instrument")
public class Instrument implements Serializable{
    @Serial
    private static final long serialVersionUID = 4L;
    private String instrumentId;
    private Set<Singer> singers = new HashSet<>();

    @Id
    @Column(name = "instrument_id")
    public String getInstrumentId() {
        return this.instrumentId;
    }

    @ManyToMany
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "instrument_id"),
            inverseJoinColumns = @JoinColumn(name = "singer_id"))
    public Set<Singer> getSingers() {
        return this.singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    @Override
    public String toString() {
        return "Instrument :" + getInstrumentId();
    }
}
