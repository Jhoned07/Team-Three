package com.example.tienda.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Producto;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, Long>{
	
	@Query("{descripcion:'?0'}")
	public List<Producto> findByDescripcion(String descripcion);
	
	@Query("{id:'?0',descripcion:'?1'}")
	public List<Producto> findByIdAndDescription(Long id, String descripcion);

}