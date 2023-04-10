package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcIngredientDao implements IngredientDao{
    @Override
    public void addIngredient(Ingredient ingredientToAdd) {

    }

    @Override
    public void deleteIngredient(int ingredientId) {

    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }
}
