package com.example.tienda.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("carritos")
public class Carrito {
	
	
	private Long id;
	@Id
	private String correo;
	private ArrayList<Producto> productos;
	private String estado;
	public Long getId() {
		return id;
	}
	
	public Carrito(Long id, String correo, ArrayList<Producto> productos, String estado) {
		super();
		this.id = id;
		this.correo = correo;
		this.productos = productos;
		this.estado = estado;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(correo, estado, id, productos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return Objects.equals(correo, other.correo) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(productos, other.productos);
	}
	@Override
	public String toString() {
		return "Carrito [id=" + id + ", correo=" + correo + ", productos=" + productos + ", estado=" + estado + "]";
	}

	
	
}	
