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
          <h3>Directions</h3>
          <p align="justify" class="directions">{{recipe.directions}}</p>
        </div>

        <div id="ingredients-section">
          <h3>Ingredients</h3>
          


          <div v-for="(ingredient, index) in ingredients" v-bind:key="index" class="ingredient-list">
            <input type="checkbox" v-bind:value="index" id="list-item" v-model="idsToAdd" v-on:click="addIdToSomething(index)">
            
             <h4 id="ingredient-name">{{ ingredient.ingredient_name }}: </h4>
             <p id="ingredient-amount">{{ ingredient.amount }} </p>   
            
            
            
          </div>
          <button class="addGroceries" type="submit" v-on:click.prevent="sendToGroceryDB()">Add To Grocery List</button>
        </div>

        <div class="tag">
          <h5 class="tag">Tags:</h5>
          <p class="tag">{{recipe.tags}}</p>
        </div>
      <br/>
      <div class="time">
              <h5 class="time">Prep Time:</h5>
            <p class="time">{{recipe.prep_time}} min</p>
      </div>
        <br>
        <button v-on:click=handlePrint() class="print-btn">Print Recipe</button>

    </div>
      </div>
    
      
    </div>
    <div class="left-container">
              <!-- <img src="../assets/1M.png" alt="Pot Roast" /> -->
              <!-- <img :src="randomItem(images, recipe.recipe_name)" class="foodPic" /> -->
             <img :src="getRecipeId(recipe.recipeId)"  alt="first imag" class="foodPic"/>
            
       
        <!-- <img class="left" src="../assets\Old-Fashioned-Pot-Roast.png" alt="Pot Roast" /> -->
            
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
        idsToAdd: [],
        itemsToAdd: []
    };
},
methods: {
  getRecipeId(recipeId){
            let matchingImage = this.$store.state.images.find(recipesimg => recipesimg.id === recipeId);           
             if (matchingImage != undefined) {return matchingImage.path;}
             else {return this.randomItem(this.images);}

      },
    
  addIdToSomething(ingredientId){
    this.idsToAdd.push(ingredientId);
  },
  sendToGroceryDB(){
    console.log('sendToGroceryDb is being run')
    this.idsToAdd.forEach(id => {
      this.itemsToAdd.push({ingredient_name: this.ingredients[id].ingredient_name, quantity: this.ingredients[id].amount})
    })

    GroceryListService.addGroceriesToDB(this.$store.state.user.id, this.itemsToAdd);
    this.itemsToAdd = [];
    this.idsToAdd=[];
  },
  toggleShowForm() {
    this.showForm = !this.showForm;
  },
  handlePrint(){
    window.print();
  }
},
created() {
    recipeService.getRecipeById(this.$route.params.recipeId).then(response => {
      this.recipe = response.data;
      
    });
    IngredientService.getIngredientsForRecipe(this.$route.params.recipeId).then((response) => {
      this.ingredients = response.data;
    });
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
@media print{
  .recipe-detail{
    display: none;
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
  background-color: #ebf2ef;
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
button:hover{
  transform: scale(1.05);
}

button:focus{
  outline: 0 solid transparent;
}
button{
   background-color: #cdeccd;
  border: 2px solid #422800;
  border-radius: 10px;
  box-shadow: #422800 4px 4px 0 0;
  color: #422800;
  cursor: pointer;
  display: inline-block;
  font-weight: 600;
  font-size: 15px;
  padding: 0 3px;
  line-height: 30px;
  text-align: center;
  text-decoration: none;
  font-family: 'Dosis', monospace, sans-serif;

}
.addGroceries{
  margin-bottom: 20px;
}
.left-container{
  display: flex;
   
}
img{
  max-width: 85%;
  justify-content: center;
  align-self: center;
  border-radius: 5%;
  margin-left: 20px;
 
}

/* .print-btn {
  display: block;
  position: absolute;
  right:10%;
  
} */

h5{
  font-size: 0.9em;
}

</style>