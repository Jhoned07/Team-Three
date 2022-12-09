package com.example.tienda.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, Long> {
	
	@Query("{nombre:'?0'}")
	public Optional<Categoria> consultarCategoriaNombre(String nombre);
}
