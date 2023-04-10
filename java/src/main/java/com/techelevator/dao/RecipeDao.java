package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {


    Recipe getRecipeById(int id);

    List<Recipe> getAllRecipes(int userId);

    void addNewRecipe(Recipe newRecipe);

    void deleteRecipe(int recipeId);

    Recipe modifyRecipe(Recipe modifiedRecipe);

}
