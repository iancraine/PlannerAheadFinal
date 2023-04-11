<template>
  <div>
      <h1>My Recipes</h1>
        <div v-for="recipe in recipes" v-bind:key="recipe.id"> 
            <h1>Hello</h1>
            <p>{{recipe.name}}</p>
            <p>{{recipe.directions}}</p>
            <div>
              {{recipe.foodPic}}
            </div>

            <div> Set as {{recipe.public ? "public" : "private"}}</div>

        </div>
  </div>
</template>

<script>
import recipeService from "../services/RecipeService.js";

export default {
    name: 'recipes',
  data() {
    return {
      recipes: [],
      recipeIngredients: []
    }
  },

  //** might not need this*/
  created() {
    recipeService.getRecipes(this.$route.params.userId).then(response => {
      this.recipes = response.data;
    });
    //todo: make a request to pull ingredients for recipe (from IngredientService)
  }

}
</script>
<style>

</style>