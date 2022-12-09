package com.example.tienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.model.Carrito;
import com.example.tienda.repository.CarritoRepository;

@Service
public class CarritoServicesImpl implements CarritoServices {
	@Autowired
	private CarritoRepository repositorio;
	
	@Override
	public Carrito createCarrito(Carrito carrito) {
		Carrito creado = repositorio.insert(carrito);
		return creado;
	}

	@Override
	public Carrito updateCarrito(Carrito carrito) {
		if (carrito == null) {
			return null;
		}
		if (carrito.getCorreo() == null) {
			return null;
		}
		Optional<Carrito> carritoExistente = repositorio.findByCorreo(carrito.getCorreo());
		if (carritoExistente.isPresent()) {
			return repositorio.save(carrito);

		} else {
			return null;
		}
	}

	@Override
	public String deleteCarrito(String correo) {
		Optional<Carrito> carritoExistente = repositorio.findById(correo);
		if (carritoExistente.isPresent()) {
			repositorio.delete(carritoExistente.get());
			return "borrado";
		}
		return "no borrado";
	}
	
	@Override
	public Optional<Carrito> findById(String correo) {
		return repositorio.findById(correo);
	}

}
