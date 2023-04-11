<template>
  <div >
      <h1 class="title">My Recipes</h1>
      <div class="recipe">
        <div v-for="recipe in recipes" v-bind:key="recipe.id"> 
            <h1>{{recipe.recipeName}}:</h1>
            <h2>Directions:</h2>
            <p class="direction">{{recipe.directions}}</p>
            <div class="tag"><h5 class="tag">Tag:</h5>
            <p class="tag">{{recipe.tags}}</p>
            </div>
            <div class="time">
              <h5 class="time">Prep Time:</h5>
            <p class="time">{{recipe.prepTime}}</p>
            </div>
             <div>
               <label>
  <input type="checkbox" name="myCheckbox" value="1"> Set as {{recipe.public ? "public" : "private"}}
</label>
               </div>
            <div>
              <img src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" />
            </div>

           

        </div>
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
.title{
  color:#19ec6a;
  text-shadow: 2px 2px 4px #000000;
  font-size: 42px;
  align-content: center;
  padding: 20px;

}
.recipe{
  display: flex;
  justify-content: center;
}
h1{
  color: rgb(218, 45, 145);
}
.tag{
  display: inline-block;
  padding: 10px;
}
.time{
  display: inline-block;
  padding: 10px;
}


</style>