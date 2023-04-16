<template>
  <div class="home">
    <h1>Welcome Back!</h1>
    <h2>Suggested Recipe</h2>
    <div class="container1">
      <section class="current-mealplan" v-if="isHappeningNow">
        <!-- <h3>{{thePlan[0].plan_name}}</h3> -->
        <!-- <p>{{thePlan[0].for_date}} - {{thePlan[thePlan.lenght-1].for_date}}</p> -->
      </section>
      <section class="random-recipe" >
            <h3>{{randomRecipe.recipe_name}}</h3>
           <div>
              <img src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" height=200, width=350/>
            </div>
      </section>
    </div>
    
  </div>
</template>

<script>
import RecipeService from '../services/RecipeService';
import MealPlanService from '../services/MealPlanService';

export default {
  name: "home",
  data() {
      return {
        recipe: [],
        randomRecipe: {},
        mealPlans: [],
        dateRanges: [],
        currentMealPlan: null,
        isHappeningNow: true,
        thePlan: null,
        dates: []
      }
    },
  
  created() {
    RecipeService.getRecipes(this.$store.state.user.id).then(response => {
      this.recipe = response.data;
      this.randomized();
    });
    MealPlanService.listAllMealPlans(this.$store.state.user.id).then((response) => {
      this.mealPlans = response.data;
      this.mealPlans.forEach((plan) => {
        this.dateRanges.push({fromDate: plan[0].for_date, toDate: plan[plan.length-1].for_date, planId: plan[0].meal_plan_id});
      });
    });
    this.closestMealPlanToNow();
  },

  methods: {
    randomized () {
      const chosenNumber = Math.floor(Math.random() * this.recipe.length);
          this.randomRecipe = this.recipe[chosenNumber];
    },
    closestMealPlanToNow(){
  
      this.dateRanges.forEach(x => {
        this.dates.push({to: new Date(x.toDate), from: new Date(x.fromDate), id: x.planId});
      })
      this.currentMealPlan = this.dates.filter(x =>{
        return x.to >= Date.now() && x.from <= Date.now(); 
      })
      
    },
    getCurrentMealPlan(){
      MealPlanService.getMealPlanById(this.currentMealPlan.planId).then((response) => {
        this.thePlan = response.data;
      })
    }
    
  }

  
};
</script>

<style scoped>
.home{
  /* width:100vh; */
  padding: 2.5rem;
  padding-bottom: 50px;

}
.container1{
     background-color: #ebf2ef;
     /* display: grid;
     grid-template-columns: 1fr 1fr;
     grid-template-areas: "recipe recipe";
     justify-items: center; */
     display: flex;
      flex-wrap: wrap; 
      margin: 0 auto;
      border-radius: 10px;
      padding: 2%;
      
 }
 
 h2, h3 {
   color: black;
   text-align: center;
 }

 h1 {
   color:rgb(75, 126, 221);
   text-align: center;
 }

 body{
   font: Arial, sans-serif
 }

 .recipes{
    margin: 0 auto;

 }

img{
  border-radius: 10%;
}
 
</style>
