<template>
<div>
    <my-recipies v-bind:userId="this.$route.params.this.userId"/>
</div>
</template>

<script>
import MyRecipies from "../components/MyRecipes.vue";

export default {
    name: 'MyRecipies',
  components: {
    MyRecipies,
  }

}
</script>

<style>

</style>