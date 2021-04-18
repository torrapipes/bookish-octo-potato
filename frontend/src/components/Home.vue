<template>
  <div class="container">
    <h1>{{ title }}</h1>
    <button @click="showModal = true">
      <h2>NEW GAME</h2>
    </button>
    <Modal v-if="showModal" @success="showSuccessModal = true" @closeModal="showModal = false"></Modal>
    <SuccessModal></SuccessModal>
    <Card v-for="game in games" v-bind:key="game.id" v-bind:object="game"></Card>
  </div>
</template>

<script>
import Card from './Card.vue'
import Modal from './Modal.vue'
import SuccessModal from './SuccessModal.vue'

export default {
  name: 'Home',
  data() {
    return  {
      title: 'GAMES',
      games: '',
      showModal: false,
      showSuccessModal: false
    }
  },
  components: {
    Card,
    Modal,
    SuccessModal
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
  align-items: center;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  h1 {
    color: rgb(247, 242, 203);
    font-size: 8rem;
    font-family: "Debug free trial";
    letter-spacing: 1rem;
    margin-bottom: 1rem;
  }
  button {
    margin: 2rem 0 2rem 0;
    width: 30rem;
    background: rgb(0, 0, 0);
    font-family: 'Debug Free Trial';
    font-size: 2rem;
    transition: transform .2s;
    padding: 0rem;
    border-radius: 1rem;
    border: none;
    box-shadow: 10px 10px 24px -5px rgba(0,0,0,0.75);
    color: rgb(247, 242, 203);;
  }
  button:hover {
    transform: scale(1.1);
  }
}
@media screen and (max-width: 450px) {
  .card {
    display: unset;
  }
  h1 {
    font-size: 5rem;
    letter-spacing: normal !important;
  }
  button {
    width: 13rem !important;
    font-size: 1.5rem !important;
  }
}
</style>
