package com.example.tienda.services;

import java.util.Optional;

import com.example.tienda.model.Carrito;

public interface CarritoServices {
	public Carrito createCarrito(Carrito carrito);
	public Carrito updateCarrito (Carrito carrito);
	public String deleteCarrito (String correo);
	public Optional<Carrito> findById(String correo);
}
