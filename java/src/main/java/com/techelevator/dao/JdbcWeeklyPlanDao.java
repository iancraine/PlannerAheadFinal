package com.techelevator.dao;

import com.techelevator.model.DailyPlan;
import com.techelevator.model.WeeklyPlan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcWeeklyPlanDao implements WeeklyPlanDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcWeeklyPlanDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}


    @Override
    public List<WeeklyPlan> getWeeklyMealPlanByUserId(int userId) {
        return null;
    }

    @Override
    public WeeklyPlan createWeeklyMealPlan(WeeklyPlan weeklyPlan, int userId) {
        return null;
    }

    @Override
    public void deleteWeeklyMealPlan(int userId, int weeklyplanId) {

    }

    @Override
    public WeeklyPlan modifyWeeklyMealPlan(int weeklyplanId, WeeklyPlan modifyweeklyPlan) {
        return null;
    }
}
