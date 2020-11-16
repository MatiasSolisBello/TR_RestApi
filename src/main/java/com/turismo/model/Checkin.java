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
@Table(name = "Checkin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

public class Checkin implements Serializable{
private static final long serialVersionUID = 1L;
	
	
	@Id
	private int id;
	@Column
	private String condiciones;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reserva", nullable = false)
    @JsonIgnore
    private Reserva reserva;
	
	

	public Checkin() {
		super();
	}

	public Checkin(int id, String condiciones, Reserva reserva) {
		super();
		this.id = id;
		this.condiciones = condiciones;
		this.reserva = reserva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
}
