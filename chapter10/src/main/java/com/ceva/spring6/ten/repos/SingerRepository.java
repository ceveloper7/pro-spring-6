package com.ceva.spring6.ten.repos;

import com.ceva.spring6.ten.entities.Singer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Interface Spring Data Domain Repository
 */
public interface SingerRepository extends CrudRepository<Singer, Long> {
    @Modifying
    Iterable<Singer> findByFirstName(String firstName);
    Iterable<Singer> findByFirstNameAndLastName(String firstName, String lastName);

    @Modifying(clearAutomatically = true)
    @Query("update Singer s set s.firstName = ?1 where s.id = ?2")
    int setFirstNameFor(String firstName, Long id);

    Iterable<FullName> findByLastName(String lastName);

    interface FullName {

        String getFirstName();
        String getLastName();

        default String getFullName() {
            return getFirstName().concat(" ").concat(getLastName());
        }
    }
}
