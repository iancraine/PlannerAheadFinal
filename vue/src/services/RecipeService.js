import axios from 'axios';

const http = axios.create({
    baseURL: "https://plannerahead-eeec72fe62b2.herokuapp.com"
})

export default {
    getRecipes(userId){
        return http.get(`/recipes/list/${userId}`);
    },
    getRecipeById(recipeId) {
        return http.get(`/recipes/${recipeId}`)
      },
    addNewRecipe(userId, recipe) {
        return http.post(`/recipes/${userId}`, recipe);
    },
    deleteRecipe(recipeId, userId) {
        return http.delete(`/recipes/${recipeId}/${userId}`);
    },
    modifyRecipe(recipeId, recipe) {
        return http.put(`/recipes/${recipeId}`, recipe);
    }
    
}
