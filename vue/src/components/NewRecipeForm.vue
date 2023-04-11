<template>
    <div>
        <form action="#">
            <label for="recipe-name">Recipe Name: </label>
            <input type="text" class="recipe-name" id="recipe-name" />


        <div class="ingredientsDropdown">
            
            <div id="myDropdown" class="ingredients-content">
                <label for="userInput">Add Ingredients: </label>
                <input type="text" placeholder="Search.." onkeyup="filterFunction()" id="userInput">
                <div v-for="ingredient in ingredients" v-bind:key="ingredient.id">
                    <h5>{{ingredient.name}}</h5>
                    
                </div>

                <button class="addIngredient">Add</button>
            </div>
        </div>
           
        </form>
    </div>
</template>
<script>


export default {
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

}
</script>

<style>
.addIngredient {
    background-color: #AFE1AF;
    color: white;
    padding: 
}

</style>