package com.example.tienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.model.Usuario;
import com.example.tienda.repository.UsuarioRepository;
import com.example.tienda.util.JWTUtil;

@Service
public class AuthServicesImpl implements AuthServices {
	@Autowired
	UsuarioRepository repositorio;

	@Override
	public String autenticacion(Usuario usuario) {
		Optional<Usuario> usuarioConsultado = repositorio.findByCorreoAndContrasena(usuario.getCorreo(), usuario.getContrasena());
			
		if(usuarioConsultado.isPresent()) {												
				usuario = usuarioConsultado.get();
				System.out.println(usuarioConsultado.get().getNombre());
				return JWTUtil.getJWToken(usuario.getCorreo(), "admin");
			}
		
		return null;
	}

}
