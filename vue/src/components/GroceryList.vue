<template>
  <div>
      <div>
          <h3>Ingredients</h3>
          <div v-for="ingredient in ingredients" v-bind:key="ingredient.ingredient_id" class="ingredient-list">
            <h4 id="ingredient-name">{{ ingredient.ingredient_name }}:</h4>
            <p id="ingredient-amount">{{ ingredient.amount }}</p>
          </div>
      </div>
  </div>
</template>

<script>
import IngredientService from "../services/IngredientService";
import recipeService from "../services/RecipeService.js";

export default {
    name:'grocery-list',
    data(){
        return{
            ingredients:[],

            recipe:{
           recipe_id:'', 
           recipeName:''
           
        },
        }
    },
    created() {
    
    IngredientService.getIngredientsForRecipe(this.$route.params.recipeId).then((response) => {
      this.ingredients = response.data;
    });
    recipeService.getRecipeById(this.$route.params.recipeId).then(response => {
      this.recipe = response.data;
      
    });
    
    
  }

}
</script>

<style>

</style>