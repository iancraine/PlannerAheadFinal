<template>
  <div class="list">
    <div class="list-container">
      <h2 class="list-title">Grocery List</h2>

      <label for="itemName">Item Name: </label>
      <input type="text" id="itemName" v-model="itemName" />
      <label for="amount">Amount:</label>
      <input type="text" id="amount" v-model="amount" />
      <button @click="addSelectedIngredients">Add to Grocery List</button>

      <div class="items-box">
        <div v-if="isListEmpty">
          <div
            v-for="(list, index) in grocerylist"
            :key="index"
            class="list-items"
          >

            <input
              type="checkbox"
              v-model="selectedIngredients"
              :value="list"
            />
            <label v-if="list.ingredient_name != undefined" class="item-name"
              >{{ list.ingredient_name }}: {{ list.quantity }}
            </label>
            <label v-else class="item-name"
              >{{ list.non_food_option }}: {{ list.quantity }}</label
            >
          </div>
        </div>
              <div v-else>
                <p class="emptyMsg"> You currently don't have any groceries in your list. </p>
              </div>

      </div>


      <div class="delete-btns">
        <button @click="deleteSelected">Delete selected ingredients</button>
        <button @click="deleteAll">Delete All</button>
      </div>
    </div>
  </div>
</template>

<script>
import groceryListService from "../services/GroceryListService.js";

export default {
  name: "grocery-list",
  data() {
    return {
      amount: "",
      itemName: "",
      grocerylist: [],
      addedgroceries: [],
      selectedIngredients: [],
      items: [],
      itemIndex:'',
      itemAmount:[]
    };
  },
  computed: {
    isListEmpty() {
      return this.grocerylist.length;
    }
  },
  created() {
    this.pageloadingmethod();
    this.addItemsTogether();
  },
  methods: {
    addSelectedIngredients() {
      this.addedgroceries.push({
        quantity: this.amount,
        non_food_option: this.itemName,
      });

      groceryListService.addGroceriesToDB(
        this.$route.params.userId,
        this.addedgroceries
      );
      this.pageloadingmethod();
      this.addItemsTogether();
      location.reload();
    },
    pageloadingmethod() {
      groceryListService
        .getAllGroceryListItems(this.$route.params.userId)
        .then((response) => {
          this.grocerylist = response.data;
        });
    },
    deleteSelected() {
      this.selectedIngredients.forEach((ingredient)=> {
        console.log(ingredient.list_id);
          groceryListService.deleteSelectedLists(ingredient.list_id);
      });

        location.reload();
    },
    deleteAll() {
      if (
        confirm(
          "Are you sure you want to delete the whole list? You cannot undo the deletion."
        )
      ) {
        groceryListService.clearGroceryList(this.$route.params.userId);
      }
          location.reload();
    },
    addItemsTogether(){
      console.log('addItemsTogether is being called')
      this.grocerylist.forEach((item) => {
        console.log(item)
        console.log('the loop is entered')
        if (this.items.includes(item.ingredient_name)) {
          console.log('the if evaluates to true')
          this.itemIndex = this.items.findIndex(x => x.ingredient_name === item.ingredient_name);
          this.amount = item.quantity.split(" ");
          //add the quantities together
        } else {
          this.items.push({
            name: item.ingredient_name,
            amount: item.quantity,
          });
        }
      });
    }
  },
};
</script>

<style>
.list {
  font-family: "Dosis", monospace, sans-serif;
  background: url(../assets/cropped-orange.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  padding-bottom: 50px;
  opacity: 0.9;
  font-size: 1.1em;
  padding-left: 5%;
  /* filter: brightness(95%); */
}

h2 {
  text-align: center;
}

.list-items {
  margin: 5px;
  text-align: center;
}
.items-box {
  background-color: aliceblue;
  max-width: 45%;
  border-radius: 10px;
  opacity: 0.95;
  padding-top: 10px;
  padding-bottom: 10px;
  margin: 25px;
}

button:hover {
  transform: scale(1.05);
}

button:focus {
  outline: 0 solid transparent;
}
button {
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
  font-family: "Dosis", monospace, sans-serif;
}

.delete-btns {
  max-width: 50%;
  text-align: center;
}

.emptyMsg{
  text-align: center;
  font-size: 1.5em;
}

#itemName,
#amount {
  margin: 10px;
}
</style>