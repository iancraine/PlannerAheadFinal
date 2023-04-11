import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  getUserId() {
    return axios.get('/user/id'); //  getting the user ID
  },

}
