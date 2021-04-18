<template>
    <div>
        <transition name="modal">
            <div class="modal-mask">
                <div class="modal-wrapper">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button class="button close" @click="closeModal()">
                                    <i class="fas fa-times"/>
                                </button>
                                <h1 class="modal-title">Create a game</h1>
                                <div class="modal-body">
                                    <form class="form-group">
                                        <!-- Sport -->
                                        <div class="select">
                                            <select v-model="sport">
                                                <option disabled selected>Choose sport</option>
                                                <option value="Basketball">Basketball</option>
                                                <option value="Soccer">Soccer</option>
                                                <option value="Ping Pong">Ping Pong</option>
                                                <option value="Bowling">Bowling</option>
                                                <option value="Football">Football</option>
                                            </select>
                                        </div>
                                        <!-- Admin -->
                                        <div>
                                            <input type="text" placeholder="Your Name" v-model="admin" name="admin">
                                        </div>
                                        <!-- Place -->
                                        <div>
                                            <input type="text" placeholder="Location of the game" v-model="place" name="place">
                                        </div>
                                        <!-- Date -->
                                        <div>
                                            <label for="date">When are you playing?</label>
                                            <tr/>
                                            <input type="date" v-model="date" name="date">  
                                        </div>
                                    </form>
                                </div>
                                <div align="center">
                                    <input class="button" @click="submit()" value="POST GAME">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </transition>
    </div>
</template>

<script>
    export default {
        name: 'Modal',
        data() {
            return {
                admin: '',
                sport: 'Choose sport',
                place: '',
                date: ''
            }
        },
        methods: {
            closeModal() {
                this.$emit('closeModal', '')
            },
            submit() {
                // building game object
                let game = {
                    'admin': this.admin,
                    'sport': this.sport,
                    'place': this.place,
                    'date': this.date
                }

                const requestOptions = {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(game)
                };
                fetch("http://localhost:8080/createGame", requestOptions)
                    .then(response => response.json())
                    .then(data => {
                        console.log("Post response:", data)
                        this.$emit('success', "Game has been created")
                    })
                    .catch(error => {
                        console.error('Erroor', error)
                    }) 
            }
        }
    }
</script>

<style lang="scss" scoped>
.modal-mask {
    position: fixed;
    z-index: 9998;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0,0,0,.5);
    display: table;
    transition: opacity .3s ease;
    .modal-wrapper {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
    }
    .modal-dialog {
        background: white;
        padding: 1rem;
        border-radius: 1rem;
        box-shadow: 10px 10px 24px -5px rgba(0,0,0,0.75);
        .modal-title {
            font-family: 'Debug Free Trial';
            letter-spacing: .5rem;
        }
        .button {
            margin-top: 1rem;
            background: #5407AE;
            color: rgb(247, 242, 203);
            border: none;
            border-radius: 2rem;
            text-align: center;
            padding: 1rem;
            font-family: 'Debug Free Trial';
            font-size: 2rem;
        }
        .button:hover {
            color: rgb(247, 242, 203);
            background: #7014da;
            cursor: pointer;
        }
        .close {
            width: 1rem;
            font-size: 1rem;
            height: 1rem;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: auto; 
        }
        .form-group {
            width: 30rem;
            padding: 1rem;
            display: flex;
            flex-direction: column;
            .select {
                position: relative;
                font-family: Arial;
                width: 30rem;
                select {
                    width: 30rem;
                    font-size: 1.5rem;
                    color: gray;
                    margin-bottom: 1rem;
                    border: none;
                    border-bottom: 1px solid black;
                    option {
                        font-family: FontAwesome, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                    }
                }
            }
            input {
                margin-bottom: 1rem;
            }
            input[type="text"] {
                border: none;
                border-bottom: 1px solid black;
                width: 30rem;
                font-size: 1.5rem;
            }
            label {
                font-size: 1.5rem;
            }
            input[type="date"] {
                font-size: 1rem;
                margin-top: 1rem;
            }
        }
    }
}

@media screen and (max-width: 450px) {

    .form-group {
        width: 14rem !important;
        .select {
            font-size: 1rem !important;
            width: 14rem !important;
            select {
                width: 14rem !important;
                font-size: 1rem !important;
            }
        }
        input[type="text"] {
            font-size: 1rem !important;
            width: 14rem !important;
        }
        label {
            font-size: 1rem !important;
        }
    }
    .button {
        width: 13rem;
    }

}

</style>