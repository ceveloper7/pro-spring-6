package com.ceva.spring6.six.plain.pojos;

/*
 * Clase POJO Album: mapeo de la tabla Album
 */
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDate;
public class Album implements Serializable{
    private static final long serialVersionUID = 2L;
    private Long id;
    private Long singerId;
    private String title;
    private LocalDate releaseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSingerId() {
        return singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("singerId", singerId)
                .append("title", title)
                .append("releaseDate", releaseDate)
                .toString();
    }
}
