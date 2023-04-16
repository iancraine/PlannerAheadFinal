<template>
  <div class="home">
    <h1>Welcome Back!</h1>
    <h2>Suggested Recipe</h2>
    <div class="container1">
      <section class="random-recipe">
            <h3>{{random_recipe.recipe_name}}</h3>
           <div>
              <img src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" height=200, width=350/>
            </div>
      </section>
    </div>
    
  </div>
</template>

<script>
import recipeService from '../services/RecipeService'

export default {
  name: "home",
  data() {
      return {
        recipe: [],
        random_recipe: {}
      }
    },
  
  created() {
    recipeService.getRecipes(this.$store.state.user.id).then(response => {
      this.recipe = response.data;
      this.randomized();
    });
  },

  methods: {
    randomized () {
      const chosenNumber = Math.floor(Math.random() * this.recipe.length);
          this.random_recipe = this.recipe[chosenNumber];
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
