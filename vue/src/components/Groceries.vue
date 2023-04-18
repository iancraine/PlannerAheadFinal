<template>
  <div>
    <h3>Ingredients</h3>
    <div v-for="ingredient in ingredients" :key="ingredient.ingredient_id" class="ingredient-list">
      <p>{{ ingredient.ingredient_id }}</p>
      <p id="ingredient-name">{{ ingredient.ingredient_name }}:</p>
      <p id="ingredient-amount">{{ ingredient.amount }}</p>
    </div>
    <h3>Grocery List</h3>
    <div v-for="list in grocerylist" :key="list">
      <input type="checkbox" v-model="selectedIngredients" :value="list">
      <label v-if="list.ingredient_name != undefined">{{ list.ingredient_name }}</label>
      <label v-else>{{ list.non_food_option }}</label>
    </div>
    <input type="text" id="itemName" v-model="itemName">
    <label for="itemName">Item Name</label>
    <input type="text" id="amount" v-model="amount">
    <label for="amount" >Amount</label>
    <button @click="addSelectedIngredients">Add to Grocery List</button>
  </div>
</template>

<script>
import groceryListService from "../services/GroceryListService.js"

export default {
  name: 'grocery-list',
  data() {
    return {
      amount:'',
      itemName:'',
      // ingredients: [],
      grocerylist: [],
      addedgroceries: []
    }
  },
  created() {
   
   this.pageloadingmethod();
  },
  methods: {
    addSelectedIngredients() {
      this.addedgroceries.push({quantity: this.amount, non_food_option: this.itemName})
     
       
        groceryListService.addGroceriesToDB(this.$route.params.userId,this.addedgroceries);
         this.pageloadingmethod();
          
      
    },
     pageloadingmethod(){
     groceryListService.getAllGroceryListItems(this.$route.params.userId)
      .then(response => {
        this.grocerylist = response.data;
      });
  }
  }
}
</script>

<style>

</style>