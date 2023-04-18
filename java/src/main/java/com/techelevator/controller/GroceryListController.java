package com.techelevator.controller;

import com.techelevator.dao.GroceryListDao;
import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.JdbcGroceryListDao;
import com.techelevator.dao.JdbcIngredientDao;
import com.techelevator.model.GroceryList;
import com.techelevator.model.Ingredient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(path="/grocery")
public class GroceryListController {
    private final GroceryListDao groceryListDao;

    public GroceryListController (JdbcGroceryListDao groceryListDao) {
        this.groceryListDao = groceryListDao;
    }

    @RequestMapping(path="/list/{userId}", method = RequestMethod.GET)
    public List<GroceryList> getAllGroceryListItems(@PathVariable int userId){
        return groceryListDao.getAllListItems(userId);
    }


    @RequestMapping(path="/add/{userId}", method = RequestMethod.POST)
    public List<GroceryList> addGroceryItemsToList(@PathVariable int userId, @RequestBody List<GroceryList> groceryList){
        return groceryListDao.addItemsToGroceryList(userId, groceryList);
    }



    @RequestMapping(path="/delete/{userId}", method = RequestMethod.DELETE)
    public void deleteItemsInGroceryList(@PathVariable int userId){
        groceryListDao.clearGroceryList(userId);
    }


    @RequestMapping(path="/delete-partial/{listId}", method = RequestMethod.DELETE)
    public void deleteSelectedLists(@PathVariable int listId){
        groceryListDao.deleteSelectedGroceries(listId);
    }
}