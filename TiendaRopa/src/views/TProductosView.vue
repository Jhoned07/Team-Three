<template>
    <div class="container-fluid my-5">
                <div class="row">
                    <div class="col-2"></div>
                    <div class="col-8">
                        <h1 class="mb-3 text-center">Listado de Productos</h1>
                        <table class="table table-secondary table-hover">
                            <thead>
                                <tr>
                                  <th>ID</th>
                                  <th>Producto</th>
                                  <th>Precio</th>
                                  <th>Talla</th>
                                  <th>Categoria</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="producto in productos">
                                    <td>{{ producto.id }}</td>
                                    <td>{{ producto.descripcion }}</td>
                                    <td>{{ producto.precio }}</td>
                                    <td>{{ producto.talla }}</td>
                                    <td>{{ producto.categoria }}</td>
                                </tr>
                            </tbody>
                        </table> 
                    </div> 
                    <div class="col-2"></div>
                </div> 
            </div>   
</template>

<script>
export default {
    data() {
        return {
            url: 'http://150.136.93.126:8080/tiendaropa/api/productos',
            productos: [],
        }
    },
    methods: {
        consultarProductos() {
            const opciones = {
                method: 'GET',
                headers: {
                    'Content-Type': "application/json",
                    // 'Authorization': "Basic dXNlcjo0YmY0YTg5MS1mMDM4LTRmZTEtYjk3Yi1mZmU3ZjlhNjMzNjc="
                }
            };
            fetch(this.url, opciones).then(async (response) => {
                if (response.ok) {
                    this.productos = await response.json();
                    console.log(this.productos);
                }
                else {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
            })
        }
    },
    beforeMount() {
        this.consultarProductos();
    }
}
</script>

<style>

</style>