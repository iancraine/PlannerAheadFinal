<template>
  <div class="recipe-detail" id="max-container">
    
    
    <div class="right">
      <img id="myrecipesbtn" class="back-arrow" src="../assets/backArrow.png" alt="Back Arrow" @click="$router.go(-1)">
      <div class="recipe-container">
        <h2 id="recipe-name">{{recipe.recipe_name}}</h2>
        <div class="details">
          <div id="edit-button">
          <edit-recipe-form v-bind:recipe-from="recipe" v-bind:list-ingredients="ingredients"/>
          </div>

        <div id="direction-section">
          <h3>Directions:</h3>
          <p align="justify" class="directions">{{recipe.directions}}</p>
        </div>

        <div id="ingredients-section">
          <h3>Ingredients</h3>
          <ul>
            <li v-for="ingredient in ingredients" v-bind:key="ingredient.ingredient_id" >
                <input type="checkbox" v-model="ingredient.checked"/>
                <span class="category"> {{ ingredient.ingredient_name }}: {{ ingredient.amount }}</span>
            </li>
        </ul>


          <!-- <div v-for="ingredient in ingredients" v-bind:key="ingredient.ingredient_id" class="ingredient-list">
            <input type="checkbox" name="" id="list-item" v-model="itemsToAdd">
            <label for="list-item">
             {{ ingredient.ingredient_name }}: {{ ingredient.amount }}    Used to be h4 and p element respectively
            </label>
            
            
          </div> -->
          <button type="submit" @click="sendToGroceryDB()">Add To Grocery List</button>
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
    
      
    </div>
    <div class="left-container">
       
        <img class="left" src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" />
            
    </div>
 
  </div>
</template>

<script>
import EditRecipeForm from "./EditRecipeForm.vue";
import recipeService from "../services/RecipeService.js";
import IngredientService from "../services/IngredientService";
import GroceryListService from "../services/GroceryListService";

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
        ingredients: [],
        tagsInBoxes: null,
        itemsToAdd: []
    };
},
computed: {

},
methods: {
  addItemToList(name, amount){
    this.itemsToAdd.push({itemName: name, itemAmount: amount});
  },
  sendToGroceryDB(){

    GroceryListService.addGroceriesToDB(this.$store.state.user.id, this.itemsToAdd);
    this.itemsToAdd = [];
  },
  toggleShowForm() {
    this.showForm = !this.showForm;
  },
  puttingTagsInBoxes(){
    console.log('putting tags in boxes is being run');
    if(this.recipe.tags.includes(',')){
      console.log('tags having a coma is evalutaing to true');
      this.tagsInBoxes = this.recipe.tags.split(",");
      console.log('the split statement ran');
    } else {
      console.log('tags having comas evaulated to fasle')
      this.tagsInBoxes = this.recipe.tags;
      console.log('setting tagsinBoxes equal to something ran');
    }
  }
},
created() {
    recipeService.getRecipeById(this.$route.params.recipeId).then(response => {
      this.recipe = response.data;
      
    });
    IngredientService.getIngredientsForRecipe(this.$route.params.recipeId).then((response) => {
      this.ingredients = response.data;
    });
    this.puttingTagsInBoxes();
    
  }
}
</script>

<style scoped>

@media(max-width: 450){
  .recipe-detail{
    display: grid;
    grid-template-columns: 1fr;
    grid-template-areas: "name"
                    "pic"
                    "details";
    /* align-items: center;
    justify-items: center; */
  }
  #recipe-name{
    grid-area: name;
  }
  img.left{
    grid-area: pic;
  }
  .details{
    display: grid;
    grid-template-columns: 1fr;
    grid-template-areas: "edit"
                          "directions"
                          "ing"
                          "tag"
                          "time";
    grid-area: details;
  }
  #edit-button{
    grid-area: edit;
  }
  #direction-section{
    grid-area: directions;
  }
  #ingredients-section{
    grid-area: ing;
  }
  .tag{
    grid-area: tag;
  }
  .time{
    grid-area: time;
  }
  



  
}
@media(max-width: 1024px){
  .recipe-detail{
background-color: #ebf2ef;
    border-radius: 10px;
    padding: 2%;
  }
  .left-container{
    display: flex;
    
    
  }
  .left{
    width: 400px;
    align-self: flex-end;
  }
}
@media(max-width: 1200px){
  .left{
    width: 500px;
  }
}

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
li{
  list-style-type: none;
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