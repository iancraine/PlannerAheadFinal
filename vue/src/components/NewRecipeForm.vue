<template>
  <div>
    <form action="#" v-on:submit.prevent="" class="recipe-form">
      <div class="name-prep">
        <label for="recipe-name">Recipe Name: </label>
        <input
          type="text"
          class="recipe-name"
          id="recipe-name"
          v-model="recipe.recipe_name"
        />
        <label for="prep-time" class="prep-time">Prep time: </label>
        <input
          type="number"
          class="prep-time"
          id="prep-time"
          size="5"
          v-model="recipe.prep_time"
        />
        mins
      </div>
      <label for="directions">Directions: </label>
      <br />
      <textarea
        name="directions"
        id=""
        cols="100"
        rows="10"
        v-model="recipe.directions"
      ></textarea>
      <br />

      <input
        class="addTag"
        type="text"
        placeholder="Add a tag"
        v-model="inputTag"
      />
      <button class="addTag" @click.prevent="concatTag()">Add</button>
      <p v-bind:show="recipe.tags">{{ recipe.tags }}</p>

      <div class="ingredients-content">
        <label for="userInput">Add Ingredients: </label>
        <input
          type="text"
          id="userInput"
          v-model="inputIngredient.ingredient_name"
        />
        <label for="amount">Amount: </label>
        <input type="text" id="amount" v-model="inputIngredient.amount" />
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
        <button class="addIngredient" @click.prevent="concatIngredient()">
          Add
        </button>
      </div>

      <div>
        <ul v-for="ingredient in ingredients" v-bind:key="ingredient.name">
          <li>{{ ingredient.amount }} of {{ ingredient.ingredient_name }}</li>
        </ul>
      </div>
      <div class="file-upload">
        <label for="food-pic">Upload a picture: </label>
        <input
          type="file"
          accept="image/*"
          id="food-pic"
          @change="onFileChange($event)"
        />
      </div>

      <div class="btn-align">
        <input
          class="submitBtn"
          type="submit"
          v-on:click="addRecipeToDatabase()"
          value="Submit"
        />
        <button class="cancelBtn" @click.prevent="clear()">Clear</button>
      </div>
    </form>
  </div>
</template>
<script>
import RecipeService from "../services/RecipeService";
import IngredientService from "../services/IngredientService";
export default {
  data() {
    return {
      inputTag: "",
      inputIngredient: {
        ingredient_name: "",
        amount: "",
        ingredient_id: 0,
      },
      unit: "",
      recipe: {
        recipe_name: "",
        directions: "",
        tags: "",
        prep_time: "",
        food_pic: "",
        is_public: false,
      },
      ingredients: [],
      recipe_id: "",
    };
  },
  methods: {
    onFileChange(event){
      const file = event.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = (event) => {
          this.recipe.food_pic = event.target.result;
        }
        reader.readAsDataURL(file);
      }
    },
    clear() {
      this.inputTag = "";
      this.inputIngredient = {
        ingredient_name: "",
        amount: "",
        ingredient_id: 0,
      };
      this.unit = "";
      this.recipe = {
        recipe_name: "",
        directions: "",
        tags: "",
        prep_time: "",
        food_pic: "",
        is_public: false,
      };
      this.ingredients = [];
    },
    concatTag() {
      if (this.recipe.tags === "") {
        this.recipe.tags += this.inputTag;
      } else {
        this.recipe.tags += ", " + this.inputTag;
      }
      this.inputTag = "";
    },
    concatIngredient() {
      this.inputIngredient.amount += " " + this.unit;
      this.ingredients.push(this.inputIngredient);
      this.inputIngredient = {
        ingredient_name: "",
        amount: "",
        ingredient_id: "",
      };
      this.unit = "";
    },
    addRecipeToDatabase() {
      RecipeService.addNewRecipe(this.$store.state.user.id, this.recipe)
        .then((response) => {
          this.recipe_id = response.data.recipeId;
          this.addIngredientToDatabase();
        })
        .catch(error => {
               this.handleError(error)
            });

      location.reload();
    },
    addIngredientToDatabase() {
      this.ingredients.forEach((ingredient) => {
        IngredientService.addIngredient(this.$store.state.user.id, ingredient)
          .then((response) => {
            if (response.status === 201 || response.status === 200) {
              ingredient.ingredient_id = response.data.ingredient_id;
              IngredientService.addIngredientForRecipe(
                this.recipe_id,
                ingredient
              )
                .then((response) => {
                  if (response.status === 201 || response.status === 200) {
                    this.showForm = false;
                    this.clear();
                    window.location.reload();
                  }
                })
                .catch((error) => {
                  this.handleError(error);
                });
            }
          })
          .catch((error) => {
            this.handleError(error);
          });
      });
    },
    handleError(error) {
      if (error.response) {
        this.errorMsg =
          "Error submitting new recipe. Response received was '" +
          error.response.statusText +
          "'";
      } else if (error.request) {
        this.errorMsg =
          "Error submitting new recipe. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error submitting new recipe. Request could not be reached.";
      }
    },
  },
};
</script>

<style scoped>
.addIngredient {
  background-color: #afe1af;
  color: #422800;
}

li {
  list-style-type: none;
}
.ingredients-content > input {
  margin-right: 25px;
  margin-bottom: 20px;
}
form.recipeForm > * {
  margin-bottom: 15px;
}
label.prep-time {
  margin-left: 25px;
}

input.prep-time {
  width: 5em;
}
.name-prep {
  margin-bottom: 12px;
}
.file-upload {
  margin-bottom: 16px;
}
form.recipeForm {
  background-color: #ebf2ef;
  font-family: system-ui, sans-serif;
}

.btn-align {
  display: flex;
  justify-content: center;
}
button:hover {
  transform: scale(1.05);
}

button:focus {
  outline: 0 solid transparent;
}
button {
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
  font-family: "Dosis", monospace, sans-serif;
}

.submitBtn,
.cancelBtn {
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
  font-family: "Dosis", monospace, sans-serif;
}

.submitBtn:hover,
.cancelBtn:hover {
  font-weight: 2em;
  cursor: pointer;
}
</style>