package com.techelevator.model;

public class MealPlan {
    private int meal_plan_id;
    private String plan_name;

    public MealPlan(){}

    public MealPlan(int meal_plan_id, String plan_name) {
        this.meal_plan_id = meal_plan_id;
        this.plan_name = plan_name;
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
}
