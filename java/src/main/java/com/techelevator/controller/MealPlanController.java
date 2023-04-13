package com.techelevator.controller;

import com.techelevator.dao.MealPlanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/mealplans/")
public class MealPlanController {

    @Autowired
    private MealPlanDao mealPlanDao;

    

}
