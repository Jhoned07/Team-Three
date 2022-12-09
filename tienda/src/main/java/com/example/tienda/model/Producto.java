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
	private String categoria;

	public Producto(Long id, String descripcion, Double precio, String talla, String categoria) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.talla = talla;
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descripcion, id, precio, talla);
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
		return Objects.equals(categoria, other.categoria) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(id, other.id) && Objects.equals(precio, other.precio)
				&& Objects.equals(talla, other.talla);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", talla=" + talla
				+ ", categoria=" + categoria + "]";
	}
}
