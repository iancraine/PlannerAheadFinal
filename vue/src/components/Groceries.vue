<template>
  <div class="list">
    <div class="list-container">
      <h2 class="list-title">Grocery List</h2>
      <div v-for="list in grocerylist" :key="list" class="list-items">
        <input type="checkbox" v-model="selectedIngredients" :value="list">
        <label v-if="list.ingredient_name != undefined" class="item-name">{{ list.ingredient_name }}: {{list.quantity}} </label>
        <label v-else class="item-name">{{ list.non_food_option }}: {{list.quantity}}</label>
          
      </div>
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
      grocerylist: [],
      addedgroceries: [],
      items:[]
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

      this.grocerylist.forEach(item => {
        if(this.items.includes(item.ingredient_name)){
          // let itemIndex = this.items.findIndex(x => x.ingredient_name === item.ingredient_name);
          // let amount = item.quantity.split(" ");
          //add the quantities together
        }else{
          this.items.push({name: item.ingredient_name, amount: item.quantity});
        }
      })
  }
  }
}
</script>

<style>
.list{
  font-family: 'Dosis', monospace, sans-serif;
  background: url(../assets/vecteezy_vegetables-in-grocery-bag-on-yellow-background__825.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  padding-bottom: 50px;
  
}

button:hover{
  transform: scale(1.05);
}

button:focus{
  outline: 0 solid transparent;
}
button{
  margin-left: 15px;
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

</style>