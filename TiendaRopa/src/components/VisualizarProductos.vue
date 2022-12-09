<template>
    <div class="container">
        <div class="row">
            <div v-for="producto in productos" class="col-xs-12 col-md-6 col-lg-3 my-3">
                <div v-if="(producto.categoria == categoria)" class="card">
                    <img :src="images + producto.id + '.jpg'" class="card-img-top" alt="...">
                    <div class="card-body d-grid ">
                        <h5 class="card-title mb-0">{{ producto.descripcion }}</h5>
                        <ul class="mb-0">
                            <li class="card-text">Talla{{ ' ' + producto.talla }}</li>
                            <li class="card-text">Precio: $ {{ producto.precio }}</li>
                        </ul>
                        <button class="btn btn-dark">COMPRAR</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    props: {
        categoria: String
    },
    data() {
        return {
            titulo: "Camiseta",
            url: 'http://150.136.93.126:8080/tiendaropa/api/productos',
            productos: [],
            images: 'http://150.136.93.126:8080/images/'
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
    },
}
</script>
<style>
</style>