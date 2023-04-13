package com.techelevator.controller;

import com.techelevator.dao.MealPlanDao;
import com.techelevator.model.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.callback.SecretKeyCallback;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/mealplans")
public class MealPlanController {

    @Autowired
    private MealPlanDao mealPlanDao;


    @RequestMapping(path="/list/{userId}",method= RequestMethod.GET)
    public List<List<MealPlan>> listAllMealPlans(@PathVariable int userId) {
       return mealPlanDao.listAllMealPlans (userId);
    }

    @RequestMapping(path="/{mealPlanId}", method= RequestMethod.GET)
    public List<MealPlan> getMealPlanById(@PathVariable int mealPlanId){
        return mealPlanDao.getMealPlansById(mealPlanId);
    }

 @RequestMapping(path="/add/{userId}", method= RequestMethod.POST)
   public  List<MealPlan> addMealPlan(@PathVariable int userId, @RequestBody List<MealPlan> newMealPlan){
        return mealPlanDao.addMealPlan(newMealPlan, userId);
 }

 @RequestMapping(path="/{userId}/{mealPlanId}", method=RequestMethod.DELETE)
    public void deleteMealPlan(@PathVariable int mealPlanId, @PathVariable int userId){
        mealPlanDao.deleteMealPlan(userId,mealPlanId);
 }

 @RequestMapping(path="/{mealPlanId}", method=RequestMethod.PUT)
 public List<MealPlan> updateMealPlan(@PathVariable int mealPlanId,@RequestBody List<MealPlan> mealPlan){
        return mealPlanDao.updateMealPlan(mealPlan);
 }


}
