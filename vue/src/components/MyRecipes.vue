<template>
  <div>
      <h1>hello</h1>
        <div v-for="recipe in recipes" v-bind:key="recipe.id"> 
            <h1>Hello</h1>
            <p>{{recipe.name}}</p>
            <p>{{recipe.directions}}</p>

        </div>
  </div>
</template>

<script>
import recipeService from "../services/RecipeService.js";

export default {
    name: 'recipes',
  data() {
    return {
      recipes: []
    }
  },

  //** might not need this*/
  created() {
    recipeService.getRecipes().then(response => {
      this.recipes = response.data;
    });
  }

}
</script>
<style>

</style>