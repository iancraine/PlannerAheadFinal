package com.techelevator.dao;

import com.techelevator.model.DailyPlan;
import com.techelevator.model.WeeklyPlan;

import java.util.List;

public interface WeeklyPlanDao {

    List<WeeklyPlan> getWeeklyMealPlanByUserId(int userId);

    WeeklyPlan createWeeklyMealPlan(WeeklyPlan weeklyPlan, int userId);

    void deleteWeeklyMealPlan(int userId, int weeklyplanId);

    WeeklyPlan modifyWeeklyMealPlan(int weeklyplanId, WeeklyPlan modifyweeklyPlan);
}
