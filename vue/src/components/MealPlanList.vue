<template>
  <div>
    <h1>My MealPlans</h1>
    <div v-for="mealplan in mealPlans" v-bind:key="mealplan">
      <h2>{{ mealplan[0].plan_name }}</h2>
      <table>
        <thead>
          <tr>
            <th>Meal Type</th>
            <th>Recipe Id</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(day, index) in mealplan" v-bind:key="index">
            <td>{{day.meal_type}}</td>
            <td>{{day.recipe_id}}</td>
            <td>{{day.for_date}}</td>
          </tr>
        </tbody>
      </table>
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