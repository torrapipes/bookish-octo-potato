<template>
    <div>
        <transition name="modal">
            <div class="modal-mask">
                <div class="modal-wrapper">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <i class="fas fa-check"></i><h1>{{ message }}</h1>
                            <button @click="closeModal()">Ok</button>
                        </div>
                    </div>
                </div>
            </div>
        </transition>
    </div>
</template>

<script>
    export default {
        name: 'SuccessModal',
        props: ['message'],
        methods: {
            closeModal() {
                this.$emit('closeModalSuccess', '')
                this.$emit('closeModal', '')
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
        button {
            margin-top: 1rem;
            background: #5407AE;
            color: rgb(247, 242, 203);
            border: none;
            border-radius: 2rem;
            text-align: center;
            padding: 1rem;
            font-family: 'Debug Free Trial';
            font-size: 1.5rem;
            width: 20rem;
        }
        button:hover {
            color: rgb(247, 242, 203);
            background: #7014da;
            cursor: pointer;
        }
        i {
            color: green;
            font-size: 2rem;
        }
    }
}
</style>