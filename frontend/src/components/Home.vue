<template>
  <div class="container">
    <h1>{{ title }}</h1>
    <Card v-for="game in games" v-bind:key="game.id" v-bind:object="game"></Card>
  </div>
</template>

<script>
import Card from './Card.vue'
export default {
  name: 'Home',
  data() {
    return  {
      title: 'GAMES',
      games: ''
    }
  },
  components: {
    Card
  },
  mounted() {
    // list games
    fetch('http://localhost:8080/getGames')
      .then( response => {
        return response.json()
      })
      .then( data => {
          this.games = data
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
.container {
  display: flex;
  flex-direction: column;
  text-align: center;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  h1 {
    color: rgb(247, 237, 151);
    font-size: 4rem;
  }
}
</style>
