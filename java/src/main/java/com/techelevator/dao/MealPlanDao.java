package com.techelevator.dao;

import com.techelevator.model.MealPlan;

import java.util.List;

public interface MealPlanDao {

     List<MealPlan> listAllMealPlans(int userId);

     MealPlan getMealPlanById(int mealPlanId);

     MealPlan addMealPlan(MealPlan newMealPlan, int userId);

     void deleteMealPlan(int mealPlanId, int userId);

     MealPlan updateMealPlan(MealPlan updatedMealPlan);
}
