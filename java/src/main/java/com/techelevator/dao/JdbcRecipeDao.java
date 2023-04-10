package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Recipe getRecipeById(int recipeId) {
        Recipe recipe = new Recipe();

        String sql = "SELECT recipe_id, recipe_name, directions, tags, prep_time, food_pic, is_public " +
                "FROM recipes " +
                "WHERE recipe_id = ?;";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, recipeId);
        return recipe = mapRowsetToRecipe(row);
    }

    @Override
    public List<Recipe> getAllRecipes(int userId) {
        List<Recipe> allRecipes = new ArrayList<>();

        String sql = "SELECT recipe_id, recipe_name, directions, tags, prep_time, food_pic, is_public " +
                "FROM recipes " +
                "JOIN users_recipes ur ON ur.recipe_id = recipe.recipe_id " +
                "WHERE user_id = ?;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);

        while(row.next()){
            allRecipes.add(mapRowsetToRecipe(row));
        }

        return allRecipes;
    }

    @Override
    public void addNewRecipe(Recipe newRecipe) {
        Recipe newRecipe = new Recipe();

        String sql = "INSERT INTO recipes (recipe_name, directions, tags, prep_time, food_pic, ) "

    }

    @Override
    public void deleteRecipe(int recipeId) {

    }

    @Override
    public Recipe modifyRecipe(Recipe modifiedRecipe) {
        return null;
    }

    public Recipe mapRowsetToRecipe(SqlRowSet row){
        Recipe recipe = new Recipe();

        recipe.setRecipeId(row.getInt("recipe_id"));
        recipe.setRecipeName(row.getString("recipe_name"));
        //recipe.setDirections(row.getString("directions"));
        //recipe.setTags(row.getObject("tags"));
        recipe.setPrepTime(row.getInt("prep_time"));
        recipe.setFoodPic(row.getString("food_pic"));
        recipe.setPublic(row.getBoolean("is_public"));

        return recipe;
    }
}
