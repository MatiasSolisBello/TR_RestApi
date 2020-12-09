package com.turismo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Servicio")
public class Servicio{
	
	@Id
	private Long id;
	
    @NotNull
    @Size(max = 100)
    @Column
	private String nombre;
    
    @NotNull
    @Size(max = 100)
    @Column
	private String descripcion;
    
    @NotNull
    @Column
	private int precio;

    
    //---------------------------------------
    //            GETTER AND SETTER
    //---------------------------------------
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
