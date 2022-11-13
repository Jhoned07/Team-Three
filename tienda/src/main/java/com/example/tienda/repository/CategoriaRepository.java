package com.example.tienda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, Long> {

}
