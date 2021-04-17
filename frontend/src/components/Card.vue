<template>
    <div class="card">
      <div>
        <i v-if="object.sport == 'Soccer'" class="fas fa-futbol"/>
        <i v-if="object.sport == 'Basketball'" class="fas fa-basketball-ball"/>
        <i v-if="object.sport == 'Bowling'" class="fas fa-bowling-ball"/>
        <i v-if="object.sport == 'Football'" class="fas fa-football-ball"/>
        <i v-if="object.sport == 'Ping Pong'" class="fas fa-table-tennis"/>

        {{ object.sport }} - {{ object.place }}
      </div>
      <div>
        <p>Hey There, come join me and let's play all together</p>
        <p>- {{ object.admin }}</p>
        Date: {{ object.date }}
      </div>     
    </div>
</template>

<script>
    export default {
        name: 'Card',
        props: ['object']
    }
</script>

<style lang="scss" scoped>
.card {
    width: 30rem;
    margin: 1rem auto 1rem auto;
    padding: 1rem;
    text-align: center;
    box-shadow: 10px 10px 24px -5px rgba(0,0,0,0.75);;
    border-radius: 1rem;
    background: white;
}
</style>