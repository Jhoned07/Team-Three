package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.tienda.model.Usuario;

@Service
public interface UsuarioServices {
	public Usuario createUser(Usuario usuario);

	public Usuario updateUsuario(Usuario usuario);

	public Boolean deleteUsuario(Long id);
	
	public Optional<Usuario>  findByCorreoAndContrasena(String correo,String contrasena);
	
	public List<Usuario> finAll();
	
	public List<Usuario> findAllByTipo(Integer tipoUsuario);
	
	public Optional<Usuario> findByCorreo(String correo);
	
	public Optional<Usuario> findById(Long id);
}
