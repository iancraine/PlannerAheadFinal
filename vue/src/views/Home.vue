<template>
  <div class="home">
    <h1>Welcome Back!</h1>
    <div class="container2">
    <h2> Current Plan</h2>
    <h2>Suggested Recipe</h2>
    </div>
    <div class="container1">
      <section class="current-mealplan" v-if="currentPlanExists">
        <div class="is-current">
          <div  v-for="(meal, index) in mealPlans" v-bind:key="index" @click="moveToMealPlan">
            <h2 class="current-name"> {{meal[0].plan_name}}</h2>
            <p class="date-range"> {{meal[0].for_date}} to {{meal[meal.length-1].for_date}}</p>
        </div>
        </div>
      </section>

      <section class="no-current-mealplan" v-else> 
          <p> You don't have any current plan. </p>
          <router-link :to="{name: 'add-meal-plan'}">Add new meal plans!</router-link>
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
        currentMealPlan: [],
        isHappeningNow: true,
        // thePlan: null,
        // dates: [],
        currentPlanExists: false
      }
    },
  
  created() {
    RecipeService.getRecipes(this.$store.state.user.id).then(response => {
      this.recipe = response.data;
      this.randomized();
    });
    // MealPlanService.listAllMealPlans(this.$store.state.user.id).then((response) => {
    //   this.mealPlans = response.data;
    //   this.mealPlans.forEach((plan) => {
    //     this.dateRanges.push({
    //       fromDate: plan[0].for_date, 
    //       toDate: plan[plan.length-1].for_date, 
    //       planName: plan[0].plan_name,
    //       planId: plan[0].meal_plan_id
    //     });
    //   });
    // });

    MealPlanService.listAllMealPlans(this.$store.state.user.id).then((response) => {
        response.data.forEach((plan) => {
          let toDate = new Date(plan[plan.length-1].for_date);
          let fromDate = new Date(plan[0].for_date);
          let currentDate = new Date();
           if (toDate.getTime() >=  currentDate.getTime() && fromDate.getTime() <= currentDate.getTime()) {
             this.mealPlans.push(plan);
           }
        });

        this.currentPlanExists = this.currentPlanPresent();
    });

    this.dateRanges.push()

    // this.closestMealPlanToNow();
  },

  // computed: {
  //   mealPlanNameAndDatesArray() {
  //     let mealPlans = this.getCurrentMealPlan();
  //     mealPlans.forEach(())
  //   }
  // }
  methods: {
    randomized () {
      const chosenNumber = Math.floor(Math.random() * this.recipe.length);
          this.randomRecipe = this.recipe[chosenNumber];
    },
    currentPlanPresent() {
        return this.mealPlans.length;
    },
    moveToMealPlan() {
      this.$router.push({name: 'mealplans', params:{userId: this.$store.state.user.id}});
    }
    // closestMealPlanToNow(){
    //   console.log(this.dateRanges);
    //   this.dateRanges.forEach(x => {
    //     this.dates.push({to: new Date(x.toDate), from: new Date(x.fromDate), id: x.planId});
    //   })
    //   this.dateRanges.filter((item) => {
    //     return item.toDate >= Date.now().toString() && item.fromDate <= Date.now().toString()
    //   })
    //   this.currentMealPlan = this.dates.filter(x =>{
    //     return x.to >= Date.now() && x.from <= Date.now(); 
    //   })

    //   this.currentMealPlan = this.dateRanges.filter((item) => {
    //       let toDate = new Date(item.toDate);
    //       let fromDate = new Date(item.fromDate);
    //       let currentDate = new Date();
    //       console.log(toDate);
    //       console.log(fromDate);
    //        return toDate.getTime() >=  currentDate.getTime() && fromDate.getTime() <= currentDate.getTime();
    //   })
 
    // },
    // getCurrentMealPlan(){
    //   MealPlanService.getMealPlanById(this.currentMealPlan.planId).then((response) => {
    //     this.thePlan = response.data;
    //   })
    // }
    
  }

  
};
</script>

<style scoped>
.home{
  /* width:100vh; */
  padding: 2.5rem;
  padding-bottom: 50px;
  font-family: 'Dosis', monospace, sans-serif;
}
.container1{
     /* display: grid;
     grid-template-columns: 1fr 1fr;
     grid-template-areas: "recipe recipe";
     justify-items: center; */
     display: flex;
     justify-content: space-between;
      flex-wrap: wrap; 
      margin: 0 auto;
      border-radius: 10px;
      padding: 2%;
      
 }

 .container2{
   display: flex;
   justify-content: space-around;
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

 section{
   background-color: #ebf2ef;
   min-width: 45%;
 }

img{
  border-radius: 10%;
}

.is-current{
    display: flex;
    border: 2px solid #333333;
    max-width: 80%;
    justify-content: center;
    margin: 0 auto;
    margin-top: 15px;
    font-size: 0.9rem;
    border-radius: 2% 6% 5% 4% / 1% 1% 2% 4%;
    text-transform: uppercase;
    letter-spacing: 0.3ch;
    background: #ffffff;
}

.is-current:hover {
  padding-left: 0.5rem;
  border-left: 0.5rem solid #11a56a;
}



p.date-range{
  text-align: center;
}
 
 
</style>
