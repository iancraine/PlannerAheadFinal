<template>
    <div>
        <form action="#">
            <label for="recipe-name">Recipe Name: </label>
            <input type="text" class="recipe-name" id="recipe-name" />
            
            <div  class="ingredients-content">
                <label for="userInput">Add Ingredients: </label>
                <input type="text" id="userInput">
                <label for="amount">Amount: </label>
                <input type="text" id="amount">
                <label for="unit">Unit: </label>
                <select name="units" id="units">
                    <option value="cups">cups</option>
                    <option value="Tbsp">Tbsp</option>
                    <option value="Tsp">Tsp</option>
                    <option value="grams">g</option>
                    <option value="pounds">lbs</option>
                    <option value="ounces">oz</option>
                    <option value="quarts">quarts</option>
                    <option value="pints">pints</option>
                    <option value="gallons">gallons</option>
                </select>
                <button class="addIngredient">Add</button>
            </div>
            <div>
                <ul v-for="ingredient in ingredients" v-bind:key="ingredient">
                    <li>{{ingredient.name}} {{ingredient.amount}}</li>
                </ul>
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
        },
        ingredients: [
            {
                name:'',
                amount: '',
            }
        ]
    };
},

}
</script>

<style>
.addIngredient {
    background-color: #AFE1AF;
    color: white;
    
}
li {
    display: none;
}
.ingredients-content > input{
    margin-right: 25px;
}
form > *{
    margin-bottom: 15px;
}

</style>