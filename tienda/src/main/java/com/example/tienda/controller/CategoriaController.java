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

import com.example.tienda.model.Categoria;
import com.example.tienda.services.CategoriaServices;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaServices servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodo(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarTodas()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarCategoriaPorId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarCategoriaId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearCategoria(categoria));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.eliminarCategoria(id)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarCategoria(categoria));
	}
}






