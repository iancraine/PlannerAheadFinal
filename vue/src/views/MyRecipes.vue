<template>
<div>
    <my-recipes v-bind:userId="this.$route.params.this.userId"/>
</div>
</template>

<script>
import MyRecipes from "../components/MyRecipes.vue";

export default {
    name: 'MyRecipes',
  components: {
    MyRecipes,
  }

}
</script>

<style>

</style>