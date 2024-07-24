package com.ceva.spring6.ten.services;

import com.ceva.spring6.ten.entities.Singer;
import com.ceva.spring6.ten.repos.SingerRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public interface SingerService {
    Stream<Singer> findAll() ;

    Stream<Singer> findByFirstName(String firstName) ;

    Stream<Singer> findByFirstNameAndLastName(String firstName, String lastName) ;

    Singer updateFirstName(String firstName, Long id);

    Stream<SingerRepository.FullName> findByLastName(String lastName);
}
