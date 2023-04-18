<template>
    <div>
        <button v-on:click="toggleShowForm()" class="edit-recipe-btn">Edit Recipe</button>
        <form action="#" v-on:submit.prevent="" class="recipe-form" v-show="showForm">
            <label for="recipe-name">Recipe Name: </label>
            <input type="text" class="recipe-name" id="recipe-name" v-model="recipe.recipe_name" />
            <label for="prep-time" class="prep-time">Prep time: </label>
            <input type="number" class="prep-time" id="prep-time" size="5" v-model="recipe.prep_time"/>
            mins
            <br>

            <label for="directions">Directions: </label>
            <br>
            <textarea name="directions" id="" cols="100" rows="10" v-model="recipe.directions"></textarea>
            <br>
            <div>
                <textarea name="editTag" id="editTag" cols="30" rows="2" v-model="recipe.tags"></textarea>
            </div>
            
            <div  class="ingredients-content">
                <ul>
                    <li v-for="(ingredient, index) in ingredients" v-bind:key="index">
                        <input type="text" v-model="ingredients[index].ingredient_name">
                        <input type="text" v-model="ingredients[index].amount">
                    </li>
                </ul>
            </div>
              <div  class="ingredients-content">
                <label for="userInput">Add Ingredients: </label>
                <input type="text" id="userInput" v-model="inputIngredient.ingredient_name">
                <label for="amount">Amount: </label>
                <input type="text" id="amount" v-model="inputIngredient.amount">
                <label for="unit">Unit: </label>
                <select name="units" id="units" v-model="unit">
                    <option value="cups">cups</option>
                    <option value="Tbsp">Tbsp</option>
                    <option value="Tsp">Tsp</option>
                    <option value="grams">g</option>
                    <option value="pounds">lbs</option>
                    <option value="ounces">oz</option>
                    <option value="quarts">quarts</option>
                    <option value="pints">pints</option>
                    <option value="gallons">gallons</option>
                    <option value="units">units</option>
                </select>
                <button class="addIngredient" @click.prevent="concatIngredient()">Add</button>
            </div>

            <label for="food-pic">Upload a picture: </label>
            <input type="file" id="food-pic" >
        
            <br>

            <div class="btn-align">
                <input class="submitBtn" type="submit" v-on:click="editRecipe()" value="Submit">
                <button class="cancelBtn" @click.prevent="clear()"> Clear</button>
            </div>
        </form>
    </div>
</template>
<script scoped>
 import RecipeService from "../services/RecipeService";
 import IngredientService from "../services/IngredientService";

export default {
    props: {
        recipeFrom: Object,
        listIngredients: Array
        },
    data(){
    return{
        showForm: false,
        inputTag: '',
        inputIngredient: {
            ingredient_name: '',
            amount: '',
            ingredient_id: 0
        },
        unit: '',
        recipe:{ 
           recipe_name:'',
           directions:'',
           tags:'',
           prep_time:'',
           food_pic:'',
           is_public: false
        },
        ingredients: [],
        };
    },
 methods: {
    toggleShowForm() {
        this.showForm = !this.showForm;
        this.recipe = this.recipeFrom;
        this.ingredients = this.listIngredients;
    },
    clear() {
        this.inputTag = '';
        this.inputIngredient= {
            ingredient_name: '',
            amount: '',
            ingredient_id: 0
        };
        this.unit = '';
        this.recipe ={ 
           
        };
        this.ingredients= [];
    },
    concatIngredient(){
        this.inputIngredient.amount += " " + this.unit;
        this.ingredients.push(this.inputIngredient);
        this.inputIngredient = {
            ingredient_name: '',
            amount: '',
            ingredient_id: ''
        };
        this.unit='';
    },
    editRecipe(){
        RecipeService.modifyRecipe(this.recipe.recipeId, this.recipe).then((response) => {
                this.recipe = response.data;
                this.editIngredient(); 
        }).catch(error => {
            if(error.response){
                this.errorMsg = "Error submitting new recipe. Response recived was '"+ error.response.statusText+"'";
            }else if(error.request) {
                this.errorMsg = "Error submitting new recipe. Server could not be reached.";
            }else{
                this.errorMsg = "Error submitting new recipe. Request could not be reached.";
            }
        });
       
       
    },
    editIngredient(){
            IngredientService.editIngredient(this.recipe.recipeId, this.ingredients).then((response) => {
                this.ingredients = response.data;
                this.showForm = false;
            })
           

    }



    }
}
</script>

<style scoped>
form {
    background-color: rgb(212, 245, 174);
}
.addIngredient {
    background-color: #AFE1AF;
    color: #180d04;
}

li {
    list-style-type: none;
}
.ingredients-content > input{
    margin-right: 25px;
    margin-bottom: 20px;
}
form.recipeForm > *{
    margin-bottom: 15px;
}
label.prep-time{
    margin-left: 25px;
}

input.prep-time{
    width: 5em;
}
form.recipeForm{
    background-color: #aff8bb;
    font-family: system-ui, sans-serif;
}

.btn-align{
    display: flex;
    justify-content: center;

}
.edit-recipe-btn{
    background: #cdeccd;
  border-radius: 900px;
  box-shadow: #422800 4px 4px 0 0;
  color: #180d04;
  cursor: pointer;
  font-weight: 700;
  line-height: 24px;
  outline: 0 solid transparent;
  padding: 8px 18px;
  margin: 0 auto;
border: 2px solid #422800;
  border-radius: 10px;
  font-family: 'Dosis', monospace, sans-serif;
}
button:hover{
  transform: scale(1.05);
}

button:focus{
  outline: 0 solid transparent;
}
button{
   background-color: #fbeee0;
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

.submitBtn, .cancelBtn{
     background-color: #fbeee0;
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

.submitBtn:hover, .cancelBtn:hover{
    font-weight: 2em;
    cursor: pointer;
}

</style>