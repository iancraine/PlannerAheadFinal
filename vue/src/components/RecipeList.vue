<template>
  <div >
    <div class="page-title">
      <h1 class="title">My Recipes</h1>
      <button class="addNewRecipe" v-on:click="toggleShowForm()">Add New Recipe</button>
    </div>
    <new-recipe-form  v-if="showForm"/>
      
      <div class="recipe">
        <div v-for="recipe in recipes" v-bind:key="recipe.recipeId"> 
            <h1><router-link class="h1" v-bind:to="{ name:'recipesId' ,params:{recipeId:recipe.recipeId}}">{{recipe.recipeName}}</router-link></h1>
           <div>
              <img src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" />
            </div>
            <div class="tag"><h5 class="tag">Tag:</h5>
            <p class="tag">{{recipe.tags}}</p>
            </div>
            <div class="time">
              <h5 class="time">Prep Time:</h5>
            <p class="time">{{recipe.prepTime}}</p>
            </div>
             
            

           

        </div>
        </div>
  </div>
</template>

<script>
import recipeService from "../services/RecipeService.js";
import NewRecipeForm from './NewRecipeForm.vue';

export default {

    name: 'recipes',
  data() {
    return {
      recipes: [],
      showForm: false
    }
  },
  components: {
    NewRecipeForm
  },
  methods: {
    toggleShowForm() {
      this.showForm = !this.showForm;
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
<style scooped>
.page-title{
  display: grid;
  grid-template-areas: "title, button";
}
.title{
  color:#19ec6a;
  text-shadow: 2px 2px 4px #000000;
  font-size: 42px;
  align-content: center;
  padding: 20px;
  grid-area: "title";
}

.recipe{
  display: flex;
  justify-content: center;
}
.h1{
  color: rgb(20, 73, 187);
  text-decoration: none;
}
.tag{
  display: inline-block;
  padding: 10px;
}
.time{
  display: inline-block;
  padding: 10px;
}
.addNewRecipe {
  background-color: #AFE1AF;
  color: black;
  grid-area: "button";
}



</style>