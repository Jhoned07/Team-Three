package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.tienda.model.Categoria;

@Service
public interface CategoriaServices {

	public Optional<Categoria> consultarCategoriaId(Long id);
	
	public List<Categoria> consultarTodas();
	
	public Categoria crearCategoria(Categoria categoria);
	
	public Categoria actualizarCategoria(Categoria categoria);
	
	public String eliminarCategoria(Long id);
	
	public Optional<Categoria> consultarCategoriaNombre(String nombre);
	
}
