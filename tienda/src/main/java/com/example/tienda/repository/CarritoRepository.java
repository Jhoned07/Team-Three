package com.example.tienda.repository;

import org.springframework.stereotype.Repository;

import com.example.tienda.model.Carrito;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface CarritoRepository extends MongoRepository<Carrito,String>{
	@Query("{correo:'?0'}")
	public Optional<Carrito> findByCorreo(String correo);
}
