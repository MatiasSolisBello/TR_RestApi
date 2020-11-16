package com.turismo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Departamento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

public class Depart implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_depart;
	@Column
	private int precio;
	@Column
	private String estado;
	@Column
	private String ciudad;
	@Column
	private String mantenimiento;
	@Column
	private String descripcion;
	@Column
	private byte[] foto;
	
	@OneToMany(mappedBy = "depart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Reserva> reserva;
	
	

	public Depart() {
	}



	public Depart(int id_depart, int precio, String estado, String ciudad, String mantenimiento, String descripcion,
			byte[] foto, Set<Reserva> reserva) {
		super();
		this.id_depart = id_depart;
		this.precio = precio;
		this.estado = estado;
		this.ciudad = ciudad;
		this.mantenimiento = mantenimiento;
		this.descripcion = descripcion;
		this.foto = foto;
		this.reserva = reserva;
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



	public String getMantenimiento() {
		return mantenimiento;
	}



	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public byte[] getFoto() {
		return foto;
	}



	public void setFoto(byte[] foto) {
		this.foto = foto;
	}



	public Set<Reserva> getReserva() {
		return reserva;
	}



	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}
	
	
	
	
}
