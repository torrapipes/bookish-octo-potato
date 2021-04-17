<template>
  <div>
    <h1>{{ title }}</h1>
    <div v-for="game in games" v-bind:key="game.id">
      Sport: {{ game.sport }}
      Admin: {{ game.admin }}
      Place: {{ game.place }}
      Date: {{ game.date }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return  {
      title: '',
      games: ''
    }
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
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
