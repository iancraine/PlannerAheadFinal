<template>
  <div>
    <div class="weekly-plan-name">
      <label for="meal-plan-name"> <h2>Meal Plan Name: </h2> </label>
      <div class="title-add-section" v-if="!planNameAdded">
           <input
            type="text"
            class="meal-plan-name"
            id="meal-plan-name"
            v-model="weeklyPlan.planName"
            />
        <button class="addBtn">Add</button>
      </div>
     
    </div>

    <form>
      <div class="options">
          <div class="daysOptions">
              <label for="day">Select Day of the Week: </label>
        <select name="day" id="day" v-model="currentSelectedDay">
          <option value="monday">Monday</option>
          <option value="tuesday">Tuesday</option>
          <option value="wednesday">Wednesday</option>
          <option value="thursday">Thursday</option>
          <option value="friday">Friday</option>
          <option value="saturday">Saturday</option>
          <option value="sunday">Sunday</option>
        </select>
          </div>
        
        <div class="recipesOptions">
             <label for="recipe">Select Recipe: </label>
        <select name="recipe" id="recipe" v-model="currentSelectedRecipe">
          <option
            v-for="recipe in this.$store.state.recipes"
            v-bind:key="recipe.recipeId"
            :value="recipe.recipe_name"
          >
            {{ recipe.recipe_name }}
          </option>
        </select>
        </div>
       
      </div>
    </form>

    <table>
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
        </thead>

        <tbody>
            <tr class="breakfast">
              <td> Breakfast</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>

             <tr class="lunch">
              <td> Lunch</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>

             <tr class="dinner">
              <td> Dinner</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
        </tbody>
    </table>

  </div>
</template>

<script>
import recipeService from "../services/RecipeService.js";
export default {
  name: "weekly-plan",
  data() {
    return {
      currentSelectedDay: "",
      currentSelectedRecipe: "",
      planNameAdded: false,
      weeklyPlan: {
        planName: "",
        monday: 0,
        tuesday: 0,
        wednesday: 0,
        thursday: 0,
        friday: 0,
        saturday: 0,
        sunday: 0,
      },
    };
  },

  created() {
    recipeService.getRecipes(this.$store.state.user.id).then((response) => {
      this.$store.commit("SET_RECIPE", response.data.sort());
    });
  },
};
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