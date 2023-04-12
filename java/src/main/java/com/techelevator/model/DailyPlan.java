package com.techelevator.model;

public class DailyPlan {
private int daily_plan_id;
private int breakfast_recipe_id;
private int lunch_recipe_id;
private int dinner_recipe_id;
public DailyPlan(){}
    public DailyPlan(int daily_plan_id) {
        this.daily_plan_id = daily_plan_id;
    }

    public DailyPlan(int daily_plan_id, int breakfast_recipe_id, int lunch_recipe_id, int dinner_recipe_id) {
        this.daily_plan_id = daily_plan_id;
        this.breakfast_recipe_id = breakfast_recipe_id;
        this.lunch_recipe_id = lunch_recipe_id;
        this.dinner_recipe_id = dinner_recipe_id;
    }

    public int getDaily_plan_id() {
        return daily_plan_id;
    }

    public int getBreakfast_recipe_id() {
        return breakfast_recipe_id;
    }

    public int getLunch_recipe_id() {
        return lunch_recipe_id;
    }

    public int getDinner_recipe_id() {
        return dinner_recipe_id;
    }

    public void setDaily_plan_id(int daily_plan_id) {
        this.daily_plan_id = daily_plan_id;
    }

    public void setBreakfast_recipe_id(int breakfast_recipe_id) {
        this.breakfast_recipe_id = breakfast_recipe_id;
    }

    public void setLunch_recipe_id(int lunch_recipe_id) {
        this.lunch_recipe_id = lunch_recipe_id;
    }

    public void setDinner_recipe_id(int dinner_recipe_id) {
        this.dinner_recipe_id = dinner_recipe_id;
    }
}
