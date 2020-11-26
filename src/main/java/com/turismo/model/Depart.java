package com.turismo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Departamento")
public class Depart{
	
	@Id
	private Long id;
	
	@NotNull
    @Column
	private int precio;
	
	@NotNull
    @Size(max = 100)
    @Column
	private String estado;
	
	@NotNull
    @Size(max = 100)
    @Column
	private String ciudad;
	
	@NotNull
    @Size(max = 100)
    @Column
	private String mantenimiento;
	
	@NotNull
    @Size(max = 100)
    @Column
	private String descripcion;
	
	@Column
	private byte[] foto;

    
    //---------------------------------------
    //            GETTER AND SETTER
    //---------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	
	
}
