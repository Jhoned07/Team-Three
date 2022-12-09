<template>
    <button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#modalcarrito"
        @click="consultarCarrito">Carrito</button>
    <div class="modal fade" id="modalcarrito" tabindex="-1" aria-hidden="true" aria-labelledby="modaltitle">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h1 class="mb-3 text-center">Carrito de compras</h1>
                    <table class="table table-secondary table-hover">
                        <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Precio</th>
                                <th>Talla</th>
                            </tr>
                        </thead>
                        <tbody>
                            <div v-for="producto in carrito">
                                <tr>
                                    <td>{{ producto.descripcion }}</td>
                                    <td>{{ producto.precio }}</td>
                                    <td>{{ producto.talla }}</td>
                                </tr>
                            </div>
                        </tbody>
                    </table>
                    <div class="d-grid gap-2 col-6 mx-auto mb-5">
                        <button data-bs-dismiss="modal" class="btn btn-dark" @click="pagarCarrito">Pagar
                        </button>
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
            correo: "",
            carrito: [],
            url: "",
            token: ""

        }
    },
    methods: {
        consultarCarrito() {
            console.log(url);
            const opciones = {
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                    'Authorization': "Bearer " + token
                },

            };
            fetch(this.url, opciones).then(async (response) => {
                if (response.ok) {
                    this.carrito = await response.json();
                    console.log(this.productos);
                }
                else {
                    alert("Inicia sesion para ver tu carrito");
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
            })
        },
        pagarCarrito() {
            prompt("Ingresa el numero de tu tarjeta");
            console.log(token)
        }
    },
}

</script>
<style>

</style>