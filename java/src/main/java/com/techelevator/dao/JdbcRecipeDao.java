package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Recipe getRecipeById(int recipeId) {
        Recipe recipe = null;

        String sql = "SELECT recipe_id, recipe_name, directions, tags, prep_time, food_pic, is_public " +
                "FROM recipes " +
                "WHERE recipe_id = ?;";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, recipeId);
        while(row.next()){
            recipe = mapRowsetToRecipe(row);
        }
        return recipe;
    }

    @Override
    public List<Recipe> getAllRecipes(int userId) {
        List<Recipe> allRecipes = new ArrayList<>();

        String sql = "SELECT recipes.recipe_id, recipe_name, directions, tags, prep_time, food_pic, is_public " +
                "FROM recipes " +
                "JOIN users_recipes ON users_recipes.recipe_id = recipes.recipe_id " +
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

        int newRecipeId = jdbcTemplate.queryForObject(sql, Integer.class,newRecipe.getRecipeName(), newRecipe.getDirections(),
                                                        newRecipe.getTags(), newRecipe.getPrepTime(), newRecipe.getFoodPic(), newRecipe.isPublic(), userId);
        addedRecipe = getRecipeById(newRecipeId);

        sql = "INSERT INTO users_recipes (user_id, recipe_id) VALUES(?, ?);";

        jdbcTemplate.update(sql, userId, newRecipeId);
        return addedRecipe;
    }

    @Override
    public void deleteRecipe(int recipeId, int userId) {
        String sql = "SELECT created_by FROM recipes WHERE recipe_id = ?;";
        int createdByUserId = jdbcTemplate.queryForObject(sql, Integer.class, recipeId);

        if(createdByUserId == userId){
            sql = "DELETE FROM recipe_ingredients WHERE recipe_id = ?;";
            jdbcTemplate.update(sql, recipeId);
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
        String sql = "UPDATE recipes SET recipe_name=?, directions=?, tags=?, prep_time=?, "
                + "food_pic=?, is_public=? WHERE recipe_id=?;";

        jdbcTemplate.update(sql, modifiedRecipe.getRecipeName(), modifiedRecipe.getDirections(),
                modifiedRecipe.getTags(), modifiedRecipe.getPrepTime(), modifiedRecipe.getFoodPic(),
                modifiedRecipe.isPublic(), recipeId);

        changedRecipe = getRecipeById(recipeId);

        return changedRecipe;
    }

    @Override
    public void addImageToFile(int recipeId, MultipartFile image)  throws IOException {




        Path filePath = Paths.get("C:\\Users\\Student\\workspace\\final-capstone-team-2\\java\\images", image.getOriginalFilename());
           // String filePath = "C:\\Users\\Student\\workspace\\final-capstone-team-2\\java\\images" + image.getOriginalFilename();
            image.transferTo(filePath);


//        Path filePath = Paths.get("C:\\Users\\Student\\workspace\\final-capstone-team-2\\java\\images", image.getOriginalFilename());
//        try (OutputStream os = Files.newOutputStream(filePath)) {
//            os.write(image.getBytes());
//
//            String sql = ("UPDATE recipes SET food_pic = ? WHERE recipe_id = ?;");
//            jdbcTemplate.update(sql, filePath, recipeId);
//        }
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
