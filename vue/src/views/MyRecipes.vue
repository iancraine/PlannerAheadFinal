<template>
<div>
    <recipe-list />
    <test/>
</div>
</template>

<script>
import RecipeList from "../components/RecipeList.vue";
import Test from '../components/Test.vue';


export default {
  name: 'MyRecipes',
  components: {
    RecipeList,
    Test
  
  }

}
</script>

<style>

</style>