package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.model.Categoria;
import com.example.tienda.repository.CategoriaRepository;

@Service
public class CategoriaServicesImpl implements CategoriaServices {
	
	@Autowired
	private CategoriaRepository repositorio;
	
	@Override
	public Optional<Categoria> consultarCategoriaId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public List<Categoria> consultarTodas() {
		return repositorio.findAll();
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		if (categoria == null) {
			return null;
		}
		if (categoria.getId() == null) {
			return null;
		}
		Optional<Categoria> categoriaExistente = repositorio.findById(categoria.getId());
		if (categoriaExistente.isPresent()) {
			return categoriaExistente.get();
		}
		else {
			return repositorio.insert(categoria);
		}
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		if (categoria == null) {
			return null;
		}
		if (categoria.getId() == null) {
			return null;
		}
		Optional<Categoria> categoriaExistente = repositorio.findById(categoria.getId());
		if (categoriaExistente.isPresent()) {
			return repositorio.save(categoria);
		}
		else {
			return null;
		}
	}

	@Override
	public String eliminarCategoria(Long id) {
		if (id == null) {
			return "El codigo no puede ser Null";
		}
		Optional<Categoria> categoriaExistente = repositorio.findById(id);
		if (categoriaExistente.isPresent()) {
			repositorio.delete(categoriaExistente.get());
			return "La Categoria ha sido eliminada";
		}
		return "La Categoria no puede ser eliminada";
	}

	@Override
	public Optional<Categoria> consultarCategoriaNombre(String nombre) {
		return repositorio.consultarCategoriaNombre(nombre);
	} 
}
