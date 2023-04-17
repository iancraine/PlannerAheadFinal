import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    listAllMealPlans(userId){
        return http.get(`/mealplans/list/${userId}`);
    },
    getMealPlanById(mealPlanId){
        return http.get(`/mealplans/${mealPlanId}`);
    },
    addMealPlan(userId, mealPlan){
        return http.post(`/mealplans/add/${userId}`, mealPlan); //mealPlan must be an array of objects
    },
    deleteMealPlan(userId, mealPlanId){
        return http.delete(`/mealplans/${userId}/${mealPlanId}`);
    },
    updateMealPlan(mealPlanId, mealPlan){
        return http.put(`/mealplans/${mealPlanId}`, mealPlan);  //mealPlan must be an array of objects
    },
    addMoreMealsToExistingPlan(mealPlan, userId) {
        // mealPlan must be an array of newly adding meal combos to an existing plan
        return http.post(`/mealplans/addnew/${userId}`);
    }
}