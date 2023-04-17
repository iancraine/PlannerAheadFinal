package com.techelevator.model;

import java.time.LocalDate;


public class MealPlan {
    private int meal_plan_recipes_id;
    private int meal_plan_id;
    private String plan_name;
    private int recipe_id;
    private LocalDate for_date;
    private int meal_type;

    public MealPlan(){}

    public MealPlan(int meal_plan_id, String plan_name) {
        this.meal_plan_id = meal_plan_id;
        this.plan_name = plan_name;
    }

    public MealPlan(int meal_plan_id, String plan_name, int recipe_id, LocalDate for_date, int meal_type, int meal_plan_recipes_id) {
        this.meal_plan_id = meal_plan_id;
        this.plan_name = plan_name;
        this.recipe_id = recipe_id;
        this.for_date = for_date;
        this.meal_type = meal_type;
        this.meal_plan_recipes_id = meal_plan_recipes_id;
    }

    public int getMeal_plan_id() {
        return meal_plan_id;
    }

    public void setMeal_plan_id(int meal_plan_id) {
        this.meal_plan_id = meal_plan_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public LocalDate getFor_date() {
        return for_date;
    }

    public void setFor_date(LocalDate for_date) {
        this.for_date = for_date;
    }

    public int getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(int meal_type) {
        this.meal_type = meal_type;
    }

    public int getMeal_plan_recipes_id() {
        return meal_plan_recipes_id;
    }

    public void setMeal_plan_recipes_id(int meal_plan_recipes_id) {
        this.meal_plan_recipes_id = meal_plan_recipes_id;
    }
}
