import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
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
    modifyRecipe(recipeId) {
        return http.put(`/recipes/${recipeId}`);
    }
}
