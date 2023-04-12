<template>
  <div id="app">
    <nav-bar></nav-bar>
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

