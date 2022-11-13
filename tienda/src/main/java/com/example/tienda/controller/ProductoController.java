package com.example.tienda.controller;

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

import com.example.tienda.model.Producto;
import com.example.tienda.services.ProductoServices;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
    private ProductoServices servicio;
    
    @GetMapping
    public ResponseEntity<?> consultarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarProductoPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarProducto(id));
    }
    
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearProducto(producto));
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.eliminarProducto(id)); 
	}
    
    @PutMapping("/{id}")
	public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarProducto(producto));
	}
}