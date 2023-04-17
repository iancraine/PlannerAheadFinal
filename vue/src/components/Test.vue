<template>
  <div>
      <div v-for="recipe in recipes" v-bind:key="recipe.recipeId" class="recipe-card"> 

    <h2>{{ recipe.name }}</h2>
    <img :src="requirerecipeImageMap[recipe.recipeId]" alt="my test images"/>
    <!-- <img v-bind:src=recipe.path alt=""/> -->
    {{recipe.recipeId}}{{recipeImageMap[recipe.recipeId]}}
      </div>
  </div>
</template>

<script>
import recipeService from "../services/RecipeService.js";

export default {
    name:"test",
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
    // recipe() {
    
    //   return this.$store.state.images.find(img => img.id ===  parseInt(this.recipeId))
    // }
     recipeImageMap() {
    return this.$store.state.images.reduce((map, image) => {
      map[image.id] = `${image.path}`
      return map
    }, {})
  }
  },
}
</script>
