<template>
  <div class="home">

    <h2>Featured Recipes</h2>
    <section class="recipes" v-for="recipe in recipeSamples" v-bind:key="recipe.recipeId">
            <h1>{{recipe.recipeName}}</h1>
           <div>
              <img src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" />
            </div>
      
    </section>
    <section :style="{'background-image': 'url(' + require('../assets/healthy-food.png') + ')'}">
      
    </section>
  </div>
</template>

<script>
import recipeService from '../services/RecipeService'

export default {
  name: "home",
  data() {
      return {
        recipeSamples: []
      }
    },
  
  created() {
    recipeService.getRecipes(this.$store.state.user.id).then(response => {
      this.recipeSamples = response.data.filter((recipe, index) => index < 4);
    });
  }
  
};
</script>

<style scoped>

 h2 {
   color: black;
   text-align: center;

 }

 body{
   background-image: url('../assets/healthy-food.png');
   font: Arial, sans-serif
 }

 .recipes{
   background-color: #ebf2ef;
 }
 
</style>
