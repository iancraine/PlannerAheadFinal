<template>
  <div id="headerNav">
      <img class="logo" src="../assets/Logo.png" alt="Planner ahead logo" width="100" height="100"/>

      <div id="myRecipes"> <router-link v-bind:to="{ name: 'recipes', params: {userId: this.$store.state.user.id} }" v-if="$store.state.token != ''">My Recipes</router-link> </div>
        <div id="home"> <router-link v-bind:to="{ name: 'home' }">Home</router-link></div>
        <div id="logout"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
    .logo{
        border-radius: 10%;
    }

    div#headerNav {
        display: flex;
        align-items: flex-end;
       margin: 0 auto;
       border-bottom: 3px solid rgb(237, 248, 137);
       background-color:aliceblue;
    }

    a {
        text-decoration: none;
        text-transform: uppercase;
        font-size: 1.2em;
        font-size: 100%;
        font-family: Arial, Helvetica, sans-serif;

    }

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
</style>