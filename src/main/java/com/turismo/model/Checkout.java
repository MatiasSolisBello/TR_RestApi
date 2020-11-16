package com.turismo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Checkout")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

public class Checkout implements Serializable{
private static final long serialVersionUID = 1L;
	
	
	@Id
	private int id;
	@Column
	private String estado;
	@Column
	private String multa;
	@Column
	private String problemas;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reserva", nullable = false)
    @JsonIgnore
    private Reserva reserva;
	
	

	public Checkout() {
		super();
	}



	public Checkout(int id, String estado, String multa, String problemas, Reserva reserva) {
		super();
		this.id = id;
		this.estado = estado;
		this.multa = multa;
		this.problemas = problemas;
		this.reserva = reserva;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getMulta() {
		return multa;
	}



	public void setMulta(String multa) {
		this.multa = multa;
	}



	public String getProblemas() {
		return problemas;
	}



	public void setProblemas(String problemas) {
		this.problemas = problemas;
	}



	public Reserva getReserva() {
		return reserva;
	}



	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	
	
}
