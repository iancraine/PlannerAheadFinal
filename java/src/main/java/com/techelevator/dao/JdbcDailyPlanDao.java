package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.model.DailyPlan;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDailyPlanDao implements DailyPlanDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcDailyPlanDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<DailyPlan> getDailyMealPlansByUserId(int userId){
        List<DailyPlan> dailyPlan= new ArrayList<>();
        String sql = "Select * from daily_plan " +
                "JOIN recipes r ON r.recipe_id = breakfast_recipe_id"+
                "JOIN recipes r ON r.recipe_id = lunch_recipe_id "+
                "JOIN recipes r ON r.recipe_id = dinner_recipe_id " +
                "JOIN user_recipes ur ON ur.recipe_id = recipe.recipe_id"+
                "JOIN user_recipes ur ON ur.user_id = user.user_id"+
                "WHERE user_id=?;";
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql,)
        return dailyPlan;
    }

    DailyPlan getDailyPlanById(int dailyPlanId){
        return dailyPlan;
    }

    DailyPlan createDailyMealPlan(DailyPlan dailyPlan, int userId){
        return dailyPlan;
    }

    void deleteDailyMealPlan(int dailyPlanId, int userId){

    }

    DailyPlan modifyDailyMealPlan(DailyPlan dailyPlan, int userId){
        return dailyPlan;
    }

    public DailyPlan mapRowsetToDailyPlan(SqlRowSet row){
        DailyPlan dailyPlan = new DailyPlan();

        dailyPlan.setDaily_plan_id(row.getInt("daily_plan_id"));
        dailyPlan.setBreakfast_recipe_id(row.getInt("breakfast_recpe_id"));
        dailyPlan.setLunch_recipe_id(row.getInt("lunch_recipe_id"));
        dailyPlan.setDinner_recipe_id(row.getInt("dinner_recipe_id"));

        return dailyPlan;
    }


}
