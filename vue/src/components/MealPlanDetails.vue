<template>
  <div>
      <div>
          <h1 class="page-title">Meal Plan: </h1>
          <button class="editbtn">Edit Meal Plan</button>
      </div>
      <div>
          <table class="planTable">
              <thead>
                <tr class="tableHeader">
                    <th>Day of Week</th>
                    <th>Breakfast</th>
                    <th>Lunch</th>
                    <th>Dinner</th>
                </tr>
              </thead>
              <tbody>
                  <tr v-for="plan in plans" v-bind:key="plan">
                      <td>{{day_of_week}}</td>
                      <td>{{breakfast_recipe.name}}</td>
                      <td>{{lunch_recipe.name}}</td>
                      <td>{{dinner_recipe.name}}</td>
                  </tr>
              </tbody>
          </table>

      </div>

  </div>
</template>

<script>
export default {
    name: "meal-plan-details",
    data(){
        return{
            plans: [
                {
                    plan_name: 'healthy week',
                    
                }
            ]
        }
    }

}
</script>

<style>

</style>