<template>
  <div>
    <h2>My MealPlans</h2>
    <div v-for="mealplan in mealPlans" v-bind:key="mealplan.meal_plan_Id">
          <h1>{{mealplan.plan_name}} {{mealplan.meal_type}}</h1>

    </div>
    
  </div>
</template>

<script>
import mealPlanService from "../services/MealPlanService.js";

export default {
    name: 'my-meal-plans',
    data() {
      return {
        mealPlans: []
      }
      },

    created() {
    mealPlanService.listAllMealPlans(this.$route.params.userId).then(response => {
      this.mealPlans = response.data;
      
    });
  }

}
</script>

<style>

</style>