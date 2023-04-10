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
    public Recipe addNewRecipe(Recipe newRecipe, int userId) {
        Recipe addedRecipe = null;
        String sql = "INSERT INTO recipes (recipe_name, directions, tags, prep_time, food_pic, is_public, created_by) " +
                 "VALUES(?, ?, ?, ?, ?, ?, ?) RETURNING recipe_id;";

        int newRecipeId = jdbcTemplate.queryForObject(sql, int.class, newRecipe.getRecipeName(), newRecipe.getDirections(),
                                                        newRecipe.getTags(), newRecipe.getPrepTime(), newRecipe.getFoodPic(), newRecipe.isPublic(), userId);
        addedRecipe = getRecipeById(newRecipeId);

        String insertToUsersRecipe = "INSERT INTO users_recipes (user_id, recipe_id) " +
                                     "VALUES(?, ?);";

        jdbcTemplate.update(sql, userId, newRecipeId);
        return addedRecipe;
    }

    @Override
    public void deleteRecipe(int recipeId, int userId) {
        String sql = "SELECT created_by FROM recipes WHERE recipe_id = ?;";
        int createdByUserId = jdbcTemplate.queryForObject(sql, Integer.class, recipeId);

        if(createdByUserId == userId){
            sql = "DELETE FROM users_recipes WHERE recipe_id = ?;";
            jdbcTemplate.update(sql, recipeId);
            sql = "DELETE FROM recipes WHERE recipe_id=?;";
            jdbcTemplate.update(sql, recipeId);
        } else {
            sql = "DELETE FROM users_recipes WHERE recipe_id = ? AND user_id = ?;";
            jdbcTemplate.update(sql, recipeId, userId);
        }

    }

    @Override
    public Recipe modifyRecipe(Recipe modifiedRecipe, int recipeId) {
        Recipe changedRecipe = null;
        String sql = "UPDATE recipe SET recipe_name=?, directions=?, tags=?, prep_time=?, "
                + "food_pic=?, is_public=? WHERE recipe_id=?;";

        jdbcTemplate.update(sql, modifiedRecipe.getRecipeName(), modifiedRecipe.getDirections(),
                modifiedRecipe.getTags(), modifiedRecipe.getPrepTime(), modifiedRecipe.getFoodPic(),
                modifiedRecipe.isPublic(), recipeId);

        changedRecipe = getRecipeById(recipeId);

        return changedRecipe;
    }

    public Recipe mapRowsetToRecipe(SqlRowSet row){
        Recipe recipe = new Recipe();

        recipe.setRecipeId(row.getInt("recipe_id"));
        recipe.setRecipeName(row.getString("recipe_name"));
        recipe.setDirections(row.getString("directions"));
        recipe.setTags(row.getString("tags"));
        recipe.setPrepTime(row.getInt("prep_time"));
        recipe.setFoodPic(row.getString("food_pic"));
        recipe.setPublic(row.getBoolean("is_public"));

        return recipe;
    }
}
