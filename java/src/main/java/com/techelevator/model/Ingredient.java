package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredient {
    @JsonProperty("ingredient_id")
    private int ingredientId;
    @JsonProperty("ingredient_name")
    private String ingredientName;
    private String amount;

    public Ingredient(){}

    public Ingredient(int ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public Ingredient(int ingredientId, String ingredientName, String amount) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.amount = amount;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
