package com.example.tienda.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.model.Usuario;
import com.example.tienda.services.AuthServices;

@RestController
@RequestMapping("/api/token")
public class AuthController {
	@Autowired
	AuthServices servicio;

	@PostMapping
	public ResponseEntity<?> autenticacion(@RequestBody Usuario usuario) {
		String respuesta = servicio.autenticacion(usuario);
		if (respuesta == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body((new JSONObject().put("token", respuesta)).toString());
	}

}
