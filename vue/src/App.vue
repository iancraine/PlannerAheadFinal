<template>
  <div id="app">

    <div class="nav-bar noprint">
      <nav-bar></nav-bar>
    </div>
    
    <router-view />

    <div class="footer-parent noprint">
      <page-bottom class="footer"/>
    </div>
  
  </div>
</template>

<script>
import PageBottom from './components/PageBottom.vue'
import NavBar from './components/NavBar.vue'

export default {
  components: { 
    PageBottom,
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
  /* height: 100vh; */
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
  bottom: 0;
}
@media print{
.noprint{
  display: none;
}
}
</style>

