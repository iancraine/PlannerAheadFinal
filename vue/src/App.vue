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

#app {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: "nav"
                        "view"
                        "footer";
  /* position: relative; */
  height: 100vh;
  gap: 10px;
}
#content {
  padding-bottom: 2.5rem;
}
nav-bar {
  grid-area: nav;
}
router-view {
  grid-area: view;
}
.footer {
  grid-area: footer;
  /* position: absolute; */
  bottom: 0;
  /* height: 2.5rem; */
  /* margin: 10%; */
}
</style>

