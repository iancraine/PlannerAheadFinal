<template>
  <div>
    <h2>{{ recipe.name }}</h2>
    <img :src="recipe.imagePath" alt="first imag"/>
    <!-- display other recipe details here -->
  </div>
</template>

<script>
import recipeService from "../services/RecipeService.js";

export default {
    props: ['recipeId'],
    data() {
    return {
      recipes: []
    }
    },
    created() {
    recipeService.getRecipes(this.$route.params.userId).then(response => {
      this.recipes = response.data;
    });
    },
  computed: {
    recipe() {
    
      return this.$store.state.recipesimg.find(recipe => recipe.id ===  parseInt(this.recipeId))
    }
  },
}
</script>
