package com.techelevator.model;

public class
GroceryList {
    private int list_id;
    private String ingredient_name;
    private String non_food_option;
    private String quantity;

    public GroceryList(){}

    public GroceryList(int list_id, String ingredient_name, String non_food_option, String quantity) {
        this.list_id = list_id;
        this.ingredient_name = ingredient_name;
        this.non_food_option = non_food_option;
        this.quantity = quantity;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public String getNon_food_option() {
        return non_food_option;
    }

    public void setNon_food_option(String non_food_option) {
        this.non_food_option = non_food_option;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
