package com.techelevator.dao;

import com.techelevator.model.MealPlan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcMealPlanDao implements MealPlanDao{
    @Override
    public List<MealPlan> listAllMealPlans(int userId) {
        return null;
    }

    @Override
    public MealPlan getMealPlanById(int mealPlanId) {
        return null;
    }

    @Override
    public MealPlan addMealPlan(MealPlan newMealPlan, int userId) {
        return null;
    }

    @Override
    public void deleteMealPlan(int mealPlanId, int userId) {

    }

    @Override
    public MealPlan updateMealPlan(MealPlan updatedMealPlan) {
        return null;
    }
}
