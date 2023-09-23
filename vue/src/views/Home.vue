<template>
  <div class="home">
    <h1>Welcome Back!</h1>
    <div class="container2">
      <h2> Current Plans</h2>
      <h2>Suggested Recipe</h2>
    </div>
    <div class="container1">
      <section class="current-mealplan" v-if="currentPlanPresent">
        <div class="is-current" v-for="(meal, index) in mealPlans" v-bind:key="index">
          <div @click="moveToMealPlan" >
            <h2 class="current-name"> {{meal[0].plan_name}}</h2>
            <p class="date-range"> <span >{{meal[0].for_date}} </span> to <span>{{meal[meal.length-1].for_date}}</span></p>
        </div>
        </div>
           <div class="add-more">
         <router-link :to="{name: 'add-meal-plan'}">Add more meal plans!</router-link>
         </div>
      </section>

      <section class="no-current-mealplan" v-else> 
           <p> You don't have any current plan. </p>
          <div class="add-more">
<router-link :to="{name: 'add-meal-plan'}">Add new meal plans!</router-link>
          </div>   
          
      </section>

      <section class="random-recipe" >
            <router-link :to="{name: 'recipesId', params: {recipeId: randomRecipe.recipeId}}"><h3>{{randomRecipe.recipe_name}}</h3></router-link>
           <div class="food-img">
             <img v-if="randomRecipe.food_pic != null" :src="randomRecipe.food_pic"  alt="food image" class="foodPic"/>

            <img v-if="randomRecipe.food_pic == null" src=''  alt="food image" class="foodPic"/>
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
        currentPlanExists: false
      }
    },
  
  created() {
    RecipeService.getRecipes(this.$store.state.user.id).then(response => {
      this.recipe = response.data;
      this.randomized();
    });
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
  },
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
    },
    getRecipeImgPath(recipeId){
            let matchingImage = this.$store.state.images.find(recipesimg => recipesimg.id === recipeId);           
             if (matchingImage != undefined) {return matchingImage.path;}
      }
  }

  
};
</script>

<style scoped>
.home{
  /* width:100vh; */
  padding: 2.5rem;
  padding-bottom: 50px;
  font-family: 'Dosis', monospace, sans-serif;
   /* background-color: #f8e9b8; */
    background: url(../assets/veggies-left.jpg) center no-repeat ;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  padding-bottom: 50px;
}
.container1{
     /* display: grid;
     grid-template-columns: 1fr 1fr;
     grid-template-areas: "recipe recipe";
     justify-items: center; */
     display: flex;
     justify-content: space-around;
      flex-wrap: wrap; 
      border-radius: 10px;
      padding: 2%;
      
 }
section:hover{
   border: 1px solid #4a7545;
    border-radius: 9px;
    box-shadow: 0 0 4px 1px rgba(25, 247, 121, 0.925);
}
 .container2{
   display: flex;
   justify-content: space-around;
 }
 
 h2, h3 {
   color: black;
   text-align: center;
   margin-bottom: 0;
 }

 h1 {
   color:rgb(11, 24, 13);
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
   border-radius: 10px;
   border: dotted 2px ;
 }

.food-img{
   text-align: center;
   padding: 5%;
 }

 img{
   border-radius: 50px;
   max-width: 300px;
   max-height: 250px;
 }
 

.is-current{
    display: flex;
    border: 2px solid #333333;
    max-width: 60%;
    justify-content: center;
    margin: 0 auto;
    margin-top: 15px;
    font-size: 0.9rem;
    border-radius: 10px;
    text-transform: uppercase;
    letter-spacing: 0.3ch;
    background: #ffffff;
    margin-top: 30px;
}

.is-current:hover {
  padding-left: 0.5rem;
  border-left: 0.5rem solid #11a56a;
}

.current-mealplan, .no-current-mealplan{
  text-align: center;
  font-size: 1.5em;
  margin:0px;
}


p.date-range{
  text-align: center;
}
 
 .add-more{
   text-align: center;
   max-width: 100%;
   font-size: 0.8em;
   margin: 30;
   margin-top: 20px;
   margin-bottom: 20px;
   
   
 }

 a{
   text-decoration: none;
 }

 a:hover{
   text-decoration: underline;
 }

 
</style>
