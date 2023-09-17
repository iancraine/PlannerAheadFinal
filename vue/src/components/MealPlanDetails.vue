<template>
 <div>
<div class="tableStyle">
         <table>
        <thead>
          <tr>
            <th class="tdata">Date</th>
            <th class="tdata">Meal</th>
            <th class="tdata">Recipe</th>
            
          </tr>
        </thead>
        <tbody>
          <tr v-for="(day, index) in mealPlan" v-bind:key="index">
            <td class="tdata">{{day.for_date}}</td>
            <td class="tdata">{{convertMealTypeToWord(day.meal_type)}}</td>
            <td class="tdata"><router-link :to="{name: 'recipesId', params: {recipeId: day.recipe_id}}">{{getRecipeName(day.recipe_id)}}</router-link></td>
            
          </tr>
        </tbody>
      </table>  
      </div>
  </div>

</template>

<script>
export default {
    name: "meal-plan-details",
    props: {
      mealPlan: Array
    },
    data(){
        return{
        }
    },
    methods: {
         getRecipeName(currentRecipeId) {
        let recipeObj = this.$store.state.recipes.find((recipe) => recipe.recipeId === currentRecipeId);
        return recipeObj.recipe_name;
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
    }
    }

}
</script>

<style scoped>


.tableStyle {
  display: flex;
  justify-content: center;
  padding: 2em;
  border-bottom: 1px dashed black;
  max-width: 50%;
  margin: 0 auto;
  
  font-weight: bold;

}
tr>th{
  font-size: 22px;
}
.tdata {
  padding: 10px;
}

a {
  text-decoration: none;
  color:rgb(71, 149, 194);
  font-weight: bold;
  font-family:cursive
  
}

/* .addBtn,
.modifyBtn {
  margin: 0 10px;
  background-color: #e1ecf4;
  font-family: system-ui, sans-serif;
  border-radius: 3px;
  border: 1px solid #adc4d4;
  padding: 0.3em;
}

.addBtn:hover,
.modifyBtn:hover {
  font-weight: 2em;
  cursor: pointer;
}
.weekly-plan-name {
  text-align: center;
  padding: 30px;
}

.options{
    display: flex;
    justify-content: center;
}

.calendarImg{
   border-radius: 25px;
}

table{
    background-color: #ECF2F0;
    margin: 50px auto;
    border-radius: 25px;
}

tr, td {
  padding: 1.2em;
}

.container {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
} */
</style>