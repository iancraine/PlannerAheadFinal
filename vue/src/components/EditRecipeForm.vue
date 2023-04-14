<template>
    <div>
        <button v-on:click="toggleShowForm()">Edit Recipe</button>
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

            <label for="food-pic">Upload a picture: </label>
            <input type="file" id="food-pic" >
            <input type="checkbox" id="public" v-bind:checked="is_public=true" v-model="recipe.is_public">
            <label for="public">Public?</label>
            <br>

            <div class="btn-align">
                <input class="submitBtn" type="submit" v-on:click="editRecipe()" value="Submit">
                <button class="cancelBtn" @click.prevent="clear()"> Clear</button>
            </div>
        </form>
    </div>
</template>
<script>
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
    color: white;
}

li {
    list-style-type: none;
}
.ingredients-content > input{
    margin-right: 25px;
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

.submitBtn, .cancelBtn{
    margin: 0 10px;
    background-color: #e1ecf4;
    font-family: system-ui, sans-serif;
    border-radius: 3px;
     border: 1px solid #adc4d4;
     padding: .3em;

}

.submitBtn:hover, .cancelBtn:hover{
    font-weight: 2em;
    cursor: pointer;
}

</style>