<template>
<div>
    <recipe-list v-bind:userId="this.$route.params.this.userId"/>
</div>
</template>

<script>
import RecipeList from "../components/RecipeList.vue";

export default {
  name: 'MyRecipes',
  components: {
    RecipeList,
  }

}
</script>

<style>

</style>