<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'MyRecipies', params: {id: this.$store.state.user.userId} }" v-if="$store.state.token != ''">My Recipies</router-link>
    </div>
    <router-view />
  </div>
</template>
