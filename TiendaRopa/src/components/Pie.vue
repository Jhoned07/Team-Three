<template>
    <div>
        <div class="row p-5 bg-dark text-white">
            <div class="col-xs-12 col-md-6 col-lg-3">
                <p class="h3">{{ nombreTienda }}</p>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <p class="h5 mb-3">CONTACTO</p>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#">300 000 00 00</a>
                </div>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#"><strong>PBX: </strong>01 8000 00 00 00</a>
                </div>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#">Escríbenos</a>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <p class="h5 mb-3">AYUDA</p>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#">Envíos</a>
                </div>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#">Cambios y garantías</a>
                </div>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#">Preguntas frecuentes</a>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <p class="h5 mb-3">SIGUENOS</p>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#">Facebook</a>
                </div>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#">Instagram</a>
                </div>
                <div class="mb-2">
                    <a class="text-secondary text-decoration-none" href="#">Pinterest</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            nombreTienda: "TiendaRopa",
        }
    }
}
</script>
<style>

</style>