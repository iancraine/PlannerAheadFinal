<template>
  <div>
      <h1>hello</h1>
        <div v-for= "recipie in recipies" v-bind:key="recipie.id"> 
            <h1>Hello</h1>
            <p>{{recipie.name}}</p>
            <p>{{recipie.directions}}</p>

        </div>
  </div>
</template>

<script>
import recipieService from "../services/RecipieService.js";

export default {
    name: 'recipies',
  data() {
    return {
      recipies: []
    }
  },

  //** might not need this*/
  created() {
    recipieService.getTopics().then((response) => {
      this.recipies = response.data;
    });
  }

}
</script>
<style>

</style>