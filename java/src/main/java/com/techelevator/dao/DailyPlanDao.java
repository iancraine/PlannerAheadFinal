package com.techelevator.dao;

import com.techelevator.model.DailyPlan;

import java.util.List;

public interface DailyPlanDao {

    List<DailyPlan> getDailyMealPlansByUserId(int userId);

    DailyPlan getDailyPlanById(int dailyPlanId);

    DailyPlan createDailyMealPlan(DailyPlan dailyPlan, int userId);

    void deleteDailyMealPlan(int dailyPlanId, int userId);

    DailyPlan modifyDailyMealPlan(DailyPlan dailyPlan, int userId);
}
