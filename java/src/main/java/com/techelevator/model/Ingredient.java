package com.techelevator.model;

public class Ingredient {
    private int ingredientId;
    private String ingredientName;
    private String ingredientType;

    public Ingredient(){}

    public Ingredient(int ingredientId, String ingredientName, String ingredientType) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
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

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }
}
