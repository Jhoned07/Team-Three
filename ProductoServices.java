package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import com.example.tienda.model.Producto;


public interface ProductoServices {
	public Producto crearProducto(Producto producto);
	public Producto actualizarProducto(Producto producto);
	public String eliminarProducto(Long id);
	public Optional<Producto> consultarProducto(Long id);
	public List<Producto> consultarTodos();

}
