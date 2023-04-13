package com.techelevator.dao;

import com.techelevator.model.MealPlan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealPlanDao implements MealPlanDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcMealPlanDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MealPlan> listAllMealPlans(int userId) {
        List<MealPlan> mealPlans = new ArrayList<>();

        String sql = "SELECT mp.meal_plan_id, plan_name, mpr.recipe_id, for_date, meal_type " +
                "FROM meal_plan mp " +
                "JOIN meal_plan_recipes mpr ON mpr.meal_plan_id = mp.meal_plan_id " +
                "JOIN users_meal_plan ump ON ump.meal_plan_id = mp.meal_plan_id " +
                "WHERE user_id = ? ORDER BY plan_name;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);

        while(row.next()) {
            mealPlans.add(mapRowToMealPlan(row));
        }

        return mealPlans;
    }

    // gets all the recipe combinations for one meal plan as a list of mealplans
    @Override
    public List<MealPlan> getMealPlansById(int mealPlanId) {
        List<MealPlan> mealPlans = new ArrayList<>();

        String sql= "SELECT plan_name, for_date, meal_type, recipe_id FROM meal_plan_recipes mpr " +
                    "JOIN meal_plan mp ON mp.meal_plan_id = mpr.meal_plan_id " +
                    "WHERE mpr.meal_plan_id=? ORDER BY for_date, meal_type;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, mealPlanId);

        while(row.next()) {
            mealPlans.add(mapRowToMealPlan(row));
        }
        return mealPlans;
    }

    @Override
    public List<MealPlan> addMealPlan(MealPlan newMealPlan, int userId) {
        List<MealPlan> newlyAddedMealPlan = new ArrayList<>();

        String sql = "INSERT INTO meal_plan (plan_name) VALUES (?);";


    }

    @Override
    public void deleteMealPlan(int mealPlanId, int userId) {

    }

    @Override
    public MealPlan updateMealPlan(MealPlan updatedMealPlan) {
        return null;
    }

    public MealPlan mapRowToMealPlan(SqlRowSet row){
        MealPlan mealPlan = new MealPlan();

        mealPlan.setMeal_plan_id(row.getInt("meal_plan_id"));
        mealPlan.setPlan_name(row.getString("plan_name"));
        mealPlan.setRecipe_id(row.getInt("recipe_id"));
        mealPlan.setFor_date(row.getDate("for_date").toLocalDate());
        mealPlan.setMeal_type(row.getInt("meal_type"));

        return mealPlan;
    }
}
