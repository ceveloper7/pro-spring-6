package com.ceva.spring6.seven.base.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "singer")
@NamedQueries({
        @NamedQuery(name="Singer.findById",
                query="""
      				select distinct s from Singer s 
					left join fetch s.albums a 
					left join fetch s.instruments i 
					where s.id = :id
					"""),
        @NamedQuery(name="Singer.findAllWithAlbum",
                query="""
      				select distinct s from Singer s 
					left join fetch s.albums a 
					left join fetch s.instruments i 
					""")
})

@NamedStoredProcedureQuery(
        name = "getFirstNameByIdProc",
        procedureName = "getFirstNameByIdProc",
        parameters = {
                @StoredProcedureParameter(
                        name = "in_id",
                        type = Long.class,
                        mode = ParameterMode.IN
                ),
                @StoredProcedureParameter(
                        name = "fn_res",
                        type = String.class,
                        mode = ParameterMode.OUT
                )
        }
)
/**
 * Cada Singer puede tocar CERO O MUCHOS instrumentos
 */
public class Singer extends AbstractEntity{
    @Serial
    private static final long serialVersionUID = 2L;

    protected Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<Album> albums = new HashSet<>();
    private Set<Instrument> instruments = new HashSet<>();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "singer_id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    @Column(name = "birth_date")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * La clase Singer declara la relacion UNO A MUCHOS de la relacion con Album
     * La clase Album declara la relacion de MUCHOS A UNO de la relacion con Singer
     * Cada Singer tiene cero o mas album
     * mappedBy indica la propiedad de la clase Album que es la propiedad singer
     */
    @OneToMany(mappedBy = "singer", cascade=CascadeType.ALL, orphanRemoval=true)
    public Set<Album> getAlbums() {
        return albums;
    }

    /**
     * @JoinTable permite indicar la tabla de union subyacente que Hibernate debe buscar,
     * el nombre es el nombre de la tabla de union.
     * JoinColumn define la columna que es la clave externa para la Tabla Singer
     * inverseJoinColumns define la columna que es la clave externa para el otro lado
     * de la asociacion, es decir, table Instrument.
     */
    @ManyToMany
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "singer_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_id"))
    public Set<Instrument> getInstruments() {
        return instruments;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean addAlbum(Album album) {
        album.setSinger(this);
        return getAlbums().add(album);
    }

    public void removeAlbum(Album album) {
        getAlbums().remove(album);
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }

    public boolean addInstrument(Instrument instrument) {
        return getInstruments().add(instrument);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singer that = (Singer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
