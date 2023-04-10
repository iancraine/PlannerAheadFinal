package com.techelevator.dao;
import com.techelevator.model.Ingredient;

import java.util.List;

public interface IngredientDao {

    void addIngredient(Ingredient ingredientToAdd);

    void deleteIngredient(int ingredientId);

    List<Ingredient> getAllIngredients();
}
