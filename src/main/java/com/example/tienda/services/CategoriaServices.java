package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import com.example.tienda.model.Categoria;

public interface CategoriaServices {

	public Optional<Categoria> consultarCategoria(Long id, String descripcion);
	
	public List<Categoria> consultarTodas();
	
	public Categoria crearCategoria(Categoria categoria);
	
	public Categoria actualizarCategoria(Categoria categoria);
	
	public String eliminarCategoria(Long id);
	
}
