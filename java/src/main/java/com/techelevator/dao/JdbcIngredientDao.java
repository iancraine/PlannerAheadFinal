package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcIngredientDao implements IngredientDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcIngredientDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // getting ALL recipes in database regardless of what the specific user added
    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();

        String sql = "SELECT * FROM ingredients;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        while(rowSet.next()) {
            ingredients.add(mapRowSetToIngredient(rowSet));
        }
        return ingredients;
    }

    // get ingredients for a recipe
    public List<Ingredient> getIngredientsForRecipe(int recipeId) {
        List<Ingredient> recipeIngredients = new ArrayList<>();

        String sql = "SELECT DISTINCT ingredients.ingredient_id, ingredients.ingredient_name, ingredients.ingredient_type, ri.amount "
                        + "FROM ingredients" +
                " JOIN recipe_ingredients ri ON ri.ingredient_id = ingredients.ingredient_id "
                        + "WHERE recipe_id = ?;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, recipeId);

        while(row.next()) {
            recipeIngredients.add(mapRowSetToIngredientWithAmount(row));
        }
        return recipeIngredients;
    }

    /* add ingredient to ingredients table (for accumulated list).
        Also add to users_ingredient to track who added it (so that if they update/delete, we can allow only the users that
        added it to delete it)
    */
    @Override
    public Ingredient addIngredient(Ingredient ingredientToAdd, int userId) {
        String sql = "INSERT INTO ingredients (ingredient_name) VALUES (?) RETURNING ingredient_id;";
        int newIngredientId = jdbcTemplate.queryForObject(sql, Integer.class, ingredientToAdd.getIngredientName());

        ingredientToAdd.setIngredientId(newIngredientId);

        sql = "INSERT INTO users_ingredients (user_id, ingredient_id) VALUES(?, ?);";
        jdbcTemplate.update(sql, userId, newIngredientId);

        return ingredientToAdd;
    }

    // add ingredients to recipes (linking them in recipe_ingredients)
    // can track what users select/type in for ingredients section (do a for loop in front end and call this method for each ingredient)
    // when making a new recipe and store that info here
    @Override
    public void addIngredientToRecipe(Ingredient ingredient, int recipeId, String amount) {
        String sql = "INSERT INTO recipe_ingredients (recipe_id, ingredient_id, amount) "
                    + "VALUES (?, ?, ?);";

        jdbcTemplate.update(sql, recipeId, ingredient.getIngredientId(), amount);
    }


    // deleting an ingredient from recipe (modifying)
    @Override
    public void deleteIngredientForRecipe(Ingredient ingredient, int recipeId, int userId) {
        // confirm that it's the user's recipe
        String sql = "SELECT * FROM users_recipes WHERE user_id=? AND recipe_id=?;";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId, recipeId);

        // if we have a row returned (meaning the recipe is stored as the user's specific recipe), then delete
        if (row.next()) {
            String deleteSql = "DELETE FROM recipe_ingredients WHERE ingredient_id =? AND recipe_id=?;";
            jdbcTemplate.update(deleteSql, ingredient.getIngredientId(), recipeId);
        }
    }
    @Override
    public void modifyIngredient(List<Ingredient> editedIngredients, int recipeId){

        for(Ingredient ingredient : editedIngredients){
            String sql = "UPDATE recipe_ingredients SET amount = ? WHERE ingredient_id = ? AND recipe_id = ?;";
            jdbcTemplate.update(sql, ingredient.getAmount(), ingredient.getIngredientId(), recipeId);


            sql = "UPDATE ingredients SET ingredient_name = ? WHERE ingredient_id = ?;";
            jdbcTemplate.update(sql, ingredient.getIngredientName(), ingredient.getIngredientId());
        }


    }

    private Ingredient mapRowSetToIngredientWithAmount(SqlRowSet row) {
        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientId(row.getInt("ingredient_id"));
        ingredient.setIngredientName(row.getString("ingredient_name"));
        ingredient.setAmount(row.getString("amount"));

        return ingredient;
    }
    private Ingredient mapRowSetToIngredient(SqlRowSet row) {
        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientId(row.getInt("ingredient_id"));
        ingredient.setIngredientName(row.getString("ingredient_name"));

        return ingredient;
    }
}
