<template>
  <div>
      <div>
          <h1 class="page-title">Meal Plan: </h1>
          <button class="editbtn">Edit Meal Plan</button>
      </div>
      <div v-for="days in weekdays" v-bind:key="days">
          <h3>{{days}}</h3>
          
      </div>

  </div>
</template>

<script>
export default {
    name: "meal-plan-details",
    data(){
        return{
            weekdays: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
        }
    }

}
</script>

<style>

</style>