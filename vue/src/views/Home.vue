<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <new-recipe-form/>
  </div>
</template>

<script>
import NewRecipeForm from '../components/NewRecipeForm.vue';

export default {
  components: {
    NewRecipeForm 
   },
  name: "home",
  
};
</script>
