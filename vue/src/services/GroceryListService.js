import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default{
    getAllGroceryListItems(userId){
        return http.get(`/grocery/list/${userId}`);
    }

}
