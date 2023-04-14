<template>
  <div class="home">
    <h1>Welcome Back!</h1>
    <h2>Featured Recipes</h2>
    <div class="container1">
      <section class="recipes" v-for="recipe in recipeSamples" v-bind:key="recipe.recipeId">
            <h3>{{recipe.recipe_name}}</h3>
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
.home{
  width:100vh;
  padding-bottom: 2.5rem;
  display: inline-block;

}
.container1{
     background-color: #ebf2ef;
     /* display: flex; */
     /* flex-wrap: wrap; */
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
