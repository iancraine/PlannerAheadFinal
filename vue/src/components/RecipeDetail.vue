<template>
  <div class="recipe-detail">
    
    
    <div class="right">
      <h2>{{recipe.recipe_name}}</h2>

      <div>
        <button v-on:click="toggleShowForm()">Edit Recipe</button>
        <edit-recipe-form v-show="showForm"/>
      </div>

      <h3>Directions:</h3>

      

      <p align="justify" class="directions">{{recipe.directions}}</p>
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
    </div>
    <div>
       <div class="left">
              <img src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" />
            </div>
    </div>
 
  </div>
</template>

<script>
import EditRecipeForm from "./EditRecipeForm.vue";
import recipeService from "../services/RecipeService.js";
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
        }
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
  }
}
</script>

<style scoped>
.recipe-detail{
  display: flex;
  padding: 20px;
   font-size: 18px;
}
.directions:hover{
  color:rgb(15, 194, 30);
}
 h2:hover{
  color:darkblue;
}
h2{
  color: rgb(20, 73, 187);
}
.left{
  float:right;
clear: both;
padding:10px;
}
.right{
  float: left;
  clear: both;
  padding:10px;
}

</style>