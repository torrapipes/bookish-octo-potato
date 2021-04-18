<template>
  <div class="app-container">
    <Home/>
  </div>
</template>

<script>
import Home from './components/Home.vue'

export default {
  name: 'App',
  components: {
    Home
  }
}
</script>

<style>
body {
  background: rgb(2,0,36);
  background: linear-gradient(42deg, rgba(2,0,36,1) 0%, rgba(20,2,55,1) 0%, rgba(80,9,121,1) 35%, rgba(90,4,249,1) 97%);
}
</style>
