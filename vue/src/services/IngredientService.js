import axios from 'axios';

const http = axios.create({
    baseURL: "https://plannerahead-eeec72fe62b2.herokuapp.com"
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
    addIngredientForRecipe(recipeId, ingredient) {
        return http.post(`/ingredients/recipe/${recipeId}`, ingredient);
    },
    deleteIngredientForRecipe(userId, recipeId) {
        return http.delete(`/ingredients/${userId}/${recipeId}`);
    },
    editIngredient(recipeId, ingredients){
        return http.put(`/ingredients/edit/${recipeId}`, ingredients);
    }

}
