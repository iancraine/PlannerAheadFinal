<template>
  <div class="mealPlans">
    <h1>My Meal Plans</h1>   
    <button class="topBtn" v-on:click="showMealPlan = !showMealPlan">{{ showMealPlan ? 'Hide' : 'Show' }} Details</button>
     <button class="topBtn"> <router-link :to="{name: 'add-meal-plan'}"> Add Meal Plan </router-link></button>

    <div v-for="(mealplan) in mealPlans" v-bind:key="mealplan[0].meal_plan_id" >
      <div class="planTitle">
        <h2>{{ mealplan[0].plan_name }}</h2>
       <!-- <h3> <router-link v-bind:to="{name: 'mealplandetails', params: {mealPlanId: mealplan[0].meal_plan_id}}" >View Details</router-link> </h3> -->
       <p style="font-weight: bold;"> {{ mealplan[0].for_date }}</p>
       <p> to </p>
       <p style="font-weight: bold;">{{mealplan[mealplan.length-1].for_date}}</p>
       <br>
       <div class="buttons">
          <!-- <button @click.prevent="showDetailTable(mealplan[0].meal_plan_id)"> View Details</button> -->
          
       <button> Modify Plan</button>
       <button > Delete Plan </button>
       </div>
      
      </div>
       <div>
  </div>
  <meal-plan-details v-if="showMealPlan" v-bind:meal-plan="mealplan"></meal-plan-details>
      <!-- <meal-plan-details v-if="viewDetailSection[mealplan[0].meal_plan_id]" v-bind:meal-plan="mealplan"></meal-plan-details> -->
       
       
       <!-- <table v-if="viewDetailSection[index]">   -->
      <!-- <div class="tableStyle">
         <table v-show="viewDetailSection[mealplan[0].meal_plan_id]">
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
      </div> -->
    </div>
  </div>
</template>
<script>
// import { computed } from 'vue';
import mealPlanService from "../services/MealPlanService.js";
import recipeService from "../services/RecipeService.js";
import MealPlanDetails from "./MealPlanDetails.vue"

export default {
    name: 'my-meal-plans',
    components: {
      MealPlanDetails
    },
    data() {
      return {
        showMealPlan:false,
        mealPlans: [], 
        viewDetails: {
        },
        test: false
       
      }
    },
    
    created() {
    mealPlanService.listAllMealPlans(this.$route.params.userId).then(response => {
      this.mealPlans = response.data;
      this.mealPlans.forEach((mealPlan) => {
          this.viewDetails[mealPlan[0].plan_name] = false; 
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
    showDetailTable(mealPlanId) {
       this.viewDetails[mealPlanId] = !this.viewDetails[mealPlanId];
       console.log(this.viewDetails[mealPlanId]);
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
  color:black;
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

a {
  text-decoration: none;
  color:rgb(23, 112, 82);
}
p {
  margin: 0.5em;
}
.mealPlans {
  text-align: center;
  font-family: 'Dosis', monospace, sans-serif;
  background: url(../assets/veggies.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  padding-bottom: 50px;
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
  padding-bottom: 20px;
}

.tdata {
  padding: 10px;
}

.buttons {
  display: flex;
  justify-content: space-evenly;
}

button{
   background-color: #fbeee0;
  border: 2px solid #422800;
  border-radius: 30px;
  box-shadow: #422800 4px 4px 0 0;
  color: #422800;
  cursor: pointer;
  display: inline-block;
  font-weight: 600;
  font-size: 15px;
  padding: 0 3px;
  line-height: 30px;
  text-align: center;
  text-decoration: none;
  font-family: 'Dosis', monospace, sans-serif;

}

.topBtn {
  margin-right: 15px;
   background: #fff;
  backface-visibility: hidden;
  border-radius: .375rem;
  border-width: .125rem;
  color: #212121;
  cursor: pointer;
  font-family: 'Dosis', monospace, sans-serif;
  font-size: 1rem;
  font-weight: 700;
  line-height: 1.2;
  padding: 0.5rem;
  position: relative;
  text-align: left;
  margin-bottom: 15px;
}

button:hover{
  transform: scale(1.05);
}

button:focus{
  outline: 0 solid transparent;
}

</style>

