package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    private RecipeDao recipeDao;



}
