package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.model.Usuario;
import com.example.tienda.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioRepository repositorio;

	@Override
	public Usuario createUser(Usuario usuario) {
		return repositorio.insert(usuario);

	}
	@Override
	public Optional<Usuario> findById(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		if (usuario == null) {
			return null;
		}
		if (usuario.getId() == null) {
			return null;
		}
		Optional<Usuario> usuarioExistente = repositorio.findById(usuario.getId());
		if (usuarioExistente.isPresent()) {
			return repositorio.save(usuario);

		} else {
			return null;
		}
	}

	@Override
	public Boolean  deleteUsuario(Long id) {

		Optional<Usuario> usuarioExistente = repositorio.findById(id);
		if (usuarioExistente.isPresent()) {
			repositorio.delete(usuarioExistente.get());
			return true;
		}
		return false;
	}

	@Override
	public Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena) {
		return repositorio.findByCorreoAndContrasena(correo, contrasena);
	}

	@Override
	public List<Usuario> finAll() {
		return repositorio.findAll();
	}

	@Override
	public List<Usuario> findAllByTipo(Integer tipoUsuario) {
		return repositorio.findByTipoUsuario(tipoUsuario);
	}

	@Override
	public Optional<Usuario>  findByCorreo(String correo) {
		return repositorio.findByCorreo(correo);
	}



}
