import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    getAllIngredients(){
        return http.get(`/ingredients`);
    },
    addIngredient(userId, ingredient) {
        return http.post(`/ingredients/user/${userId}`, ingredient);
    },
    getIngredientsForRecipe(recipeId) {
        return http.get(`/ingredients/recipe/${recipeId}`);
    },
    addIngredientForRecipe(recipeId, ingredient, amount) {
        return http.post(`/ingredients/recipe/${recipeId}/${amount}`, ingredient);
    },
    deleteIngredientForRecipe(userId, recipeId) {
        return http.delete(`/ingredients/${userId}/${recipeId}`);
    }

}
