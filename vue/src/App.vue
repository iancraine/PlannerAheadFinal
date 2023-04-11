<template>
  <div id="app">
    <nav-bar></nav-bar>
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'recipes', params: {userId: this.$store.state.user.id} }" v-if="$store.state.token != ''">My Recipies</router-link> 
    </div> -->
    <router-view />
    <Footer class="footer"/>
  </div>
</template>

<script>
import Footer from './components/Footer.vue'
import NavBar from './components/NavBar.vue'

export default {
  components: { 
    Footer,
    NavBar
   },
};
</script>

<style>
div.footer{
    background-color: aqua;
    width: 100vw;
    height: 15vh;
    position: fixed;

    
}


</style>

