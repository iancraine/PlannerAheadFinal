<template>
  <div>
      <div>
          <h3>Ingredients</h3>
          <div v-for="ingredient in ingredients" v-bind:key="ingredient.ingredient_id" class="ingredient-list">
            <p>{{ingredient.ingredient_id}}</p>
            <p id="ingredient-name">{{ ingredient.ingredient_name }}:</p>
            <p id="ingredient-amount">{{ ingredient.amount }}</p>

          </div>
          <div v-for="list in grocerylist" :key="list">
              {{list.list_id}}
          </div>
      </div>
  </div>
</template>

<script>
import IngredientService from "../services/IngredientService";
import recipeService from "../services/RecipeService.js";
import groceryListService from "../services/GroceryListService.js"
export default {
    name:'grocery-list',
    data(){
        return{
            ingredients:[],
            grocerylist:[],

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
     groceryListService.getAllGroceryListItem(this.$route.params.userId)
     .then(response=>{
         this.grocerylist=response.data;
     });
    
  }

}
</script>

<style>

</style>