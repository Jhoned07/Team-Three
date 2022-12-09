package com.example.tienda.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.tienda.util.ERol;
@Document("usuarios")
public class Usuario {

	@Id
	private String correo;
	private String nombre;
	private String contrasena;
	private ERol[] roles;

	public Usuario(String correo, String nombre, String contrasena, ERol[] roles) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.roles = roles;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public ERol[] getRoles() {
		return roles;
	}

	public void setRoles(ERol[] roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contrasena, correo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contrasena, other.contrasena) && Objects.equals(correo, other.correo)
				&& Objects.equals(nombre, other.nombre);
	}

}