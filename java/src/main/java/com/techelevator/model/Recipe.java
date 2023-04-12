package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipe {
    private int recipeId;
    @JsonProperty("recipe_name")
    private String recipeName;
    private String directions;
    private String tags;
    @JsonProperty("prep_time")
    private int prepTime;
    private String foodPic;
    private boolean isPublic;
    private int createBy;

    public Recipe(){}

    public Recipe(int recipeId, String recipeName, String directions, String tags,
                  int prepTime, String foodPic, boolean isPublic, int createdBy) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.directions = directions;
        this.tags = tags;
        this.prepTime = prepTime;
        this.foodPic = foodPic;
        this.isPublic = isPublic;
        this.createBy = createdBy;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public String getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(String foodPic) {
        this.foodPic = foodPic;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }
}
