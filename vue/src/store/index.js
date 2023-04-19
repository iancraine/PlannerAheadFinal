import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    // userId: '',
    token: currentToken || '',
    user: currentUser || {},
    recipes:[],
   
    //***n */
    images: [
      {
        id: 1,
        name: 'Crock Pot Roast',
        path: require('../assets/Old-Fashioned-Pot-Roast.png')
      },
      {
        id: 2,
        name: 'Roasted Asparagus',
        path: require('../assets/roasted-asparagus.jpg')
      },
      {
        id: 3,
        name: 'Curried Lentils and Rice',
        path: require('../assets/Lentil-Curry-4-SQUARE.jpg')
      },
      {
        id: 4,
        name: 'Big Night Pizza',
        path: require('../assets/k_Photo_Recipe Ramp Up_2021-07-Chicken-Alfredo-Pizza_Chicken-Alfredo-Pizza-KitchnKitchn2970-1_01.jpg')
      },
      {
        id: 5,
        name: 'Mic Yorkshire Puds',
        path: require('../assets/recipe-image-legacy-id-740564_11-b52d07b.jpg')
      },
      {
        id: 6,
        name: 'Old-Fashioned Oatmeal Cookies',
        path: require('../assets/download.jpg')
      },
      {
        id: 7,
        name: 'French Fries',
        path: require('../assets/french-fries.jpg')
      },
      {
        id: 8,
        name: 'Duck Confit',
        path: require('../assets/duck-confit.jpg') 
      },
      {
        id: 8,
        name: 'Chicken Pot Pie',
        path: require('../assets/chicken-pot-pie.jpg')  
      }

    ]


  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_RECIPE(state, recipesArr) {
      state.recipes = recipesArr;
    },
    // SET_USER_ID(state, )

    //**N */
    
     
  }
})
