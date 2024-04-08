package com.ceva.spring6.seven.base.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "album")
public class Album extends AbstractEntity{
    @Serial
    private static final long serialVersionUID = 3L;

    protected Long id;
    private String title;
    private LocalDate releaseDate;

    private Singer singer;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "album_id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // @JoinColumn es necesaria para para especificar el nombre de la columna
    // de clave externa subyacente.
    @ManyToOne
    @JoinColumn(name = "singer_id")
    public Singer getSinger() {
        return this.singer;
    }

    @Column
    public String getTitle() {
        return this.title;
    }

    @Column(name = "release_date")
    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Album album = (Album) o;
        if(album.getId()!= null && this.getId() != null) {
            return super.equals(o);
        }
        return title.equals(album.title) && releaseDate.equals(album.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, releaseDate);
    }

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Singer id: " + (singer != null ? singer.getId() :"")
                + ", Title: " + title + ", Release Date: " + releaseDate;
    }
}
