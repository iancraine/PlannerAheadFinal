<template>
  <div>
      <h2>{{recipe.recipe_name}}</h2>
      <p>{{recipe.directions}}</p>
      <p>{{recipe.tags}}</p>
      <p>{{recipe.prep_time}}</p>
  <label>
  <input type="checkbox" name="is_public" v_if:checked />
  Is Public
  </label>
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
           recipe_name:'',
           directions:'',
           tags:'',
           prep_time:'',
           food_pic:'',
           is_public:''
        }
    };
},
created() {
    recipeService.getRecipe(this.$route.params.id).then(response => {
      this.recipe = response.data;
      
    });
  }
}
</script>

<style>

</style>