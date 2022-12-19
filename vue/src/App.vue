<template>
  <div id="app">
    <PizzaComp />
  </div>
</template>

<script>

import PizzaComp from './components/PizzaComp.vue';

export default {
  name: 'App',
  components: {
    PizzaComp
  }
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
