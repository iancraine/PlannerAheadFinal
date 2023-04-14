<template>
 <div>

         <h1>Meal Plan Details</h1>
      
     <!-- <table>
        <thead>
          <th>
            <tr >
              <div class="container">
                <td> <img src="../assets/calendar-planner.jpg" class="calendarImg" height=100 width=100></td>
                  <td>Monday</td>
                <td> Tuesday </td>
                <td>Wednesday</td>
                <td>Thursday</td>
                <td>Friday</td>
                <td>Saturday</td>
                <td>Sunday </td>
              </div>
            </tr>
          </th>
        </thead> -->

        <div>
      <h2>{{ eachMealPlan[0].plan_name }}</h2>
      <table>  
        <thead>
          <tr>
            <th>Meal Type</th>
            <th>Recipe Id</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="meal in each-meal-plan" v-bind:key="meal">
            <td>{{meal.meal_type}}</td>
            <td>{{meal.recipe_id}}</td>
            <td>{{meal.for_date}}</td>
          </tr>
        </tbody>
      </table>  
    </div>
    <!-- </table> -->
 </div>

</template>

<script>
export default {
    name: "meal-plan-details",
    data(){
        return{
            mealPlanId: this.$route.params.mealPlanId
        }
    }

}
</script>

<style scoped>
.addBtn,
.modifyBtn {
  margin: 0 10px;
  background-color: #e1ecf4;
  font-family: system-ui, sans-serif;
  border-radius: 3px;
  border: 1px solid #adc4d4;
  padding: 0.3em;
}

.addBtn:hover,
.modifyBtn:hover {
  font-weight: 2em;
  cursor: pointer;
}
.weekly-plan-name {
  text-align: center;
  padding: 30px;
}

.options{
    display: flex;
    justify-content: center;
}

.calendarImg{
   border-radius: 25px;
}

table{
    background-color: #ECF2F0;
    margin: 50px auto;
    border-radius: 25px;
}

tr, td {
  padding: 1.2em;
}

.container {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
}
</style>