<template>
  <div id="headerNav">
      <div class="logoImg">
          <img class="logo" src="../assets/cropped-logo.png" alt="Planner ahead logo"/>
      </div>
      <!-- <div id="brandName"> Planner Ahead </div> -->

      <ul class="nav-links">
        <li id="mealPlans"><router-link v-bind:to="{ name: 'mealplans', params: {userId: this.$store.state.user.id}}" v-if="$store.state.token != ''">Meal Plans</router-link></li>
        <li id="myRecipes"> <router-link v-bind:to="{ name: 'recipes', params: {userId: this.$store.state.user.id} }" v-if="$store.state.token != ''">My Recipes</router-link> </li>
        <li id="aboutUs"><router-link v-bind:to="{ name: 'about-us' }">About Us</router-link></li>
        <li id="home"> <router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
        <li id="logout"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
        </ul>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
     
    div#headerNav {
        display: flex;
        align-items: center;
       /* margin: 0 auto; */
       padding: 0px;
       border-bottom: 3px solid rgb(244, 247, 224);
       background-color:rgb(236, 245, 226);
    }

    .logo{
        border-radius: 10%;     
        width: 100px; 
    }

    .logoImg{
        padding-left: 25px;
        padding-top: 10px;
        padding-bottom: 10px;
    }

    a {
        text-decoration: none;
        text-transform: uppercase;
        font-size: 90%;
        font-family: Arial, Helvetica, sans-serif;
        color: black;

    }
    
    a:hover{
        background-color:rgb(220, 250, 206);
        font-weight: bold;
    }

    #brandName{
        text-decoration: none;
        text-transform: capitalize;
        font-size: 1.4em;
        font-family: Arial, Helvetica, sans-serif;
        color: black;
        position: absolute;
        left: 200px;
    }

    /* flex nav links to right side */

    /* .nav-links{
        display: flex;
        justify-content: flex-end;
    }
    ul{
        display: flex;
        justify-content: flex-end;
    } */

    #home {
        position: absolute;
        right: 300px;
    }

    #myRecipes{
        position: absolute;
        right: 150px;
    }

    #logout{
        position: absolute;
        right: 50px;
    }

    #aboutUs{
        position: absolute;
        right: 400px;
    }
    #mealPlans{
        position: absolute;
        right: 500px;
    }
   

</style>