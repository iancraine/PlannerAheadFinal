<template>
  <div>
    <h1>My MealPlans</h1>   
    <div v-for="(mealplan, index) in mealPlans" v-bind:key="index" >
      <h2>{{ mealplan[0].plan_name }}</h2>
       <!-- <h3> <router-link v-bind:to="{name: 'mealplandetails', params: {mealPlanId: mealplan[0].meal_plan_id}}" >View Details</router-link> </h3> -->
       
       <p> {{ mealplan[0].for_date + " to " + mealplan[mealplan.length-1].for_date }}</p>
       <button @click.prevent="showDetailTable(index)"> View Details</button>
       <table v-show="true">  
        <thead>
          <tr>
            <th>Date</th>
            <th>Meal Type</th>
            <th>Recipe Id</th>
            
          </tr>
        </thead>
        <tbody>
          <tr v-for="(day, index) in mealplan" v-bind:key="index">
            <td>{{day.for_date}}</td>
            <td>{{convertMealTypeToWord(day.meal_type)}}</td>
            <td>{{getRecipeName(day.recipe_id)}}</td>
            
          </tr>
        </tbody>
      </table>  
     
    </div>
    
  </div>
</template>

<script>
import mealPlanService from "../services/MealPlanService.js";
import recipeService from "../services/RecipeService.js";

export default {
    name: 'my-meal-plans',
    data() {
      return {
        mealPlans: [], 
        viewDetails: []
      }
      },

    created() {
    mealPlanService.listAllMealPlans(this.$route.params.userId).then(response => {
      this.mealPlans = response.data;
      // this.mealPlans.forEach((mealPlan, index) => {
      //     this.viewDetails[index] = true; 
      // })
      
    });
     recipeService.getRecipes(this.$route.params.userId).then((response) => {
      this.$store.commit("SET_RECIPE", response.data.sort());
  });
 
},

 methods: {
    showDetailTable(index) {
       this.viewDetails[index] = !this.viewDetails[index];
    },
    getRecipeName(currentRecipeId) {
      console.log(currentRecipeId);
        let recipeObj = this.$store.state.recipes.find((recipe) => recipe.recipeId === currentRecipeId);
        return recipeObj.recipe_name;
    },
     convertMealTypeToWord(mealType) {
      if (mealType === 1) {
        return "Breakfast";
      }
      else if (mealType === 2) {
        return "Lunch";
      }
      else if(mealType === 3) {
        return "Dinner";
      }
      else if(mealType === 4) {
        return "Snack";
      }
      else {
        return "Appetizer"
      }
    },
    
  }

}

</script>

<style>

</style>