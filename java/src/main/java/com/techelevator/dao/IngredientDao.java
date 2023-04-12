package com.techelevator.dao;
import com.techelevator.model.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientDao {

    Ingredient addIngredient(Ingredient ingredientToAdd, int userId);

    void deleteIngredientForRecipe(Ingredient ingredient, int recipeId, int userId);

    void addIngredientToRecipe(Ingredient ingredient, int recipeId, String amount);

    List<Ingredient> getAllIngredients();

    List<Ingredient> getIngredientsForRecipe(int recipeId);
}
