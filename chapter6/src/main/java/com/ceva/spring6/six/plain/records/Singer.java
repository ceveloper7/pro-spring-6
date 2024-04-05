package com.ceva.spring6.six.plain.records;

import java.time.LocalDate;
import java.util.Set;

public record Singer(Long id,
                     String firstName,
                     String lastName,
                     LocalDate birthDate,
                     Set<Album> albums) {}