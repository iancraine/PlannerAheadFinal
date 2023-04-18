import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default{
    getAllGroceryListItems(userId){
        return http.get(`/grocery/list/${userId}`);
    },
    addGroceriesToDB(userId, groceries){
        return http.post(`/grocery/add/${userId}`, groceries);
    },
    clearGroceryList(userId){
        return http.delete(`/grocery/delete/${userId}`)
    },

    deleteSelectedLists(listId) {
        return http.delete(`/grocery/delete-partial/${listId}`);
    }


}
