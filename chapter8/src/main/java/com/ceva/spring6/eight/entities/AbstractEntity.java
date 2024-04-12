package com.ceva.spring6.eight.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

import java.io.Serial;
import java.io.Serializable;

/**
 * esta entidad no se asigna a ninguna tabla
 */
@MappedSuperclass // La informacion de esta clase se aplica a clases que heredan de ella
public class AbstractEntity implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    //protected Long id;
    protected int version;

//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "ID")
//    public Long getId() {
//        return this.id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    /**
     * @Version le indica a Hibernate que emplee un mecanismo de bloqueo optimista usando
     * el atributo version como control.
     * Cada vez que hibernate actualiza un registro, compara la version de la entidad
     * de la entidad con la del reistro de la BD. Si ambas versiones son iguales,
     * significa que nadie actualizo los datos antes, por lo que hibernate actualizara
     * los datos e incrementara la columna version.
     */
    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    // equals & hashCode are very limited in scope in this scenario
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AbstractEntity that = (AbstractEntity) o;
//        return Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
