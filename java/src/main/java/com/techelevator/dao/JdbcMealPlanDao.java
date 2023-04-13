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
    public List<List<MealPlan>> listAllMealPlans(int userId) {
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

        List<List<MealPlan>> nestedMealPlans = new ArrayList<>();
//        List<Integer> list = List.of(1, 2, 3, 4, 5, 7, 8, 9, 10, 11);
//        int n = 3;
//        List<List<Integer>> result = new LinkedList<>();
//        int size = list.size();
//        for (int i = 0; i <= size; i += n) {
//            result.add(list.subList(i, Math.min(i + n, size)));
//        }
//        System.out.println(result);  // [[1, 2, 3], [4, 5, 7], [8, 9, 10], [11]]
        int jHolder = 0;
        for(int i = 0; i < mealPlans.size(); i+=jHolder){
            int firstIndex = 0;
            int lastIndex = 0;

            for(int j = i; j < mealPlans.size(); j++){
                if(mealPlans.get(i).getMeal_plan_id() == mealPlans.get(j).getMeal_plan_id()){
                    if(j == 0 || mealPlans.get(j).getMeal_plan_id() != mealPlans.get(j-1).getMeal_plan_id()){
                        firstIndex = j;
                    }else if (j == mealPlans.size()-1 || mealPlans.get(j).getMeal_plan_id() != mealPlans.get(j+1).getMeal_plan_id()){
                        lastIndex = j+1;
                    }
                }else {
                    nestedMealPlans.add((mealPlans.subList(firstIndex,lastIndex)));
                    jHolder = j;
                }
            }

        }
        return nestedMealPlans;
    }

    // gets all the recipe combinations for one meal plan as a list of mealplans
    @Override
    public List<MealPlan> getMealPlansById(int mealPlanId) {
        List<MealPlan> mealPlans = new ArrayList<>();

        String sql= "SELECT mp.meal_plan_id, mp.plan_name, for_date, meal_type, recipe_id FROM meal_plan_recipes mpr " +
                "JOIN meal_plan mp ON mp.meal_plan_id = mpr.meal_plan_id " +
                "WHERE mpr.meal_plan_id=? ORDER BY for_date, meal_type;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, mealPlanId);

        while(row.next()) {
            mealPlans.add(mapRowToMealPlan(row));
        }
        return mealPlans;
    }


    @Override
    public List<MealPlan> addMealPlan(List<MealPlan> newMealPlan, int userId) {

        String sql = "INSERT INTO meal_plan (plan_name) VALUES (?) RETURNING meal_plan_id;";
        int mealPlanId = jdbcTemplate.queryForObject(sql,Integer.class, newMealPlan.get(0).getPlan_name());

        sql = "INSERT INTO meal_plan_recipes(meal_plan_id, recipe_id, for_date, meal_type) " +
                "VALUES (?, ?, ?, ?);";
        for(MealPlan plan : newMealPlan){
            jdbcTemplate.update(sql,mealPlanId, plan.getRecipe_id(), plan.getFor_date(), plan.getMeal_type());
        }

        sql = "INSERT INTO users_meal_plan(meal_plan_id, user_id) VALUES (?, ?);";
        jdbcTemplate.update(sql, mealPlanId, userId);

        return getMealPlansById(mealPlanId);
    }

    @Override
    public void deleteMealPlan(int mealPlanId, int userId) {
        //users_meal_plan
        String deleteSql = "DELETE FROM users_meal_plan WHERE user_id=? AND meal_plan_id=?;";
        jdbcTemplate.update(deleteSql, userId, mealPlanId);

        //meal_plan_recipes
        deleteSql = "DELETE FROM meal_plan_recipes WHERE meal_plan_id=?;";
        jdbcTemplate.update(deleteSql, mealPlanId);

        //meal_plan
        deleteSql = "DELETE FROM meal_plan WHERE meal_plan_id=?;";
        jdbcTemplate.update(deleteSql, mealPlanId);
    }

    @Override
    public List<MealPlan> updateMealPlan(List<MealPlan> updatedMealPlan) {

        String sql = "UPDATE meal_plan SET plan_name = ? where meal_plan_id =?;";
        jdbcTemplate.update(sql, updatedMealPlan.get(0).getPlan_name(), updatedMealPlan.get(0).getMeal_plan_id());

        sql = "UPDATE meal_plan_recipes SET recipe_id = ?, for_date = ?, meal_type = ? WHERE meal_plan_id = ?;";
        for(MealPlan plan : updatedMealPlan){
            jdbcTemplate.update(sql, plan.getRecipe_id(), plan.getFor_date(), plan.getMeal_type(), plan.getMeal_plan_id());
        }

        return getMealPlansById(updatedMealPlan.get(0).getMeal_plan_id());
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