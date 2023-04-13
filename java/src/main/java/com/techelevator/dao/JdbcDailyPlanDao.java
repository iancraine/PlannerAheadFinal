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

   public  List<DailyPlan> getDailyMealPlansByUserId(int userId){
        List<DailyPlan> dailyPlan= new ArrayList<>();
        String sql = "SELECT * FROM daily_plan dp" +
        "JOIN recipes r1 ON r1.recipe_id = dp.breakfast_recipe_id"+
        "JOIN recipes r2 ON r2.recipe_id = dp.lunch_recipe_id"+
        "JOIN recipes r3 ON r3.recipe_id = dp.dinner_recipe_id"+
        "JOIN user_recipes ur1 ON ur1.recipe_id = r1.recipe_id"+
        "JOIN user_recipes ur2 ON ur2.recipe_id = r2.recipe_id"+
        "JOIN user_recipes ur3 ON ur3.recipe_id = r3.recipe_id"+
        "JOIN users u ON u.user_id = ur1.user_id"+
        "WHERE u.user_id = ?;";



        SqlRowSet result= jdbcTemplate.queryForRowSet(sql,userId);
        while(result.next()){
            dailyPlan.add(mapRowSetToDailyPlan(result));
        }
        return dailyPlan;


       /*
       Kate:
       if we add the user_id to the weekly_plan table and a join table daily_weekly_plan:

            String selectDailyPlansForTheWeekSql = "SELECT * FROM daily_plan " +
                "JOIN daily_weekly_plan dwp ON dp.daily_plan_id = dwp.daily_plan_id" +
                "JOIN weekly_plan wp ON wp.weekly_plan_id = dwp.weekly_plan_id " +
                "WHERE user_id = ?;";

        */
    }

    public DailyPlan getDailyPlanById(int dailyPlanId){
        DailyPlan dailyPlan=null;
        return dailyPlan;

         /*
       Kate:
       if we add the user_id to the weekly_plan table and a join table daily_weekly_plan:

            String selectDailyPlansForTheWeekSql = "SELECT * FROM daily_plan " +
                "WHERE daily_plan_id = ?;";

        */

    }

    public DailyPlan createDailyMealPlan(DailyPlan dailyPlan, int userId){
        return dailyPlan;
    }

    public void deleteDailyMealPlan(int dailyPlanId, int userId){

    }

    public DailyPlan modifyDailyMealPlan(DailyPlan dailyPlan, int userId){
        return dailyPlan;
    }

    public DailyPlan mapRowSetToDailyPlan(SqlRowSet row){
        DailyPlan dailyPlan = new DailyPlan();

        dailyPlan.setDaily_plan_id(row.getInt("daily_plan_id"));
        dailyPlan.setBreakfast_recipe_id(row.getInt("breakfast_recipe_id"));
        dailyPlan.setLunch_recipe_id(row.getInt("lunch_recipe_id"));
        dailyPlan.setDinner_recipe_id(row.getInt("dinner_recipe_id"));

        return dailyPlan;
    }


}
