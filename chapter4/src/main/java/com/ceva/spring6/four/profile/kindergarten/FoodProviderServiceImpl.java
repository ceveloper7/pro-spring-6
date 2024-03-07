package com.ceva.spring6.four.profile.kindergarten;

import com.ceva.spring6.four.profile.Food;
import com.ceva.spring6.four.profile.FoodProviderService;

import java.util.List;

/**
 * Implementacion de FoodProviderService para los kindergarten
 */
public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        return List.of(new Food("Milk"), new Food("Biscuits"));
    }
}
