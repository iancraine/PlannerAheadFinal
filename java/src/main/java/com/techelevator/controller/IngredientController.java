package com.techelevator.controller;

import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.JdbcIngredientDao;
import com.techelevator.model.Ingredient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientDao ingredientDao;

    public IngredientController (JdbcIngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Ingredient> getAllIngredients() {
        return ingredientDao.getAllIngredients();
    }

    @RequestMapping(path="/recipe/{recipeId}", method=RequestMethod.GET)
    public List<Ingredient> getIngredientsForRecipe(@PathVariable int recipeId) {
        return ingredientDao.getIngredientsForRecipe(recipeId);
    }

    @RequestMapping(path="/user/{userId}", method=RequestMethod.POST)
    public void addIngredientToDB(@RequestBody Ingredient ingredient, @PathVariable int userId) {
        ingredientDao.addIngredient(ingredient, userId);
    }

    @RequestMapping(path="/recipe/{recipeId}/{amount}", method=RequestMethod.POST)
    public void addIngredientToRecipe(@RequestBody Ingredient ingredient, @PathVariable int recipeId, String amount) {
        ingredientDao.addIngredientToRecipe(ingredient, recipeId, amount);
    }

    @RequestMapping(path="/{userId}/{recipeId}", method=RequestMethod.DELETE)
    public void deleteIngredientsForRecipe(@PathVariable int userId, @PathVariable int recipeId, @RequestBody Ingredient ingredient) {
        ingredientDao.deleteIngredientForRecipe(ingredient, recipeId, userId);
    }

}
