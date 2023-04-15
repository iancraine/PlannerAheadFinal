<template>
<div class="background">
  <div class="wrapper">
    <div class="weekly-plan-name">
      <!-- <label for="meal-plan-name"> <h2>Meal Plan Name:</h2> </label> -->
      <div class="title-add-section" v-if="!planNameAdded">
        <input
          placeholder="Meal Plan Name"
          type="text"
          class="meal-plan-name"
          id="meal-plan-name"
          v-model="mealPlanName"
          @keyup.enter="addName"
        />
        <button class="addBtn" @click.prevent="addName">Add</button>
      </div>

      <div class="addedTitleDisplay" v-if="planNameAdded">
        <h3>{{ mealPlanName }}</h3>
        <button class="modifyBtn" @click.prevent="modifyName">Edit Name</button>
      </div>
    </div>

    <form class="mealForm">
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
       <div class="btn">
           <button class="addToPlanBtn" @click.prevent="addMealCombo">Add Meal </button>
       </div>
   
    </form>

    <table>
      <thead>
          <tr>
            <div class="planContainer">
              <th class="tdata">
                <img
                  src="../assets/calendar-planner.jpg"
                  class="calendarImg"
                  height="100"
                  width="100"
                />
              </th>
              <th class="tdata">Date</th>
              <th class="tdata">Meal</th>
              <th class="tdata">Recipe</th>
            </div>
          </tr>
       
      </thead>
      <tbody>
        <tr v-for="plan in listOfPlans" v-bind:key="plan.for_date">
          <div class="planContainer">
          <td class="tdata"> placeholder</td>
          <td class="tdata">{{plan.for_date}}</td>
          <td class="tdata">{{convertMealTypeToWord(plan.meal_type)}}</td>
          <td class="tdata">{{plan.recipe_id}}</td>
          </div>
        </tr>

      </tbody>
    </table>
    <div class="btn">
     <button class="addToPlanBtn" @click.prevent="addMealToDB"> Add To Meal Plan </button>
     </div>
  </div>
</div>
</template>


<script>
import recipeService from "../services/RecipeService.js";
import mealPlanService from "../services/MealPlanService"

export default {
  name: "add-meal-plan",
  data() {
    return {
      planNameAdded: false,
      mealPlanName: "",
      currentSelectedRecipe: "",
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
    // mealTypeName() {
    //   if (this.mealPlan.meal_type === "1") {
    //     return "Breakfast";
    //   }
    //   else if (this.mealPlan.meal_type === "2") {
    //     return "Lunch";
    //   }
    //   else if(this.mealPlan.meal_type === "3") {
    //     return "Dinner";
    //   }
    //   else if(this.mealPlan.meal_type === "4") {
    //     return "Snack";
    //   }
    //   else {
    //     return "Appetizer"
    //   }
    // },

    currentRecipeId() {
      let recipeObj =  this.$store.state.recipes.find((recipe) => 
         recipe.recipe_name === this.currentSelectedRecipe
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
    addName(){
        this.planNameAdded = true;
    },
    modifyName() {
        this.planNameAdded = false;
    },

    convertMealTypeToWord(mealType) {
      if (mealType === 1) {
        return "Breakfast";
      }
      else if (mealType === 2) {
        return "Lunch";
      }
      else if(mealType === 3) {
        return "Dinner";
      }
      else if(mealType === 4) {
        return "Snack";
      }
      else {
        return "Appetizer"
      }
    },
    addMealCombo() {
         this.mealPlan.meal_type = parseInt(this.mealPlan.meal_type);
         this.mealPlan.plan_name = this.mealPlanName;
         this.mealPlan.recipe_id = this.currentRecipeId;

         this.listOfPlans.push(this.mealPlan);

        this.clear();
    },
    addMealToDB() {
      mealPlanService.addMealPlan(this.$store.state.user.id, this.listOfPlans);
      this.listOfPlans=[];
      this.clear();
      this.mealPlanName= "";
    }
  },
};
</script>

<style scoped>

.wrapper {
  /* margin-bottom: 15%;  */
  background-color: rgb(255, 240, 221);
  padding-bottom: 1ch;
  width: 50%;
  border-radius: 25px;
  margin-left: 25vw;
}
.background{
  text-align: center;
  font-family: 'Dosis', monospace, sans-serif;
  background: url(../assets/veggies.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  padding-bottom: 50px;
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
  /* left: 50%; */
  margin-left: 43%;
}
.weekly-plan-name {
  text-align: center;
  padding: 30px;
  background-color: rgba(255, 239, 14, 0.411);
  border-radius: 25px 25px 0 0;
}

.options {
  display: flex;
  justify-content: center;
  /* background-color:rgb(241, 249, 253); */
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

/* tr{
  padding: 1.2em;
} */

.tdata{
  padding: 1.2em;
  margin: 1.5em;
}
.tdata:nth-child(even){
  background-color: #dfe9e6;
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

/* .mealForm {
  background-color:white;
} */

</style>