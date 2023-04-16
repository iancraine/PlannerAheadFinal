<template>
  <div class="recipe-detail" >
    
    
    <div class="right">
      <img id="myrecipesbtn" class="back-arrow" src="../assets/backArrow.png" alt="Back Arrow" @click="$router.go(-1)">
      <div class="recipe-container">
        <h2>{{recipe.recipe_name}}</h2>
        <div>
          <edit-recipe-form v-bind:recipe-from="recipe" v-bind:list-ingredients="ingredients"/>
        </div>
        <div>
          <h3>Directions:</h3>
          <p align="justify" class="directions">{{recipe.directions}}</p>
        </div>
        <div>
          <h3>Ingredients</h3>
          <div v-for="ingredient in ingredients" v-bind:key="ingredient.ingredient_id" class="ingredient-list">
            <h4 id="ingredient-name">{{ ingredient.ingredient_name }}:</h4>
            <p id="ingredient-amount">{{ ingredient.amount }}</p>
          </div>
        </div>
        <div class="tag">
          <h5 class="tag">Tags:</h5>
          <p class="tag">{{recipe.tags}}</p>
        </div>
      <br/>
      <div class="time">
              <h5 class="time">Prep Time:</h5>
            <p class="time">{{recipe.prep_time}}</p>
      </div>
    </div>
    
      
    </div>
    <div>
       
        <img class="left" src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" />
            
    </div>
 
  </div>
</template>

<script>
import EditRecipeForm from "./EditRecipeForm.vue";
import recipeService from "../services/RecipeService.js";
import IngredientService from "../services/IngredientService";

export default {
name:'recipe-detail',
components: {
  EditRecipeForm
},
data(){
    return{
        showForm: false,
        recipe:{
           recipe_id:'', 
           recipeName:'',
           directions:'',
           tags:'',
           prep_time:'',
           food_pic:'',
           is_public:''
        },
        ingredients: []
    };
},
methods: {
  toggleShowForm() {
    this.showForm = !this.showForm;
  }
},
created() {
    recipeService.getRecipeById(this.$route.params.recipeId).then(response => {
      this.recipe = response.data;
      
    });
    IngredientService.getIngredientsForRecipe(this.$route.params.recipeId).then((response) => {
      this.ingredients = response.data;
    })
  }
}
</script>

<style scoped>
.back-arrow{
  width: 25px;
}
.recipe-detail{
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "lefty righty";
  padding: 20px;
  font-size: 18px;
  margin-right: 40px;
  margin-left: 40px;
}
.recipe-container{
   background-color: #ebf2ef;
    border-radius: 10px;
    padding: 2%;
     font-family: 'Dosis', monospace, sans-serif;
}
h2, h3{
  color: #79b85d;
}
.left{
  grid-area: righty;
  float:right;
  clear: both;
  padding:10px;
  position: relative;
}
.right{
  grid-area: lefty;
  float: left;
  clear: both;
  padding:10px;
}
/* img.left{  Trying to have the image stay in line with the recipe as you scroll down
  position: fixed;
} */
.tag {
  display: inline-block;
}
p.tag, p.time{
  margin-top: 0;
  margin-left: 6px;
}
.time{
  display: inline-block;
}
.time h5, .tag h5 {
  margin-top: 0;
}
#ingredient-name{
  display: inline-block;
  margin-top:0;
  margin-left: 40px;
}
#ingredient-amount{
  display: inline-block;
  margin-top:0;
  margin-left: 6px;
}


</style>