package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {


    Recipe getRecipeById(int id);

    List<Recipe> getAllRecipes(int userId);

    Recipe addNewRecipe(Recipe newRecipe, int userId);

    void deleteRecipe(int recipeId, int userId);

    Recipe modifyRecipe(Recipe modifiedRecipe, int recipeId);

}
