<template>
  <div >
    <div class="page-title">
      <h2 class="title">My Recipes</h2>
      <button class="addNewRecipe" v-on:click="toggleShowForm()">Add New Recipe</button>
    </div>
    <new-recipe-form  id="form" v-if="showForm"/>
      <div class="recipe-container">
      <div class="recipe">
        <div v-for="recipe in recipes" v-bind:key="recipe.recipeId"> 
            <h1><router-link class="h1" v-bind:to="{ name:'recipesId', params:{recipeId:recipe.recipeId}}">{{recipe.recipe_name}}</router-link></h1>
           <div class="image">
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
<style scoped>

.recipe-title{
  display: grid;
  grid-template-areas: "recipe recipe"
}
.title{
  color:#0d75134b;
  text-shadow: 2px 2px 4px #e2ebdc;
  font-size: 42px;
  align-content: center;
  padding: 20px;
  grid-area: "title";
  text-align: center;
}

div.page-title h1{
  text-align: center;
}

.recipe{
  display: flex;
  flex-wrap: wrap;
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
  background: #cdeccd;
  border-radius: 900px;
  box-shadow: #bdbdfa 0 10px 20px -10px;
  color: #180d04;
  cursor: pointer;
  font-family: Inter, Helvetica;
  font-weight: 700;
  line-height: 24px;
  outline: 0 solid transparent;
  padding: 8px 18px;
  border: 0;
  margin: 0 auto;
  display: flex;
}

#form {
  display: flex;
  justify-content: center;
}
</style>

