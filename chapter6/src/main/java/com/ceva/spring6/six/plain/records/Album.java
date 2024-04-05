package com.ceva.spring6.six.plain.records;

import java.time.LocalDate;

public record Album(Long id,
                    Long singerId,
                    String title,
                    LocalDate releaseDate) {}