<template>
  <div class="background">
    <div class="wrapper">
      <div class="weekly-plan-name">
        <div class="title-add-section" v-if="planNameAdded">
          <input
            type="text"
            class="meal-plan-name"
            id="meal-plan-name"
            v-model="mealPlanName"
            @keyup.enter="addName"
          />
          <button class="addBtn" @click.prevent="addName">Add</button>
        </div>

        <div class="addedTitleDisplay" v-if="!planNameAdded">
          <h1 @click="modifyName">{{ mealPlanName }}</h1>
          <img
            src="../assets/pencil-edit-icon.jpg"
            @click="modifyName"
            height="30"
            width="30"
          />
        </div>
      </div>

<div class="addNewMealBtn">
  <button class="addToPlanBtn" @click.prevent="addNewMeal">
         Add New Meal
        </button>
</div>
   

      <table>
        <thead>
          <tr>
            <div class="planContainer">
              <th class="tdata">
                <img
                  src="../assets/calendar-planner.jpg"
                  class="calendarImg"
                  height="80"
                  width="80"
                />
              </th>
              <th class="tdata">Date</th>
              <th class="tdata">Meal</th>
              <th class="tdata">Recipe</th>
            </div>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(plan, index) in displayModifiedCombos" v-bind:key="index">
            <div class="planContainer">
              <td class="tdata placehold" style="color: #ecf2f0">
                <img
                  src="../assets/pencil-edit-icon.jpg"
                  height="30"
                  width="30"
                  @click="editAndDisplay(index)"
                />
              </td>
              <td class="tdata">{{ plan.for_date }}</td>
              <td class="tdata">{{ convertMealTypeToWord(plan.meal_type) }}</td>
              <td class="tdata">{{ getRecipeName(plan.recipe_id) }}</td>
            </div>
          </tr>
        </tbody>
      </table>

      <form class="mealForm" v-show="showOptions">
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
              <option value="1">Breakfast</option>
              <option value="2">Lunch</option>
              <option value="3">Dinner</option>
              <option value="4">Snack</option>
              <option value="5">Appetizer</option>
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
           <button class="addToPlanBtn editBtn" v-if="!addingNewMeal" @click.prevent="addChangeToPlan(currentIdx)">
            Edit
          </button>
          <button class="addToPlanBtn editBtn" v-else @click.prevent="addNewMealToPlan">
            Add
          </button>
        </div>
        <div class="btn">
         
        </div>
      </form>

      <div class="btn">
        <button class="addToPlanBtn" @click.prevent="addMealToDB">
          Save All Changes
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import recipeService from "../services/RecipeService.js";
import mealPlanService from "../services/MealPlanService";

export default {
  name: "modify-meal-plan",
  data() {
    return {
      planNameAdded: false,
      showOptions: false,
      mealPlanName: "",
      currentSelectedRecipe: "",
      currentIdx: 0,
      listOfPlans: [],
      listOfNewlyAddedPlans:[],
      listOfTotalPlans:[],
      addingNewMeal: false,
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

  computed: {
    currentRecipeId() {
      let recipeObj = this.$store.state.recipes.find(
        (recipe) => recipe.recipe_name === this.currentSelectedRecipe
      );
      return recipeObj.recipeId;
    },
    displayModifiedCombos() {
        return this.listOfTotalPlans;
    }
  },

  created() {
    recipeService.getRecipes(this.$store.state.user.id).then((response) => {
      this.$store.commit("SET_RECIPE", response.data.sort());
    });

    this.getListOfMealPlans();
   
  },

  methods: {
    getListOfMealPlans() {
        mealPlanService
      .getMealPlanById(this.$route.params.mealPlanId)
      .then((response) => {
        this.listOfPlans = response.data;
        this.listOfTotalPlans = response.data;
        this.mealPlanName = this.listOfPlans[0].plan_name;
      });
    },
    clear() {
      this.mealPlan = {
        plan_name: "",
        recipe_id: 0,
        for_date: "",
        meal_type: 0,
      };

      this.currentSelectedRecipe = "";
    },
    addName() {
      this.planNameAdded = false;
    },
    modifyName() {
      this.planNameAdded = true;
    },

    getRecipeName(currentRecipeId) {
      let recipeObj = this.$store.state.recipes.find(
        (recipe) => recipe.recipeId === currentRecipeId
      );
      return recipeObj.recipe_name;
    },

    convertMealTypeToWord(mealType) {
      if (mealType === 1) {
        return "Breakfast";
      } else if (mealType === 2) {
        return "Lunch";
      } else if (mealType === 3) {
        return "Dinner";
      } else if (mealType === 4) {
        return "Snack";
      } else {
        return "Appetizer";
      }
    },
    addMealToDB() {
      this.listOfPlans.forEach((plan) => {
        plan.plan_name = this.mealPlanName;
      })

      mealPlanService.updateMealPlan(this.$route.params.mealPlanId, this.listOfPlans);
      mealPlanService.addMoreMealsToExistingPlan(this.listOfNewlyAddedPlans, this.$store.state.user.id);
      this.clear();
      this.$router.push({name: 'mealplans', params: {userId: this.$store.state.user.id }});

 
    },

    editAndDisplay(index) {
        this.currentIdx = index;
        this.showOptions = !this.showOptions;
        
    },

    addNewMeal() {
        this.showOptions = !this.showOptions;
        this.addingNewMeal = !this.addingNewMeal;
    },

    addNewMealToPlan() {
        this.mealPlan.plan_name = this.mealPlanName;
        this.mealPlan.recipe_id = this.currentRecipeId;
        this.mealPlan.meal_type = parseInt(this.mealPlan.meal_type);
        this.mealPlan.meal_plan_id = this.$route.params.mealPlanId;
        this.listOfNewlyAddedPlans.push(this.mealPlan);
        this.listOfTotalPlans.push(this.mealPlan);
        this.clear();
         this.addingNewMeal = !this.addingNewMeal;
         this.showOptions = !this.showOptions;
    },

    addChangeToPlan(index) {
        this.listOfPlans[index].for_date = this.mealPlan.for_date;
        this.listOfPlans[index].meal_type = parseInt(this.mealPlan.meal_type);
        this.listOfPlans[index].recipe_id = this.currentRecipeId;
        this.showOptions = !this.showOptions;
        this.clear();
    }
  },
};
</script>

<style scoped>
.wrapper {
  /* margin-bottom: 15%;  */
  background-color: rgb(255, 240, 221);
  padding-bottom: 1ch;
  width:60%;
  border-radius: 25px;
  margin-left: 20vw;
  border: solid 4px;
}
.placehold {
  color: black;
}
.background {
  text-align: center;
  font-family: "Dosis", monospace, sans-serif;
  background: url(../assets/veggies.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  padding-bottom: 50px;
  padding-top: 50px;
}
.addBtn,
.modifyBtn,
.addToPlanBtn {
  margin: 0 10px;
  background-color: #a6f5ac;
  /* color: white; */
  font-weight: bold;
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
  position: relative;
  background-color: #ffffff;
  border: 2px solid #422800;
  border-radius: 30px;
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

  /* left: 50%; */
  /* position: absolute; */
  /* margin-left: 43%; */
}

.editBtn{
 min-width: 10%;
 height: 30px;
}

.addNewMealBtn {
  margin-top: 1em;
}


.weekly-plan-name {
  text-align: center;
  padding: 30px;
  background-color: rgba(255, 239, 14, 0.411);
  border-radius: 25px 25px 0 0;
  border-bottom: solid 2px;
}

.options {
  display: flex;
  justify-content: center;
  align-items: center;
  /* background-color:rgb(241, 249, 253); */
  margin: 0 auto;
  width:70%;
  margin-left: 10vw; 
}


.calendarImg {
  border-radius: 25px;
}

table {
  background-color: #ecf2f0;
  margin: 50px auto;
  margin-top: 20px;
  border-radius: 25px;
  text-align: center;
}

.tdata {
  padding: 1.2em;
  margin: 1.5em;
}

.tdata:nth-child(even) {
  background-color: #dfe9e6;
}


.planContainer {
  display: flex;
  justify-content: space-evenly center;
  
}

.dateOptions,
.mealTypeOptions,
.recipesOptions {
  display: inline-block;
  margin: 30px;
}

h1 {
  display: inline-block;
}

img {
  margin-left: 5px;
  border-radius: 10px;
}
</style>