<template>
    <div class="card">
      <div class="content">
        <div>
          <i v-if="object.sport == 'Soccer'" class="fas fa-futbol sport-icon"/>
          <i v-if="object.sport == 'Basketball'" class="fas fa-basketball-ball sport-icon"/>
          <i v-if="object.sport == 'Bowling'" class="fas fa-bowling-ball sport-icon"/>
          <i v-if="object.sport == 'Football'" class="fas fa-football-ball sport-icon"/>
          <i v-if="object.sport == 'Ping Pong'" class="fas fa-table-tennis sport-icon"/>
        </div>
        <div>
          <p class="sport-title">{{ object.sport }}</p>
        </div>
        <div>
          <img class="person-image" v-bind:src="person.picture.large"/>
          <div class="text">
            <span>Hello, I'm 
              <span v-if="object.admin"> {{ object.admin }}</span>
              <span v-else>{{ person.name.first }}</span>
              , join this game if you want to play {{ object.sport }} with me! </span>
          </div>
          <!-- get name from person here -->
          <p><i class="fas fa-clock date-icon"/>{{ object.date }}</p>
          <p><i class="fas fa-map-marker-alt location-icon"/>{{ object.place }}</p>
        </div> 
      </div>
      <div class="footer" @click="openSuccessModal('You joined the game!')">
        <p>Join Game</p>
      </div>    
    </div>
</template>

<script>
    export default {
        name: 'Card',
        props: ['object'],
        data() {
          return {
            person: {
              picture: {
                large: ''
              },
              name: {
                first: ''
              }
            }
          }
        },
        methods: {
          openSuccessModal(value) {
            this.$emit('showSuccessModal', value)
          }
        },
        mounted() {
          // get pictures of women
          fetch('https://randomuser.me/api/?inc=picture,name&noinfo&gender=female')
          .then(response => {
            response.json()
            .then(response => {
              this.person = response.results[0]
              console.log(this.person)
            })
          })
        }
    }
</script>

<style lang="scss" scoped>
.card {
    display: flex;
    flex-direction: column;
    width: 30rem;
    transition: transform .2s;
    margin: 3rem auto 3rem auto;
    text-align: center;
    box-shadow: 10px 10px 24px -5px rgba(0,0,0,0.75);;
    border-radius: 1rem;
    background: white;
    i {
      color: #5407AE;
    }
    .date-icon, .location-icon {
      color: #5407AE;
      font-size: 1.2rem;
      margin-right: .5rem;
    }
    .sport-icon {
      font-size: 2rem;
    }
    .sport-title {
      font-weight: bold;
      font-size: 2rem;
      margin: .5rem;
    }
    .text {
      text-align: center;
      margin: auto;
    }
    .person-image {
        margin: -9rem 0rem 0rem -19rem;
        border: .25rem solid white;
        border-radius: 50%;
        position: absolute;
    }
    .content {
      padding: 1rem;
    }
    .footer {
      background: #5407AE;
      margin-bottom: 0;
      width: 100%;
      width: 30rem;
      border-radius: 0 0 1rem 1rem;
      color: rgb(247, 242, 203);
      font-family: 'Debug Free Trial';
      font-size: 1.5rem;
      box-sizing: border-box;
    }
     .footer:hover {
      background: #7014da;
      color: rgb(247, 242, 203);
      cursor: pointer;
    } 
}
.card:hover {
  transform: scale(1.1);
}
@media screen and (max-width: 450px) {
  .card {
    width: 15rem;
    .person-image {
      margin: -9rem 0rem 0rem -9.0rem;
      width: 100px;
    }
  }


}
</style>