<template>
  <div>

  </div>
</template>

<script>
import mealPlanService from "../services/MealPlanService.js";

export default {
    name: 'mealPlan',
    data() {
      return {
        mealPlan: []
      }
      },

    created() {
    mealPlanService.listAllMealPlans(this.$route.params.mealPlanId).then(response => {
      this.mealPlan = response.data;
      
    });
  }

}
</script>

<style>

</style>