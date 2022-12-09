<template>
    <div class="modal fade" id="modalregistrar" tabindex="-1" aria-hidden="true" aria-labelledby="modaltitle">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modaltitle">Registro de Clientes</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mx-5" role="form" name="frm_registro" action="" enctype="multipart/form-"
                        autocomplete="off">
                        <div class="form-group mb-3">
                            <input v-model="nombre" type="text" class="form-control" id="nombre"
                                placeholder="Nombre completo">
                        </div>
                        <div class="form-group mb-3">
                            <input v-model="correo" type="email" class="form-control" placeholder="Email">
                        </div>
                        <div class="form-group mb-4">
                            <input v-model="contraseña" type="password" class="form-control" placeholder="Contraseña">
                        </div>
                        <div class="checkbox mb-3">
                            <label><input type="checkbox"> He leído y acepto los terminos y
                                condiciones</label>
                        </div>
                        <div class="d-grid gap-2 col-6 mx-auto mb-5">
                            <button data-bs-dismiss="modal" class="btn btn-dark" @click="crearPersona">Registrarse
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            url: "http://150.136.93.126:8080/tiendaropa/api/usuarios",
            nombre: '',
            correo: '',
            contraseña: ''
        }
    },
    methods: {
        crearPersona() {
            const opciones = {
                method: 'POST',
                headers: {
                    'Content-Type': "application/json",
                    'Cache-Control': 'no-cache'
                },
                body: JSON.stringify({
                    nombre: this.nombre,
                    correo: this.correo,
                    contrasena: this.contraseña,
                })
            };
            fetch(this.url, opciones).then(async (response) => {
                console.log(response);
                console.log(response.status);
                if (response.ok) {

                    const respuesta = await response.json();
                    console.log(respuesta);
                    this.limpiarFormulario();
                } else {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
            })
        },
        limpiarFormulario() {
            this.nombre = '';
            this.correo = '';
            this.contraseña = '';
        }
    }
}
</script>
<style>

</style>