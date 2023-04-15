<template>
  <div id="login" class="text-center">
    <div class="login1">
      <main-login class="login2"/>
     <!-- <about-us class="login2"/> -->
    </div>
    <div class="form">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /><br>
      <router-link :to="{ name: 'register' }" class="needacc">Need an account?</router-link>
      <button class="btn" type="submit">Sign in</button>
    </form>
    </div>
  </div>
</template>

<script>
// import AboutUs from '../components/AboutUs.vue';
import MainLogin from '../components/MainLogin.vue';
import authService from "../services/AuthService";
// import MainLogin from "../components/MainLogin.vue"

export default {
  name: "login",
  components: {MainLogin},
  data() {
 
     return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            // this.$store.commit("SET_USER_ID", response.data.user.userId)//set user id
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style scoped>
#login {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  background-color: rgb(234, 250, 177);
}
.login1{
  width:70%
}
.form{
  width:30%;
  align-content: center;
}
.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
  
}

.form-signin .form-control {
  /* position: relative; */
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
  align-content: center;
  margin-left: 50px;
  text-align: center; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
}
.form-signin input:hover{
  
  color: white;
  background-color: #fcf8ee;
   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}

.btn{
  padding: 10px;
  margin: 20px;
  width:25%;
  
}
.sr-only{
  padding: 10px;
  font-weight:bold ;
  
}
input{
  padding:10px;
}
.form-control{
margin: 2%;
}

</style>