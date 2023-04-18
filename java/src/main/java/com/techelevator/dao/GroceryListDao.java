package com.techelevator.dao;

import com.techelevator.model.GroceryList;
import com.techelevator.model.Ingredient;

import java.util.List;

public interface GroceryListDao {

    List<GroceryList> getAllListItems(int userId);

    List<GroceryList> addItemsToGroceryList(int userId, List<GroceryList> itemsFromFront);

    void clearGroceryList(int userId);

}
