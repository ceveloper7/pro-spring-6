package com.ceva.spring6.four.profile.highschool;

import com.ceva.spring6.four.profile.Food;
import com.ceva.spring6.four.profile.FoodProviderService;

import java.util.List;

/**
 * Implementacion de FoodProviderService para las escuelas
 */
public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        return List.of(new Food("Coke"), new Food("Hamburger"), new Food("Fries"));
    }
}
