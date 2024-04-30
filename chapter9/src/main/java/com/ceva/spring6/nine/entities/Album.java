package com.ceva.spring6.nine.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "album")
@NamedQueries({
        @NamedQuery(name=Album.FIND_ALL, query="select a from Album a where a.singer= :singer")
})
public class Album extends AbstractEntity{
    @Serial
    private static final long serialVersionUID = 3L;

    public static final String FIND_ALL = "Album.findAll";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "album_id")
    private Long id;

    @Column
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Singer getSinger() {
        return this.singer;
    }

    public String getTitle() {
        return this.title;
    }

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
        Album album = (Album) o;
        if(this.id != null) {
            return this.id.equals(((Album) o).id);
        }
        return title.equals(album.title) && releaseDate.equals(album.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate);
    }

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Singer id: " + singer.getId()
                + ", Title: " + title + ", Release Date: " + releaseDate;
    }
}
