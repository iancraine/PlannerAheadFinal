import axios from 'axios';

export default {
    getRecipies(){
        return axios.get('/myRecipies');
    },
}
