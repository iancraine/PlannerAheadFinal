<template>
  <div class="page">
    <div class="page-title">
      <h2 class="title">My Recipes 222</h2>
      <button class="addNewRecipe" v-on:click="toggleShowForm()">Add New Recipe</button>
    test11
      <div v-for="a in testArray" v-bind:key="a" >
        test
        <img :src="require(`../assets/${a}/M${a}.png`)" alt="Pot Roast" />
      </div>
      <!-- <img :src="require(testImgSrc2)" /> -->
      <!-- <img :src="testImgLink" alt="Pot Roast222" /> -->
    </div>
    <new-recipe-form  id="form" v-if="showForm"/>
      <div class="recipe-container">
      <div class="recipe">
        <div v-for="recipe in recipes" v-bind:key="recipe.recipeId" class="recipe-card">
            <h1><router-link class="h1" v-bind:to="{ name:'recipesId', params:{recipeId:recipe.recipeId}}">{{recipe.recipe_name}}</router-link></h1>
           test
           <div class="image">
              <img src="../assets/1M.png" alt="Pot Roast" />
              <!-- <img :src="randomItem(images, recipe.recipe_name)" class="foodPic" /> -->
             <!-- <img :src="getRecipeId(recipe.recipeId)"  alt="first imag"/> -->
            </div>
            <div class="tag"><h5 class="tag">Tag:</h5>
            <p class="tag">{{recipe.tags}}</p>
            </div>
            <div class="time">
              <h5 class="time">Prep Time:</h5>
            <p class="time">{{recipe.prep_time}}</p>
            </div>
        </div>
        </div>
      </div>
  </div>
</template>
<script>
import recipeService from "../services/RecipeService.js";
import NewRecipeForm from './NewRecipeForm.vue';
export default {
    name: 'recipes',
  data() {
    return {
      recipes: [],
      showForm: false,
      images:[
        require('../assets/meal-sample1.jpg'),
         require('../assets/meal-sample2.png'),
          require('../assets/meal-sample3.png'),
         require('../assets/meal-sample-4.jpg'),
          require('../assets/food-plate-icon.png'),
           require('../assets/1M.png'),
            require('../assets/M6.png'),
           require('../assets/M9.png')
      ],
      //testImgLink : "~/assets/1M.png",
      testImgLink : "../1M.png",
      testArray: [1,2]
    }
  },
  components: {
    NewRecipeForm
  },
  methods: {
    toggleShowForm() {
      this.showForm = !this.showForm;
    },
      randomItem(items, name) {
        if (name === 'Crock Pot Roast') return require('../assets/Old-Fashioned-Pot-Roast.png');
        else if(name === 'Roasted Asparagus') return  require('../assets/roasted-asparagus.jpg');
        else {
           return items[Math.floor(Math.random()*items.length)];
        }
      },
      getRecipeId(recipeId){
             return this.$store.state.recipesimg.find(recipesimg => recipesimg.id === recipeId).imagePath;
      }
  },
  //** might not need this*/
  created() {
    recipeService.getRecipes(this.$route.params.userId).then(response => {
      this.recipes = response.data;
    });
  },
  computed: {
    testImgSrc2() {
    return "../assets/1M.png"
  }
  },
// computed: {
//     recipe() {
//       return this.$store.state.recipesimg.find(recipesimg => recipesimg.id === this.$route.params.recipe.recipe.Id)
//     }
//   }
}
</script>
<style scoped>
@import url(https://fonts.googleapis.com/css2?family=Dosis);
.page{
  margin: 5em;
  font-family: 'Dosis', monospace, sans-serif;
  text-align: center;
  font-family: 'Dosis', monospace, sans-serif;
  /* background: url(../assets/white-background.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover; */
  padding-bottom: 50px;
  margin: 0px;
}
.title{
  color:#0d75134b;
  text-shadow: 2px 2px 4px #E2EBDC;
  font-size: 42px;
  align-content: center;
  padding: 20px;
  grid-area: "title";
  text-align: center;
  margin-top: 20px;
  margin-bottom: 20px;
}
div.page-title h1{
  text-align: center;
}
.recipe-container{
  background-color: #EBF2EF;
  margin-top: 10px;
}
div.recipe{
  display: flex;
      flex-wrap: wrap;
      margin: 0 auto;
      border-radius: 10px;
      justify-content: space-around;
      padding: 2%;
}
.recipe-card{
  width: calc(100% * (1/4) - 10px - 1px);
  border-radius: 10px;
}
.recipe{
  grid-area: card;
  /* display: flex; */
  /* flex-wrap: wrap;
  justify-content: space-around; */
}
.h1{
  color: rgb(20, 73, 187);
  text-decoration: none;
}
.tag{
  display: inline-block;
  padding: 5px;
}
.time{
  display: inline-block;
  padding: 5px;
}
.addNewRecipe {
  background: #CDECCD;
  border-radius: 900px;
  box-shadow: #BDBDFA 0 10px 20px -10px;
  color: #180D04;
  cursor: pointer;
  font-family: Inter, Helvetica;
  font-weight: 700;
  line-height: 24px;
  outline: 0 solid transparent;
  padding: 8px 18px;
  border: 0;
  margin: 0 auto;
  display: flex;
  font-family: 'Dosis', monospace, sans-serif;
}
#form {
  display: flex;
  justify-content: center;
  margin: 15px;
  padding: 20px;
  background-color: rgb(236, 245, 226);
}
.foodPic {
  width: 350px;
  border-radius: 15px;
  max-width: 80%;
  height: auto;
}
</style>







