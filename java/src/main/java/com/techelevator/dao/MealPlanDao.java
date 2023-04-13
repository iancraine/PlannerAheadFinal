package com.techelevator.dao;

import com.techelevator.model.MealPlan;

import java.util.List;

public interface MealPlanDao {

     List<List<MealPlan>> listAllMealPlans(int userId);

     List<MealPlan> getMealPlansById(int mealPlanId);

     List<MealPlan> addMealPlan(List<MealPlan> newMealPlan, int userId);

     void deleteMealPlan(int userId,int mealPlanId);

     List<MealPlan> updateMealPlan(List<MealPlan> updatedMealPlan);
}
