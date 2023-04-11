<template>
  <div>
      <h2>{{recipe.recipeName}}</h2>
      <div>
              <img src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" />
            </div>
      <p>{{recipe.directions}}</p>
      <p>{{recipe.tags}}</p>
      <p>{{recipe.prep_time}}</p>
      <div>
       <label>
  <input type="checkbox" name="myCheckbox" value="1"> Set as {{recipe.public ? "public" : "private"}}
</label>
               </div>
 
  </div>
</template>

<script>
import recipeService from "../services/RecipeService.js";
export default {
name:'recipe-detail',
data(){
    return{
        recipe:{
           recipe_id:'', 
           recipeName:'',
           directions:'',
           tags:'',
           prep_time:'',
           food_pic:'',
           is_public:''
        }
    };
},

created() {
    recipeService.getRecipeById(this.$route.params.recipeId).then(response => {
      this.recipe = response.data;
      
    });
  }
}
</script>

<style>

</style>