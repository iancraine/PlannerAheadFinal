import axios from 'axios';

export default {
    getRecipes(){
        return axios.get(`/recipes/:id`);
    },
    getRecipe(recipeId) {
        return axios.get(`/recipes/${recipeId}`)
      },
}
