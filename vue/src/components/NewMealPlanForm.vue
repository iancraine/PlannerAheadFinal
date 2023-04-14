<template>
  <div>
    <div class="weekly-plan-name">
      <label for="meal-plan-name"> <h2>Meal Plan Name:</h2> </label>
      <div class="title-add-section" v-if="!planNameAdded">
        <input
          type="text"
          class="meal-plan-name"
          id="meal-plan-name"
          v-model="mealPlanName"
        />
        <button class="addBtn">Add</button>
      </div>

      <div class="addedTitleDisplay" v-if="planNameAdded">
        <h3>{{ mealPlan.plan_name }}</h3>
        <button class="modifyBtn">Modify</button>
      </div>
    </div>

    <form>
      <div class="options">
 <div class="dateOptions">
          <label for="date">Select Date: </label>
          <input
            type="date"
            id="date"
            name="date"
            v-model="mealPlan.for_date"
          />
        </div>

        <div class="mealTypeOptions">
          <label for="mealType">Select Meal: </label>
          <select name="mealType" id="mealType" v-model="mealPlan.meal_type">
            <option value=1> Breakfast </option>
            <option value=2> Lunch </option>
            <option value=3> Dinner </option>
            <option value=4> Snack </option>
            <option value=5> Appetizer </option>
          </select>
        </div>

        <div class="recipesOptions">
          <label for="recipe">Select Recipe: </label>
          <select name="recipe" id="recipe" v-model="currentSelectedRecipe">
            <option
              v-for="recipe in this.$store.state.recipes"
              v-bind:key="recipe.recipe_id"
              :value="recipe.recipe_name"
            >
              {{ recipe.recipe_name }}
            </option>
          </select>
        </div>

      </div>
       
     <button class="addToPlanBtn" @click.prevent="addMealCombo">Add To Plan </button>
    </form>

    <table>
      <thead>
        <th>
          <tr>
            <div class="planContainer">
              <td>
                <img
                  src="../assets/calendar-planner.jpg"
                  class="calendarImg"
                  height="100"
                  width="100"
                />
              </td>
              <td>Date</td>
              <td>Meal</td>
              <td>Recipe</td>
            </div>
          </tr>
        </th>
      </thead>
      <tbody>
        <tr v-for="plan in listOfPlans" v-bind:key="plan.plan_name">
          <td></td>
          <td>{{listOfPlans.for_date}}</td>
          <td>{{listOfPlans.meal}}</td>
          <td>{{mealTypeName}}</td>
        </tr>

      </tbody>
    </table>
  </div>
</template>


<script>
import recipeService from "../services/RecipeService.js";
export default {
  name: "add-meal-plan",
  data() {
    return {
      planNameAdded: false,
      mealPlanName: "",
      currentSelectedRecipe: "recipe",
      listOfPlans:[],
      mealPlan: {
        plan_name: "",
        // get the recipe Id based on the recipe name when user adds the combo
        recipe_id: 0,
        for_date: "",
      // will have to convert it to a number. It stores as a string when user selects meal type
        meal_type: 0,
      },
    };
  },

  created() {
    recipeService.getRecipes(this.$store.state.user.id).then((response) => {
      this.$store.commit("SET_RECIPE", response.data.sort());
    });
  },

  computed: {
    mealTypeName() {
      if (this.mealPlan.meal_type === "1") {
        return "Breakfast";
      }
      else if (this.mealPlan.meal_type === "2") {
        return "Lunch";
      }
      else if(this.mealPlan.meal_type === "3") {
        return "Dinner";
      }
      else if(this.mealPlan.meal_type === "4") {
        return "Snack";
      }
      else {
        return "Appetizer"
      }
    },

    recipeId() {
      let recipeObj =  this.$store.state.recipes.find((recipe) => 
         recipe.recipe_name = this.currentSelectedRecipe
      );
      return recipeObj.recipeId;
    }
  },

// List<MealPlan>
// each MealPlan object should have: plan_name, recipe_id, for_date, meal_type int 

  methods: {
    clear() {
       this.mealPlan =  {
        plan_name: "",
        recipe_id: 0,
        for_date: "",
        meal_type: 0
      };

      this.currentSelectedRecipe = "";
    },
    addMealCombo() {
         this.mealPlan.meal_type = parseInt(this.mealPlan.meal_type);
         this.mealPlan.plan_name = this.mealPlanName;
         this.mealPlan.recipe_id = this.recipeId;

         this.listOfPlans.push(this.mealPlan);

        this.clear();
    },
  },
};
</script>

<style scoped>
.addBtn,
.modifyBtn, 
.addToPlanBtn {
  margin: 0 10px;
  background-color: #e1ecf4;
  font-family: system-ui, sans-serif;
  border-radius: 3px;
  border: 1px solid #adc4d4;
  padding: 0.3em;
}

.addBtn:hover,
.modifyBtn:hover, 
.addToPlanBtn {
  font-weight: 2em;
  cursor: pointer;
}

.addToPlanBtn {
  position: absolute;
  left: 50%;
}
.weekly-plan-name {
  text-align: center;
  padding: 30px;
}

.options {
  display: flex;
  justify-content: center;
  background-color:rgb(241, 249, 253);
  margin: 0 auto;
  max-width: 50%;
}

.calendarImg {
  border-radius: 25px;
}

table {
  background-color: #ecf2f0;
  margin: 50px auto;
  border-radius: 25px;
}

tr,
td {
  padding: 1.2em;
}

.planContainer {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
}

.dateOptions, .mealTypeOptions, .recipesOptions {
  display: inline-block;
  margin: 50px;
}


</style>