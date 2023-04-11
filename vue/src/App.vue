<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'recipes', params: {id: this.$store.state.currentUser.id} }" v-if="$store.state.token != ''">My Recipies</router-link> 
    </div>
    <router-view />
    <Footer class="footer"/>
  </div>
</template>

<script>
import Footer from './components/Footer.vue'

export default {
  components: { 
    Footer
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

