package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.model.Producto;
import com.example.tienda.repository.ProductoRepository;

@Service
public class ProductoServicesImpl implements ProductoServices {

	@Autowired
	private ProductoRepository repositorio;

	@Override
	public Optional<Producto> consultarProducto(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Producto crearProducto(Producto producto) {
		if (producto == null) {
			return null;
		}
		if (producto.getId() == null) {
			return null;
		}
		Optional<Producto> productoExistente = repositorio.findById(producto.getId());
		if (productoExistente.isPresent()) {
			return productoExistente.get();
		} else {
			return repositorio.insert(producto);
		}
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		if (producto == null) {
			return null;
		}
		if (producto.getId() == null) {
			return null;
		}
		Optional<Producto> productoExistente = repositorio.findById(producto.getId());
		if (productoExistente.isPresent()) {
			return repositorio.save(producto);
		} else {
			return null;
		}
	}

	@Override
	public String eliminarProducto(Long id) {
		if (id == null) {
			return "el producto no pude ser eliminado";
		}
		Optional<Producto> productoExistente = repositorio.findById(id);
		if (productoExistente.isPresent()) {
			repositorio.delete(productoExistente.get());
			return "el producto ha sido eliminado";
		}
		return "el producto no pudo ser eliminado";
	}

	@Override
	public List<Producto> consultarTodos() {
		return repositorio.findAll();
	}

}