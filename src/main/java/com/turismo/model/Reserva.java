package com.turismo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Reserva")
public class Reserva {
	@Id
	private int id_reserva;
	@Column
	private int precio_total;
	@Column
	private String descripcion;
	@Column
	private String fecha_llegada;
	@Column
	private String fecha_salida;
	
	//private List<Cliente> Cliente = new ArrayList<Cliente>();
	//private List<Servicio> Servicio = new ArrayList<Servicio>();
	//private List<Depart> Departamento = new ArrayList<Depart>();
	
	public Reserva() {}
	
	
}
