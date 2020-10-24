package com.turismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departamento")
public class Depart {
	@Id
	private int id_depart;
	@Column
	private int precio;
	@Column
	private String estado;
	@Column
	private String ciudad;
	@Column
	private String descripcion;
	@Column
	private String foto;
	
	public Depart() {
		
	}

	public Depart(int id_depart, int precio, String estado, String ciudad, String descripcion, String foto) {
		super();
		this.id_depart = id_depart;
		this.precio = precio;
		this.estado = estado;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.foto = foto;
	}

	public int getId_depart() {
		return id_depart;
	}

	public void setId_depart(int id_depart) {
		this.id_depart = id_depart;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
