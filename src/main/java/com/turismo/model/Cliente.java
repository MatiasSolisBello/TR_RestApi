package com.turismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Cliente")
public class Cliente {
	@Id
	private int rut;
	@Column
	private String nombre;
	@Column
	private String correo;
	@Column
	private String telefono;
	@Column
	private String password;
	
	public Cliente() {
			
	}

	public Cliente(int rut, String nombre, String correo, String telefono, String password) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
