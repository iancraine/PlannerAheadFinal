<template>
  <div class="page">
    <div class="page-title">
      <h2 class="title">My Recipes</h2>
      <!-- <form class="search-form">
          <input type="text" placeholder="Search...">
          <button type="submit"><i class="fa fa-search"></i></button>
        </form> -->
      <button class="addNewRecipe" v-on:click="toggleShowForm()">Add New Recipe</button>
    
    </div> 
    <div id="form-background">
    <new-recipe-form  id="form" v-if="showForm"/>
      <div class="recipe-container">
      <div class="recipe">
        <div v-for="recipe in recipes" v-bind:key="recipe.recipeId" class="recipe-card"> 
          <div id="recipe-box">
            <h1><router-link class="h1" v-bind:to="{ name:'recipesId', params:{recipeId:recipe.recipeId}}">{{recipe.recipe_name}}</router-link></h1>
           <div class="image">
              <!-- <img src="../assets/1M.png" alt="Pot Roast" /> -->
              <!-- <img :src="randomItem(images, recipe.recipe_name)" class="foodPic" /> -->
             <img :src="getRecipeId(recipe.recipeId)"  alt="first imag" class="foodPic"/>
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
    }
  },
  components: {
    NewRecipeForm
  },
  methods: {
    toggleShowForm() {
      this.showForm = !this.showForm;
    },
      // randomItem(items, name) {
      //   if (name === 'Crock Pot Roast') return require('../assets/Old-Fashioned-Pot-Roast.png');
      //   else if(name === 'Roasted Asparagus') return  require('../assets/roasted-asparagus.jpg');
      //   else {
      //      return items[Math.floor(Math.random()*items.length)];
      //   }
       
      // },

      randomItem(items) {
           return items[Math.floor(Math.random()*items.length)];
        },

      getRecipeId(recipeId){
            let matchingImage = this.$store.state.images.find(recipesimg => recipesimg.id === recipeId);           
             if (matchingImage != undefined) {return matchingImage.path;}
             else {return this.randomItem(this.images);}

      }
    
  },

  //** might not need this*/
  created() {
    recipeService.getRecipes(this.$route.params.userId).then(response => {
      this.recipes = response.data;
    });
    
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
  font-family: 'Dosis', monospace, sans-serif;
  text-align: center;
  font-family: 'Dosis', monospace, sans-serif;
  /* background: url(../assets/white-background.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover; */
  /* padding-bottom: 50px; */
  margin: 0px;
}
.title{
  color: #422800;
  /* color:#0d75134b; */
  /* text-shadow: 2px 1px 1px black; */
  font-size: 42px;
  align-content: center;
  padding: 20px;
  grid-area: "title";
  text-align: center;
  margin-top: 0;
  margin-bottom: 20px;
  
}

div.page-title h1{
  text-align: center;
}
.recipe-container{
  background-color: #f3e5bd;
  /* margin-top: 10px; */
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
margin-right: 15px;
  background: #c1ecc1;
  backface-visibility: hidden;
  border-radius: .375rem;
  border-width: .125rem;
  color: #180d04;
  cursor: pointer;
  font-family: 'Dosis', monospace, sans-serif;
  font-size: 1rem;
  font-weight: 700;
  line-height: 1.2;
  padding: 0.5rem;
  position: relative;
  text-align: left;
  margin-bottom: 15px;

  /* background: #cdeccd;
  border-radius: 900px;
  box-shadow: #bdbdfa 0 10px 20px -10px;
  color: #180d04;
  cursor: pointer;
  font-family: Inter, Helvetica;
  font-weight: 700;
  line-height: 24px;
  outline: 0 solid transparent;
  padding: 8px 18px;
  border: 0;
  margin: 0 auto;
  display: flex;
  font-family: 'Dosis', monospace, sans-serif; */
}
button:hover{
  transform: scale(1.05);
}

button:focus{
  outline: 0 solid transparent;
}
button{
   background-color: #fbeee0;
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
  font-family: 'Dosis', monospace, sans-serif;

}


#form {
  display: flex;
  justify-content: center;
  margin-left: 450px;
  margin-right: 450px;
  border-radius: 25px;
  padding: 20px;
  background-color: rgb(236, 245, 226);
  border: solid 4px;
}
.foodPic {
  width: 250px;
  height: 250px;
  border-radius: 15px;
  background-color: white;
  /* border: solid 4px; */
  /* max-width: 80%; */
  /* height: auto; */
}
.page-title{
  background-color: #f3e5bd;
}
#form-background{
  background-color: #f3e5bd;
}
#recipe-box{
  background-color: aliceblue;
  border-radius: 25px;
  border: solid 4px;
  margin: 20px;
}
</style>

