<template>

  <div id="login" class="text-center">
    <div class="login1">
      <main-login class="login2"/>
     <!-- <about-us class="login2"/> -->
    </div>

    <div></div>
    <div class="form">
       <img class="logo" src="..\assets\cropped-logo.png" alt="Logo">
    <form class="form-signin" @submit.prevent="login">
      <h2 class="h3 mb-3 font-weight-normal">Please Sign In</h2>
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
import MainLogin from '../components/MainLogin.vue';
import authService from "../services/AuthService";

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
  background-color: rgb(234, 250, 176);
  font-family: 'Dosis', monospace, sans-serif;
  padding: 30px;
   background: url(../assets/2.png) no-repeat center center fixed;
   background-position:bottom;
   
}

.login1{
  width:70%
}
.form{
  width:30%;
  align-content: center;
  text-align: center;
  background-color: white;
  padding-top: 50px;
  border: solid 4px;
  border-radius: 25px;
  align-items: center;
  justify-content: center;
}
.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
  
}

.form-signin .form-control {
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
  align-content: center;
  text-align: center; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
}
.form-signin input:hover{
  
  color: black;
  background-color: #fcf8ee;
   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}

.btn{
  padding: 10px;
  margin: 20px;
  width:25%;
  font-family: 'Dosis', monospace, sans-serif;
}
.sr-only{
  padding: 10px;
  font-weight:bold ;
  
}
input{
  padding:10px;
  font-family: 'Dosis', monospace, sans-serif;
}
.form-control{
margin: 2%;
}
.logo{
    max-width: 130px;
    border-radius: 50%;
    box-shadow: #FC0 1px 0 10px;
     
}

</style>