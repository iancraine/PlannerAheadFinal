<template>
    <div>
        <form action="#">
            <label for="recipe-name">Recipe Name: </label>
            <input type="text" class="recipe-name" id="recipe-name" />

            <label for="ingredients-search">Search Ingredients</label>
            <input type="text" class="ingredients-search" id="ingredients-search" />
            <button>Add</button>
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

</style>