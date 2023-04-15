<template>
  <div class="mealPlans">
    <h1>My Meal Plans</h1>   
    <div v-for="(mealplan, index) in mealPlans" v-bind:key="index" >
      <div class="planTitle">
        <h2>{{ mealplan[0].plan_name }}</h2>
       <!-- <h3> <router-link v-bind:to="{name: 'mealplandetails', params: {mealPlanId: mealplan[0].meal_plan_id}}" >View Details</router-link> </h3> -->
       
       <p> {{ mealplan[0].for_date }}</p>
       <p> to </p>
       <p>{{mealplan[mealplan.length-1].for_date}}</p>
       <button @click.prevent="showDetailTable(index)"> View Details</button>
      </div>

       <!-- <table v-if="viewDetailSection[index]">   -->
      <div class="tableStyle">
         <table v-if="true">
        <thead>
          <tr>
            <th class="tdata">Date</th>
            <th class="tdata">Meal</th>
            <th class="tdata">Recipe</th>
            
          </tr>
        </thead>
        <tbody>
          <tr v-for="(day, index) in mealplan" v-bind:key="index">
            <td class="tdata">{{day.for_date}}</td>
            <td class="tdata">{{convertMealTypeToWord(day.meal_type)}}</td>
            <td class="tdata">{{getRecipeName(day.recipe_id)}}</td>
            
          </tr>
        </tbody>
      </table>  
      </div>
    </div>
  </div>
</template>
<script>
// import { computed } from 'vue';
import mealPlanService from "../services/MealPlanService.js";
import recipeService from "../services/RecipeService.js";

export default {
    name: 'my-meal-plans',
    data() {
      return {
        mealPlans: [], 
        viewDetails: [],
        test: false
      }
    },
    
    created() {
    mealPlanService.listAllMealPlans(this.$route.params.userId).then(response => {
      this.mealPlans = response.data;
      this.mealPlans.forEach((mealPlan, index) => {
          this.viewDetails[index] = false; 
      })
      
    });
     recipeService.getRecipes(this.$route.params.userId).then((response) => {
      this.$store.commit("SET_RECIPE", response.data.sort());
  });
 
},
computed: {
  viewDetailSection() {
    return this.viewDetails;
  }
},

 methods: {
    showDetailTable(index) {
       this.viewDetails[index] = !this.viewDetails[index];
       console.log(this.viewDetails[index]);
    },
    getRecipeName(currentRecipeId) {
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
<style scoped>
@import url(https://fonts.googleapis.com/css2?family=Dosis);

h1 {
  color:#07857a4b;
  text-shadow: 5px 2px 5px hsl(99, 18%, 85%);
  font-size: 2.8em;
  align-content: center;
  padding: 20px;
  grid-area: "title";
  text-align: center;
}

h2 {
  color:cadetblue;
}

p {
  margin: 0.5em;
}
.mealPlans {
  text-align: center;
  font-family: 'Dosis', monospace, sans-serif;
  background-image:;
}

.tableStyle {
  display: flex;
  justify-content: center;
  padding: 2em;
  border-bottom: 1px dashed black;
  max-width: 50%;
  margin: 0 auto;
}

.planTitle {
  background-color: aliceblue;
  max-width: 45%;
  margin: 0 auto;
  border-radius: 30px;
}

.tdata {
  padding: 10px;
}
</style>