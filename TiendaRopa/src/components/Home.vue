<template>
    <div>
        <div
            class="jumbotron bg-jumbotron d-flex flex-column justify-content-center align-items-center  text-white text-center">
            <h1 class="display-1 text-capitalize w-75"><strong>Colección de Verano</strong></h1>
            <p class="lead w-75" style="font-size: 25px;">
                Encuentra todo lo necesario en camisetas para que disfrutes de un verano inolvidable
            </p>
            <RouterLink class="btn btn-light text-black" to="/catalogo" style="width: 150px;">Ver más</RouterLink>
        </div>
    </div>

</template>

<script>
import { RouterLink } from 'vue-router';
export default {
    data() {
        return {

        }
    }
}
</script>

<style>
.bg-jumbotron {
    background-image: url('http://150.136.93.126:8080/images/Principal.jpg');
    background-size: cover;
    background-position: center;
    height: 100vh;
}
</style>