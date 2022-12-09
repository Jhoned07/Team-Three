<template>
    <div class="container">
        <div class="row justify-content-center">
            <!-- <div class="col my-5">
                <div class="card" style="width: 15rem;">
                    <img src="../assets/icons/editar_productos.jpg" class="card-img-top" alt="...">
                    <div class="card-body d-grid gap-2">
                        <h5 class="card-title text-center">Editar productos</h5>
                        <a class="btn btn-dark" href="#" role="button">EDITAR</a>
                    </div>
                </div>
            </div> -->
            <!-- <div class="my-5 col justify-content-center "> -->
                <div class="card m-5" style="width: 15rem;">
                    <img src="../assets/icons/agregar_usuarios.jpg" class="card-img-top" alt="...">
                    <div class="card-body d-grid gap-2">
                        <h5 class="card-title text-center">Crear usuarios</h5>
                        <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                            data-bs-target="#modalregistrarusuarios">CREAR</button>
                        <div class="modal fade" id="modalregistrarusuarios" tabindex="-1" aria-hidden="true"
                            aria-labelledby="modaltitle">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="modaltitle">Registro de usuarios</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form class="mx-5" role="form" name="frm_registro_usuarios" method="post"
                                            action="" enctype="multipart/form-" autocomplete="off">
                                            <div class="form-group mb-3">
                                                <input type="text" name="nombre" class="form-control"
                                                    placeholder="Nombre completo">
                                            </div>
                                            <div class="form-group mb-3">
                                                <input type="text" name="documento" class="form-control"
                                                    placeholder="Documento de Identdicación">
                                            </div>
                                            <div class="form-group mb-3">
                                                <input type="email" name="email" class="form-control"
                                                    placeholder="Email">
                                            </div>
                                            <div class="form-group mb-4">
                                                <input type="password" name="contraseña" class="form-control"
                                                    placeholder="Contraseña">
                                            </div>
                                            <div class="d-grid gap-2 col-6 mx-auto mb-5">
                                                <a href="#" class="btn btn-dark" role="button">CREAR</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            <!-- </div>
            <div class="col my-5"> -->
                <div class="card m-5" style="width: 15rem;">
                    <img src="../assets/icons/lista_productos.jpg" class="card-img-top" alt="...">
                    <div class="card-body d-grid gap-2">
                        <h5 class="card-title text-center">Lista de productos</h5>
                        <RouterLink class="btn btn-dark" to="/tablaproductos" @click="consultarProductos">
                            <button class="btn btn-dark" @click="consultarProductos" role="button">VER</button>
                        </RouterLink>
                        
                    </div>
                </div>
            <!-- </div> -->
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            titulo: "Personas"
        }
    }
}
</script>

<style>

</style>