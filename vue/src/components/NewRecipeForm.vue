<template>
    <div>
        <form action="#">
            <label for="recipe-name">Recipe Name: </label>
            <input type="text" class="recipe-name" id="recipe-name" />
            <label for="prep-time" class="prep-time">Prep time: </label>
            <input type="number" class="prep-time" id="prep-time" size="5" />
            mins
            <br>

            <label for="directions">Directions: </label>
            <br>
            <textarea name="directions" id="" cols="30" rows="10"></textarea>
            <br>

            <input class="addTag" type="text" placeholder="Add a tag"/>
            <button class="addTag">Add</button>
            
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

            <label for="food-pic">Upload a picture: </label>
            <input type="file" id="food-pic">
            <input type="checkbox" id="public">
            <label for="public">Public?</label>


            

            <div>
                <ul v-for="ingredient in ingredients" v-bind:key="ingredient">
                    <li>{{ingredient.name}}ingredients list here {{ingredient.amount}}</li>
                </ul>
            </div>

            <!-- display tags somewhere -->

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
    list-style-type: none;
}
.ingredients-content > input{
    margin-right: 25px;
}
form > *{
    margin-bottom: 15px;
}
label.prep-time{
    margin-left: 25px;
}
input.prep-time{
    width: 5em;
}
form{
    background-color: yellowgreen;
}

</style>