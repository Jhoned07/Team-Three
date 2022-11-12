package com.example.tienda.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, Long> {

	@Query("{descripcion:'?0'}")
	public List<Categoria> findByNombre(String nombre);
}
