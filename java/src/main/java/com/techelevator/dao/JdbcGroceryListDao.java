package com.techelevator.dao;

import com.techelevator.model.GroceryList;
import com.techelevator.model.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcGroceryListDao implements GroceryListDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcGroceryListDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GroceryList> getAllListItems(int userId) {
        List<GroceryList> groceryList = new ArrayList<>();
        String sql = "SELECT list_id, ingredient_name, non_food_option, quantity " +
                "FROM grocery_list " +
                "LEFT JOIN ingredients ON ingredients.ingredient_id = grocery_list.ingredient_id " +
                "WHERE user_id = ?" +
                "ORDER BY ingredient_name;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);

        while(row.next()){
            groceryList.add(mapRowToGroceryList(row));
        }

        return groceryList;
    }

    @Override
    public List<GroceryList> addItemsToGroceryList(int userId, List<GroceryList> itemsFromFront) {
        List<GroceryList> newGroceryList = new ArrayList<>();
        String sql = "INSERT INTO grocery_list (user_id, ingredient_id, non_food_option, quantity) " +
                "VALUES (?, ?, ?, ?);";

        for(GroceryList item : itemsFromFront){
            if(item.getIngredient_name() == null){
                jdbcTemplate.update(sql, userId, null, item.getNon_food_option(), item.getQuantity());
            } else {
                String sqlTwo = "SELECT ingredient_id FROM ingredients WHERE ingredient_name = ?;";
                int ingredientID = jdbcTemplate.queryForObject(sqlTwo, Integer.class, item.getIngredient_name());
                jdbcTemplate.update(sql, userId, ingredientID, null, item.getQuantity());
            }
        }
        return getAllListItems(userId);
    }


    @Override
    public void clearGroceryList(int userId) {
        String sql = "DELETE FROM grocery_list WHERE user_id = ?;";
        jdbcTemplate.update(sql, userId);

    }

    @Override
    public void deleteSelectedGroceries(int listId) {
        String sql = "DELETE FROM grocery_list WHERE list_id = ?;";
        jdbcTemplate.update(sql, listId);
    }

    public GroceryList mapRowToGroceryList(SqlRowSet row){
        GroceryList groceryList = new GroceryList();

        groceryList.setList_id(row.getInt("list_id"));
        groceryList.setIngredient_name(row.getString("ingredient_name"));
        groceryList.setNon_food_option(row.getString("non_food_option"));
        groceryList.setQuantity(row.getString("quantity"));

        return groceryList;
    }
}
