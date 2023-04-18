package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

//TODO: what to do with authorization?!?!?!?
@CrossOrigin
@RequestMapping("/recipes")
@RestController
public class RecipeController {

    @Autowired
    private RecipeDao recipeDao;

    /**
     *Retrieve a single recipe by its recipeId and return it as an object
     * @param recipeId
     * @return Recipe
     */
    @RequestMapping(path = "/{recipeId}", method = RequestMethod.GET)
    public Recipe getRecipeById(@PathVariable int recipeId) {
        return recipeDao.getRecipeById(recipeId);
    }

    @RequestMapping(path="/list/{userId}", method=RequestMethod.GET)
    public List<Recipe> getAllRecipes(@PathVariable int userId) {
        return recipeDao.getAllRecipes(userId);
    }

    @RequestMapping(path="/{userId}", method=RequestMethod.POST)
    public Recipe addNewRecipe(@RequestBody Recipe recipe, @PathVariable int userId) {
        return recipeDao.addNewRecipe(recipe, userId);
    }

    @RequestMapping(path="/{recipeId}/{userId}", method=RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable int recipeId, @PathVariable int userId) {
        recipeDao.deleteRecipe(recipeId, userId);
    }

    @RequestMapping(path="/{recipeId}", method=RequestMethod.PUT)
    public Recipe modifyRecipe(@PathVariable int recipeId, @RequestBody Recipe recipe) {
        return recipeDao.modifyRecipe(recipe, recipeId);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(path="/images/{recipeId}", method = RequestMethod.POST)
    public void addImage(@PathVariable int recipeId, @RequestParam("file") MultipartFile image) throws IOException {
        recipeDao.addImageToFile(recipeId, image);
    }


}
