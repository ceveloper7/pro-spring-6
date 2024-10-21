package com.ceva.spring6.four.profile;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que proporciona alimentos.
 */
@Service
public interface FoodProviderService {
    List<Food> provideLunchSet();
}
