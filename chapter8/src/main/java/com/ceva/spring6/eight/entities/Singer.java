package com.ceva.spring6.eight.entities;

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
        @NamedQuery(name=Singer.FIND_ALL, query="select s from Singer s"),
        @NamedQuery(name=Singer.FIND_SINGER_BY_ID,
                query="""
      				select distinct s from Singer s
     				left join fetch s.albums a
					left join fetch s.instruments i
					where s.id = :id
					"""),
        @NamedQuery(name=Singer.FIND_ALL_WITH_ALBUM,
                query="""
      				select distinct s from Singer s
					left join fetch s.albums a
					left join fetch s.instruments i
					""")
})
// Asignacion SQL ResultSet
@SqlResultSetMapping(
        name="singerResult",
        entities=@EntityResult(entityClass=Singer.class)
)
// using stored Function
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Singer.getFirstNameById(?)",
                query = "select getFirstNameById(?)")
})
// using stored procedure
@NamedStoredProcedureQuery(
        name = "getFirstNameByIdProc",
        procedureName = "getFirstNameById",
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
public class Singer extends AbstractEntity{
    @Serial
    private static final long serialVersionUID = 2L;

    public static final String FIND_ALL = "Singer.findAll";
    public static final String FIND_SINGER_BY_ID = "Singer.findById";
    public static final String FIND_ALL_WITH_ALBUM = "Singer.findAllWithAlbum";

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

    @OneToMany(mappedBy = "singer", cascade=CascadeType.ALL, orphanRemoval=true)
    public Set<Album> getAlbums() {
        return albums;
    }

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
        Singer singer = (Singer) o;
        if(this.id != null) {
            return this.id.equals(((Singer) o).id);
        }
        return firstName.equals(singer.firstName) && lastName.equals(singer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
