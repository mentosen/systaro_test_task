<template>
  <div id="app">
    <button class="btn btn_margin-right" @click="pushByRoute('/')">Task 1</button>
    <button class="btn btn_margin-right" @click="pushByRoute('/task/2')">Task 2</button>
    <button class="btn" @click="pushByRoute('/task/3')">Task 3</button>
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  methods: {
    pushByRoute(path){
      this.$router.push(path);
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-top: 30px;
}
</style>
