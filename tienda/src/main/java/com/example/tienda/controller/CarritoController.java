package com.example.tienda.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Carrito;
import com.example.tienda.model.Producto;
import com.example.tienda.services.CarritoServices;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {
	@Autowired
	private CarritoServices service;

	@PostMapping
	public ResponseEntity<?> createCarrito(@RequestBody Carrito carrito) {
		if (carrito == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (carrito.getCorreo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Optional<Carrito> usuarioExistente = service.findById(carrito.getCorreo());
		Optional<Carrito> usuarioExist = service.findById(carrito.getCorreo());
		if (usuarioExistente.isEmpty() && usuarioExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.createCarrito(carrito));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@DeleteMapping("/{correo}")
	public ResponseEntity<?> deleteCarrito(@PathVariable String correo) {
		Optional<Carrito> encontrado = service.findById(correo);
		if (encontrado.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(service.deleteCarrito(correo));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarCarritoProducto(@PathVariable Long id, @RequestBody Carrito carrito) {
		carrito.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(service.updateCarrito(carrito));
	}
	
	@PostMapping("/agregar/{correo}")
    public ResponseEntity<?> agregarProducto(@PathVariable String correo, @RequestBody Producto producto) {
        Optional<Carrito> carrito = service.findById(correo);
        ArrayList<Producto> productos = new ArrayList<>();
        if (carrito.isPresent()) {
            productos = carrito.get().getProductos();
            productos.add(producto);
            carrito.get().setProductos(productos);
            return ResponseEntity.status(HttpStatus.CREATED).body(service.updateCarrito(carrito.get()));
        } else {
                Carrito carritoNuevo= new Carrito(null, "", null, "");
                productos.add(producto);
                carritoNuevo.setCorreo(correo);
                carritoNuevo.setEstado("creado");
                carritoNuevo.setProductos(productos);
                return ResponseEntity.status(HttpStatus.CREATED).body(service.createCarrito(carritoNuevo));
        }
    }
	
	@PostMapping("/eliminar/{correo}")
	public ResponseEntity<?> eliminarProducto(@PathVariable String correo,@RequestBody Producto producto){
		Optional<Carrito> carrito = service.findById(correo);
		if(carrito.isPresent()) {
			ArrayList<Producto> productos= carrito.get().getProductos();
			productos.remove(producto);
			carrito.get().setProductos(productos);
			return ResponseEntity.status(HttpStatus.CREATED).body(service.updateCarrito(carrito.get()));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{correo}")
	public ResponseEntity<?> buscarCarrito(@PathVariable String correo) {
		Optional<Carrito> encontrado = service.findById(correo);
		if (encontrado.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(correo));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	

}
