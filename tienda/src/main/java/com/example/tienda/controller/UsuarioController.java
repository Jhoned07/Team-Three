package com.example.tienda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Usuario;
import com.example.tienda.services.UsuarioServicesImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioServicesImpl service;

	@PostMapping
	public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
		if (usuario == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (usuario.getCorreo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Optional<Usuario> usuarioExistente = service.findByCorreo(usuario.getCorreo());
		Optional<Usuario> usuarioExist = service.findByCorreo(usuario.getCorreo());
		if (usuarioExistente.isEmpty() && usuarioExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(usuario));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	
	@GetMapping
	public ResponseEntity<?> buscarTodosLosUsuarios(){
		return ResponseEntity.status(HttpStatus.OK).body(service.finAll());
	}
	
	@GetMapping("/{correo}/{contrasena}")
	public ResponseEntity<?>  Login(@PathVariable String correo,@PathVariable String contrasena){
		Optional<Usuario> encontrado = service.findByCorreoAndContrasena(correo, contrasena);
		if(encontrado.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(encontrado.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/{correo}")
	public 	ResponseEntity<?> borrarUsuario(@PathVariable String correo) {
		Optional<Usuario> encontrado = service.findByCorreo(correo);
		if(encontrado.isPresent()) {
			;
			return ResponseEntity.status(HttpStatus.OK).body(service.deleteUsuario(correo));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}

