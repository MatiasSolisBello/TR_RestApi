package com.turismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Servicios")
public class Servicio {
	@Id
	private int id_servicio;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private int precio;
	
	public Servicio() {
		
	}

	public Servicio(int id_servicio, String nombre, String descripcion, int precio) {
		super();
		this.id_servicio = id_servicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	

}
