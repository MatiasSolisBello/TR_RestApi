package com.turismo.model;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_reserva;
	@Column
	private int precio_total;
	@Column
	private String descripcion;
	@Column
	private LocalDate  fecha_llegada;
	@Column
	private LocalDate  fecha_salida;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false  )
	@JoinColumn(name = "cliente_rut", nullable=false)
	@JsonIgnore
    private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false  )
	@JoinColumn(name = "servicio_id_servicio", nullable=false)
	@JsonIgnore
    private Servicio servicio;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false  )
	@JoinColumn(name = "depart_id_depart", nullable=false)
	@JsonIgnore
    private Depart depart;
	
	
	public Reserva() {}
	
	


	public Reserva(int id_reserva, int precio_total, String descripcion, LocalDate fecha_llegada,
			LocalDate fecha_salida) {
		super();
		this.id_reserva = id_reserva;
		this.precio_total = precio_total;
		this.descripcion = descripcion;
		this.fecha_llegada = fecha_llegada;
		this.fecha_salida = fecha_salida;

	}




	public int getId_reserva() {
		return id_reserva;
	}


	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}


	public int getPrecio_total() {
		return precio_total;
	}


	public void setPrecio_total(int precio_total) {
		this.precio_total = precio_total;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDate getFecha_llegada() {
		return fecha_llegada;
	}


	public void setFecha_llegada(LocalDate fecha_llegada) {
		this.fecha_llegada = fecha_llegada;
	}


	public LocalDate getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(LocalDate fecha_salida) {
		this.fecha_salida = fecha_salida;
	}



	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Servicio getServicio() {
		return servicio;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	
	
}
