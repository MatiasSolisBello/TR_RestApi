package com.turismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	private int rut;
	
	@Column
	private String nombre;
	
	@Column
	private String correo;
	
	@Column
	private String password;
	
	public Admin() {
		
	}

	public Admin(int rut, String nombre, String correo, String password) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.correo = correo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
