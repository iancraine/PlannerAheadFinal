<template>
  <div id="app">

    <div class="nav-bar">
      <nav-bar></nav-bar>
    </div>
    
    <router-view />

    <div class="footer-parent">
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
@media(max-width: 768px){
  /* .nav-bar{
    display: flex;
    flex-shrink: 1;
  }
  .footer-parent{
    display: flex;
    flex-shrink: 1;
  } */
}

#app {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: "nav"
                        "view"
                        "footer";
  /* position: relative; */
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
  /* position: absolute; */
  bottom: 0;

  /* height: 2.5rem; */
  /* margin: 10%; */
}
</style>

