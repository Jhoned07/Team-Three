package com.example.tienda.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productos")
public class Producto {

	@Id
	private Long id;
	private String descripcion;
	private Double precio;
	private String talla;
	
	public Producto(Long id, String descripcion, Double precio, Long categoriaId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoriaId = categoriaId;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	private Long categoriaId;
	private Long estado;

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoriaId, descripcion, estado, id, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(categoriaId, other.categoriaId) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", categoriaId="
				+ categoriaId + "]";
	}
}
