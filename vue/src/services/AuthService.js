import axios from 'axios';

const http = axios.create({
  baseURL: "https://plannerahead-eeec72fe62b2.herokuapp.com"
});

export default {

  login(user) {
    return http.post('/login', user)
  },

  register(user) {
    return http.post('/register', user)
  },

}
