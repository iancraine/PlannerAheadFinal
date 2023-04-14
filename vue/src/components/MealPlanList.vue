<template>
  <div>
    <h1>My MealPlans</h1>

    <div v-for="mealplan in mealPlans" v-bind:key="mealplan">
      <div>
       <ul>
        <li v-for="(day, index) in mealplan" v-bind:key="index">
          <h2 v-if="index === 0">{{day.plan_name}}</h2>
          <div v-else>
            <div >
            <tr>
              <th>Meal Type</th>
              <th>Recipe Id</th>
              <th>Date</th>
              </tr>
            <tr v-for="day in mealplan" v-bind:key="day">
              <td>{{day.meal_type}}</td>
              <td>{{day.recipe_id}}</td>
              <td>{{day.for_date}}</td>
            </tr>
            </div>
            </div>
        </li>
       </ul>
     </div>

     



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