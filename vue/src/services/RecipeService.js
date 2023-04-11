import axios from 'axios';

export default {
    getRecipies(){
        return axios.get('/myRecipies');
    },
    getRecipe(recipeId) {
        return axios.get(`/recipes/${recipeId}`)
      },
}
